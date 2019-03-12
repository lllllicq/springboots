package com.suock.csv.controller;

import com.suock.csv.model.CsvFile;
import com.suock.csv.model.CsvTableCols;
import com.suock.csv.service.CsvService;
import net.sf.json.JSONObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/csv/")
public class CsvController {

    @Autowired
    private CsvService csvService;

    @RequestMapping("/list.html")
    public String csvList(HttpServletRequest request, ModelMap modelMap){
        Sort sort = new Sort(Sort.Direction.DESC,"id"); //创建降序排序
        Pageable pageable =  new PageRequest(getPage(request),10,sort);
        CsvFile cf=new CsvFile();
        //查询条件
        cf.setStatus(null);

        ExampleMatcher matcher = ExampleMatcher.matching();//模糊查询;//查询条件匹配规则
        Page<CsvFile> list=csvService.getAllCsvFileByPage(Example.of(cf,matcher),pageable);
        modelMap.addAttribute("data",list);
        return "admin/csv/index";
    }
    @RequestMapping("/edit.html")
    public String csvEdit(HttpServletRequest request, ModelMap modelMap, @RequestParam("id") String id){
        modelMap.put("tables",csvService.getAllTable());
        if(id!=null&&id.trim().length()>0){
            //编辑页面
            Sort sort = new Sort(Sort.Direction.DESC,"id"); //创建降序排序
            Pageable pageable =  new PageRequest(getPage(request),10,sort);
            CsvFile cf=new CsvFile();
            cf.setId(id);
            cf.setStatus(null);
            //查询条件
            ExampleMatcher matcher = ExampleMatcher.matching();//模糊查询;//查询条件匹配规则
            Page<CsvFile> list=csvService.getAllCsvFileByPage(Example.of(cf,matcher),pageable);
            if(list.getContent().size()>0){
                modelMap.addAttribute("csv",list.getContent().get(0));
                modelMap.addAttribute("list",csvService.getCsvTable(list.getContent().get(0).getId()));
            }
        }
        return "admin/csv/edit";
    }
    @RequestMapping(value = "save.html")
    @ResponseBody
    public String saveInfo(HttpServletRequest request,CsvFile csvFile,String[] csvColName,String[] tableColName){
        if(csvFile.getId()==null||csvFile.getId().trim().length()<1){
            csvFile.setId(UUID.randomUUID().toString());
        }
        File file=new File(csvFile.getFilePath());
        if(file.exists()){
            csvFile.setFileName(file.getName());
        }
        file =file.getParentFile();
        if(!file.exists()){
            file.mkdirs();
        }
        csvService.save(csvFile);
        csvService.deleteAllCsvTableColsByCsvFileId(csvFile.getId());
        for (int i = 0; i < csvColName.length; i++) {
            CsvTableCols cts=new CsvTableCols();
            cts.setId(UUID.randomUUID().toString());
            cts.setCsvFileId(csvFile.getId());
            cts.setCsvColName(csvColName[i]);
            cts.setTableColName(tableColName[i]);
            csvService.save(cts);
        }
        return JSONObject.fromObject("{'result':true,'msg':'success'}").toString();
    }

    @RequestMapping(value = "changeCsvStatus.html")
    @ResponseBody
    public String changeCsvStatus(HttpServletRequest request,String id,Integer status){
        Sort sort = new Sort(Sort.Direction.DESC,"id"); //创建降序排序
        Pageable pageable =  new PageRequest(getPage(request),10,sort);
        CsvFile cf=new CsvFile();
        cf.setId(id);
        cf.setStatus(null);
        //查询条件
        ExampleMatcher matcher = ExampleMatcher.matching();//模糊查询;//查询条件匹配规则
        Page<CsvFile> list=csvService.getAllCsvFileByPage(Example.of(cf,matcher),pageable);
        if(list.getContent().size()>0) {
            cf=list.getContent().get(0);
            cf.setStatus(status);
            csvService.save(cf);
        }
        return JSONObject.fromObject("{'result':true,'msg':'success'}").toString();
    }

    private int getPage(javax.servlet.http.HttpServletRequest request){
        int page=0;
        String p=request.getParameter("page");
        if(p!=null&&p.trim().length()>0){
            page=Integer.parseInt(p);
        }
        return page;
    }
}