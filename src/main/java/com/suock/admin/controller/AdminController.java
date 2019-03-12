package com.suock.admin.controller;

        import com.suock.admin.interceptor.WebSecurityConfig;
        import com.suock.admin.model.UrlPermission;
        import com.suock.admin.model.UrlPermissionParam;
        import com.suock.admin.model.User;
        import com.suock.admin.service.UrlPermissionService;
        import com.suock.admin.service.UserService;
        import com.suock.pub.helper.JSONStringHelper;
        import com.suock.pub.helper.StringHelper;
        import net.sf.json.JSONObject;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.domain.Sort;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.ResponseBody;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.util.*;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UrlPermissionService urlPermissionService;

    @RequestMapping(value = "/")
    public String index(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute(WebSecurityConfig.SESSION_KEY) != null) {
            return "admin/index";
        }
        Calendar cal = Calendar.getInstance();
        model.addAttribute("time", "2018 12 19");
        model.addAttribute("year", cal.get(Calendar.YEAR));
        return "index";
    }

    @RequestMapping(value = "/login.html")
    @ResponseBody
    public String loginIn(HttpServletRequest request, @RequestParam("userName") String userName, @RequestParam("passwd") String passwd) {
        JSONObject json = new JSONObject();
        User user = userService.getUserByUserName(userName);
        if (user != null) {
            if (user.getPasswd().equals(StringHelper.md5Password(passwd))) {
                json.put("result", true);
                json.put("msg", "success");
                request.getSession().setAttribute(WebSecurityConfig.SESSION_KEY, user);
            } else {
                json.put("result", false);
                json.put("msg", "用户名或密码错误");
            }
        } else {
            json.put("result", false);
            json.put("msg", "用户名或密码错误");
        }
        return json.toString();
    }

    @RequestMapping(value = "/admin/loginOut.html")
    public String loginOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().invalidate();
        response.sendRedirect("/");
        return null;
    }

    @RequestMapping(value = "/admin/index.html")
    public String adminIndex(HttpServletRequest request, Model model) {
        Calendar cal = Calendar.getInstance();
        model.addAttribute("time", "2018 12 19");
        model.addAttribute("year", cal.get(Calendar.YEAR));
        return "admin/index";
    }

    @RequestMapping(value = "/admin/apiList.html")
    public String apiList(HttpServletRequest request,ModelMap modelMap){
        Sort sort = new Sort(Sort.Direction.DESC,"url"); //创建降序排序
        Pageable pageable =  new PageRequest(getPage(request),10,sort);
        Page<UrlPermission> list=urlPermissionService.getAllURlByPage(pageable);
        modelMap.addAttribute("data",list);
        return "admin/api/list";
    }
    @RequestMapping(value = "/admin/changeApiStatus.html")
    @ResponseBody
    public String changeApiStatus(@RequestParam("url")String url,@RequestParam("status")Integer status){
        try {
            UrlPermission urlPermission=urlPermissionService.find(url);
            urlPermission.setStatus(status);
            urlPermissionService.save(urlPermission);
            return JSONObject.fromObject("{'result':true,'msg':'更新成功'}").toString();
        }catch(Exception e){
            return JSONObject.fromObject("{'result':true,'msg':'更新失敗'}").toString();
        }
    }

    @RequestMapping(value = "/admin/editApi.html")
    public String editApi(HttpServletRequest request,ModelMap modelMap,@RequestParam("URLid")String URLid){
        UrlPermission urlPermission=urlPermissionService.find(URLid);
        modelMap.addAttribute("urlPermission",urlPermission);
        List<UrlPermissionParam> listParams=urlPermissionService.getParamsByUrl(URLid);
        String mainParams="{";
        String chilParams="{";
        String rootParams="";
        for (UrlPermissionParam urlPermissionParam :listParams) {
            if(urlPermissionParam.getParent().equals("0")){
                mainParams+="'"+urlPermissionParam.getParams()+"':{},";
            }else if(urlPermissionParam.getParent().equals("1")){
                chilParams+="'"+urlPermissionParam.getParams()+"':'',";
            }else if(urlPermissionParam.getParent().equals("root")){
                rootParams=urlPermissionParam.getParams();
            }
        }
        if(mainParams.trim().length()>1){
            mainParams=mainParams.substring(0,mainParams.length()-1);
        }
        mainParams+="}";
        mainParams= JSONStringHelper.formatJson(mainParams);
        if(chilParams.trim().length()>1){
            chilParams=chilParams.substring(0,chilParams.length()-1);
        }
        chilParams+="}";
        chilParams= JSONStringHelper.formatJson(chilParams);
        modelMap.addAttribute("mainParams",mainParams);
        modelMap.addAttribute("chilParams",chilParams);
        modelMap.addAttribute("rootParams",rootParams);
        return "admin/api/edit";
    }
    @RequestMapping(value = "/admin/saveApi.html")
    @ResponseBody
    public String saveApi(@RequestParam("url")String url,@RequestParam("mainParams")String mainParams,@RequestParam("chilParams")String chilParams,
                          @RequestParam("rootParam")String rootParam,@RequestParam("describes")String describes){
        UrlPermission urlPermission=urlPermissionService.find(url);
        urlPermission.setDescribes(describes);
        urlPermissionService.deleteAllParam();
        UrlPermissionParam uppRoot=new UrlPermissionParam();
        uppRoot.setUrl(url);
        uppRoot.setId(UUID.randomUUID().toString());
        uppRoot.setIsfArray(1);
        uppRoot.setParent("root");
        uppRoot.setParams(rootParam);
        urlPermissionService.save(uppRoot);
        JSONObject jm= JSONObject.fromObject(mainParams);
        Iterator it = jm.keys();
        while(it.hasNext()){
            uppRoot=new UrlPermissionParam();
            uppRoot.setUrl(url);
            uppRoot.setId(UUID.randomUUID().toString());
            uppRoot.setIsfArray(1);
            uppRoot.setParent("0");
            uppRoot.setParams((String) it.next());
            urlPermissionService.save(uppRoot);
        }
        JSONObject jc= JSONObject.fromObject(chilParams);
        it = jc.keys();
        while(it.hasNext()){
            uppRoot=new UrlPermissionParam();
            uppRoot.setUrl(url);
            uppRoot.setId(UUID.randomUUID().toString());
            uppRoot.setIsfArray(1);
            uppRoot.setParent("1");
            uppRoot.setParams((String) it.next());
            urlPermissionService.save(uppRoot);
        }
        return JSONObject.fromObject("{'result':true,'msg':'保存成功'}").toString();
    }

    @RequestMapping(value = "/admin/testApi.html")
    public String testApi(HttpServletRequest request,ModelMap modelMap){
        Sort sort = new Sort(Sort.Direction.DESC,"url"); //创建降序排序
        Pageable pageable =  new PageRequest(0,9999999);
        Page<UrlPermission> list=urlPermissionService.getAllURlByStatus(1,pageable);
        modelMap.addAttribute("data",list);
        return "admin/api/testApi";
    }

    private int getPage(HttpServletRequest request){
        int page=0;
        String p=request.getParameter("page");
        if(p!=null&&p.trim().length()>0){
            page=Integer.parseInt(p);
        }
        return page;
    }
}
