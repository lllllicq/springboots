package com.suock.admin.controller;

import com.suock.admin.model.*;
import com.suock.admin.service.SapService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/sap")
public class SapApiController {

    @Autowired
    private SapService sapService;

    @RequestMapping(value = "sapInfoList.html")
    public String sapInfoList(HttpServletRequest request, ModelMap modelMap){
        Sort sort = new Sort(Sort.Direction.DESC,"client"); //创建降序排序
        Pageable pageable =  getPage(request,sort);
        SapInfo sapInfo=new SapInfo();
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("ashost" , ExampleMatcher.GenericPropertyMatchers.contains());//模糊查询;//查询条件匹配规则
        String ashost=request.getParameter("ashost");
        if(ashost!=null&&ashost.trim().length()>0){
            sapInfo.setAshost(ashost);
            modelMap.addAttribute("ashost",ashost);
        }
        Page<SapInfo> list=sapService.getSapInfoAllByPageable(Example.of(sapInfo,matcher),pageable);
        modelMap.addAttribute("data",list);
        return "admin/sap/list";
    }
    @RequestMapping(value = "saveInfoPage.html")
    public String saveInfoPage(HttpServletRequest request,@RequestParam("id") String id, ModelMap modelMap){
        if(id!=null&&id.trim().length()>0){
            //编辑页面
            Sort sort = new Sort(Sort.Direction.DESC,"client"); //创建降序排序
            Pageable pageable =  getPage(request,sort);
            SapInfo sapInfo=new SapInfo();
            sapInfo.setId(id);
            ExampleMatcher matcher = ExampleMatcher.matching();//模糊查询;//查询条件匹配规则
            Page<SapInfo> list=sapService.getSapInfoAllByPageable(Example.of(sapInfo,matcher),pageable);
            if(list.getContent().size()>0){
                modelMap.addAttribute("data",list.getContent().get(0));
            }
        }
        return "admin/sap/sapInfoEdit";
    }
    @RequestMapping(value = "saveInfo.html")
    @ResponseBody
    public String saveInfo(SapInfo sapInfo){
        if(sapInfo.getId()==null||sapInfo.getId().trim().length()<1){
            sapInfo.setId(UUID.randomUUID().toString());
        }
        sapService.save(sapInfo);
        return JSONObject.fromObject("{'result':true,'msg':'success'}").toString();
    }

    @RequestMapping(value = "saveParamsPage.html")
    public String saveParamsPage(HttpServletRequest request,@RequestParam("id") String id, ModelMap modelMap){
        if(id!=null&&id.trim().length()>0){
            List<SapParams> list=sapService.getSapParamsAllByTableid(id);
            SapTable sapTable=list.get(0).getTableid();
            modelMap.addAttribute("data",sapTable);
            modelMap.addAttribute("list",list);
        }
        return "admin/sap/sapParamsEdit";
    }
    @RequestMapping(value = "saveParams.html")
    @ResponseBody
    public String saveParams(String[] name,String[] content,String[] type,Integer[] length,Integer[] isnull,String[] remake,
                             @RequestParam("Cid") String Cid,@RequestParam("Cname") String Cname,@RequestParam("Ccontent") String Ccontent){
        SapTable sapTable=new SapTable();
        if(Cid==null||Cid.trim().length()<1){
            sapTable.setId(UUID.randomUUID().toString());
        }else{
            sapTable.setId(Cid);
        }
        sapTable.setName(Cname);
        sapTable.setContent(Ccontent);
        sapService.save(sapTable);
        sapService.deleteAllSapParamsByTableId(Cid);
        for (int i = 0; i < name.length; i++) {
            SapParams sp=new SapParams();
            sp.setId(UUID.randomUUID().toString());
            sp.setName(name[i]);
            sp.setContent(content[i]);
            sp.setType(type[i]);
            sp.setLength(length[i]);
            sp.setIsnull(isnull[i]);
            sp.setRemake(remake[i]);
            sp.setTableid(sapTable);
            sapService.save(sp);
        }
        return JSONObject.fromObject("{'result':true,'msg':'success'}").toString();
    }


    @RequestMapping(value = "savesapPage.html")
    public String savesapPage(HttpServletRequest request,@RequestParam("id") String id, ModelMap modelMap){
        SapBasic sapBasic=sapService.getSapBasicById(id);
        modelMap.addAttribute("data",sapBasic);

        List<SapInfo> infoList=sapService.getSapInfoAll();
        modelMap.addAttribute("infoList",infoList);
        List<SapTable> tableList=sapService.getSapTableAll();
        modelMap.addAttribute("tableList",tableList);
        if(id!=null&&id.trim().length()>0){
            List<SapBasicTable> yesList=sapService.getSapBasicTableByBasicId(sapBasic.getId());
            List yesInList=new ArrayList();
            List yesOutList=new ArrayList();
            for (SapBasicTable sapBasicTable: yesList) {
                if(sapBasicTable.getType()==0){
                    yesInList.add(sapBasicTable.getTableid().getId());
                }else{
                    yesOutList.add(sapBasicTable.getTableid().getId());
                }
            }
            modelMap.addAttribute("yesInList",yesInList);
            modelMap.addAttribute("yesOutList",yesOutList);
        }
        return "admin/sap/sapEdit";
    }
    @RequestMapping(value = "savesap.html")
    @ResponseBody
    public String savesap(SapBasic sapBasic,String[] yesInList,String[] yesOutList){
        SapInfo sapInfo=sapBasic.getInfoid();
        sapInfo=sapService.getSapInfoById(sapInfo.getId());
        sapBasic.setInfoid(sapInfo);
        sapService.save(sapBasic);
        sapService.deleteAllSapBasicTableByBasicId(sapBasic.getId());
        for (int i = 0; i < yesInList.length; i++) {
            SapTable sapTable=new SapTable();
            sapTable.setId(yesInList[i]);
            SapBasicTable sapBasicTable=new SapBasicTable();
            sapBasicTable.setBasicid(sapBasic);
            sapBasicTable.setTableid(sapTable);
            sapBasicTable.setType(0);
            sapBasicTable.setId(UUID.randomUUID().toString());
            sapService.save(sapBasicTable);
        }
        for (int i = 0; i < yesOutList.length; i++) {
            SapTable sapTable=new SapTable();
            sapTable.setId(yesOutList[i]);
            SapBasicTable sapBasicTable=new SapBasicTable();
            sapBasicTable.setBasicid(sapBasic);
            sapBasicTable.setTableid(sapTable);
            sapBasicTable.setType(1);
            sapBasicTable.setId(UUID.randomUUID().toString());
            sapService.save(sapBasicTable);
        }
        return JSONObject.fromObject("{'result':true,'msg':'success'}").toString();
    }


    @RequestMapping(value = "sapApiList.html")
    public String sapApiList(HttpServletRequest request, ModelMap modelMap){
        Sort sort = new Sort(Sort.Direction.DESC,"name"); //创建降序排序
        Pageable pageable =  getPage(request,sort);
        SapBasic sapBasic=new SapBasic();
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("content" , ExampleMatcher.GenericPropertyMatchers.contains());//模糊查询;//查询条件匹配规则
        String content=request.getParameter("content");
        if(content!=null&&content.trim().length()>0){
            sapBasic.setContent(content);
            modelMap.addAttribute("content",content);
        }
        Page<SapBasic> list=sapService.getSapBasicAllByPageable(Example.of(sapBasic,matcher),pageable);
        modelMap.addAttribute("data",list);
        return "admin/sap/sapList";
    }
    @RequestMapping(value = "sapApiTable.html")
    public String sapApiTable(HttpServletRequest request, ModelMap modelMap){
        Sort sort = new Sort(Sort.Direction.DESC,"name"); //创建降序排序
        Pageable pageable =  getPage(request,sort);
        SapTable sapTable=new SapTable();
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("content" , ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("name" , ExampleMatcher.GenericPropertyMatchers.contains());//模糊查询;//查询条件匹配规则
        String name=request.getParameter("name");
        if(name!=null&&name.trim().length()>0){
            sapTable.setName(name);
            modelMap.addAttribute("name",name);
        }
        String content=request.getParameter("content");
        if(content!=null&&content.trim().length()>0){
            sapTable.setContent(content);
            modelMap.addAttribute("content",content);
        }
        Page<SapBasicTable> list=sapService.getSapTableByPageable(Example.of(sapTable,matcher),pageable);
        modelMap.addAttribute("data",list);
        return "admin/sap/tableList";
    }

    private Pageable getPage(HttpServletRequest request,Sort sort){
        int page=0;
        String p=request.getParameter("page");
        if(p!=null&&p.trim().length()>0){
            page=Integer.parseInt(p);
        }
        Pageable pageable =  new PageRequest(page,10,sort);
        return pageable;
    }
}
