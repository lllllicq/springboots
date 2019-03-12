package com.suock.api.controller;

import com.sun.deploy.net.HttpResponse;
import com.suock.api.model.*;
import com.suock.api.service.ApiService;
import com.suock.pub.helper.ApiHelper;
import com.suock.pub.helper.DateHelper;
import com.suock.pub.helper.DateJsonValueProcessor;
import com.suock.pub.helper.JSONStringHelper;
import com.suock.pub.helper.model.ApiFilePath;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsDateJsonValueProcessor;
import net.sf.json.processors.JsonValueProcessor;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class IndexController {
    @Autowired
    private ApiService apiService;

    @Autowired
    private ApiFilePath apiFilePath;

    @RequestMapping("/asyncSAPPo")
    public String index(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject json=new JSONObject();
        try{
            String type = request.getParameter("type");
            //输出xml
            if(type!=null&&type.trim().length()>0){
                String shopName="JTAT6";//厂商名称
                List<TPurchaseOrder> list=apiService.findPoByShopName(shopName);
                JsonConfig cfg = new JsonConfig();
                cfg.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor());
                String xml=JSONStringHelper.jsonToXML(JSONArray.fromObject(list,cfg).toString());
                ApiHelper.xmlStrToIo(response,xml,shopName+"-po",apiFilePath.getPoFile());
                return null;
            }
            //解析xml
            JSONObject data= ApiHelper.getApiData(request,json,apiFilePath.getPoFile());
            //处理字符串 存库 data

            System.out.println(data.toString());
        }catch(Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("msg",e.getMessage());
        }
        return json.toString();
    }

    @RequestMapping("/supplyCloud")
    public String SupplyCloud(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject json=new JSONObject();
        try{
            String type = request.getParameter("type");
            //输出xml
            if(type!=null&&type.trim().length()>0){
                String vendor="JAAT1    ";//厂商名称
                List<SupplyDemandDbLongFcst> list=apiService.findSupplyDemandDbLongFcstByVendor(vendor);
                System.out.println(list.size()+"<<<<<<<<<<<<<<<<<<<<<<<");
                JsonConfig cfg = new JsonConfig();
                cfg.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor());
                String xml=JSONStringHelper.jsonToXML(JSONArray.fromObject(list,cfg).toString());
                ApiHelper.xmlStrToIo(response,xml,vendor+"-SupplyDemandDbLongFcst",apiFilePath.getSupplyCloud());
                return null;
            }
            //解析xml
            JSONObject data= ApiHelper.getApiData(request,json,apiFilePath.getSupplyCloud());
            //处理字符串 存库 data
            List<SupplyDemandDbLongFcst> datas=JSONArray.toList(data.getJSONArray("data"),SupplyDemandDbLongFcst.class );
            for(SupplyDemandDbLongFcst supplyDemandDbLongFcst:datas){
                supplyDemandDbLongFcst.setList(JSONArray.toList(JSONArray.fromObject(supplyDemandDbLongFcst.getList()), SupplyDemandDbLongFcstChildren.class ));
                if(supplyDemandDbLongFcst.getCreateDate()==null){
                    supplyDemandDbLongFcst.setCreateDate(new Date());
                }
                for(SupplyDemandDbLongFcstChildren sdlfc:supplyDemandDbLongFcst.getList()){
                    apiService.saveOrUpdateSupplyDemandDbLongFcstChildren(sdlfc);
                }
                apiService.saveOrUpdateSupplyDemandDbLongFcst(supplyDemandDbLongFcst);
        }
        json.put("msg","共计："+datas.size());
    }catch(Exception e){
        e.printStackTrace();
            json.put("result",false);
            json.put("msg",e.getMessage());
        }
        return json.toString();
    }

    @RequestMapping("/supplyCloudTs")
    public String SupplyCloudTs(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject json=new JSONObject();
        try{
            String type = request.getParameter("type");
            //输出xml
            if(type!=null&&type.trim().length()>0){
                String vendor="JHST1";
                List<SupplyDemandDbWeekFcst> list=apiService.findSupplyDemandDbWeekFcstByVendor(vendor);
                System.out.println(list.size()+"<<<<<<<<<<<<<<<<<<<<<<<<");
                JsonConfig cfg = new JsonConfig();
                cfg.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor());
                String xml=JSONStringHelper.jsonToXML(JSONArray.fromObject(list,cfg).toString());
                ApiHelper.xmlStrToIo(response,xml,vendor+"-SupplyDemandDbWeekFcst",apiFilePath.getSupplyCloud());
                return null;
            }
            //解析xml
            JSONObject data= ApiHelper.getApiData(request,json,apiFilePath.getSupplyCloud());
            //处理字符串 存库 data
            List<SupplyDemandDbWeekFcst> datas=JSONArray.toList(data.getJSONArray("data"),SupplyDemandDbWeekFcst.class );
            for(SupplyDemandDbWeekFcst supplyDemandDbWeekFcst:datas){
//                supplyDemandDbWeekFcst.setList(JSONArray.toList(JSONArray.fromObject(supplyDemandDbWeekFcst.getList()), SupplyDemandDbWeekFcstChildren.class ));
                if(supplyDemandDbWeekFcst.getCreateDate()==null){
                    supplyDemandDbWeekFcst.setCreateDate(new Date());
                }
                for(SupplyDemandDbWeekFcstChildren sdlfc:supplyDemandDbWeekFcst.getList()){
                    apiService.saveOrUpdateSupplyDemandDbWeekFcstChildren(sdlfc);
                }
                apiService.saveOrUpdateSupplyDemandDbWeekFcst(supplyDemandDbWeekFcst);
            }
            json.put("msg","共计："+datas.size());
        }catch(Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("msg",e.getMessage());
        }
        return json.toString();
    }

    @RequestMapping("/GsmSupply")
    public String GsmSupply(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject json=new JSONObject();
        try{
            String type = request.getParameter("type");
            //输出xml
            if(type!=null&&type.trim().length()>0){
                String vendor="JAAT2";//厂商名称
                List<GsmSupplyShortageMaterial> list=apiService.findGsmSupplyShortageMaterialByVendor(vendor);
                System.out.println(list.size()+"<<<<<<<<<<<<<<<<<<<<<<");
                JsonConfig cfg = new JsonConfig();
                cfg.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor());
                String xml=JSONStringHelper.jsonToXML(JSONArray.fromObject(list,cfg).toString());
                ApiHelper.xmlStrToIo(response,xml,vendor+"-GsmSupplyShortageMaterial",apiFilePath.getGsmSupply());
                return null;
            }
            MultipartFile file = request.getFile("file");
            String fileName=file.getOriginalFilename();
            String[] V1 = fileName.split(Pattern.quote("."));
            if (V1[1].equals("txt")) {
                String filePath = apiFilePath.getGsmSupply();
                InputStream input=file.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = input.read(buffer)) > -1 ) {
                    baos.write(buffer, 0, len);
                }
                baos.flush();
                InputStream stream1 = new ByteArrayInputStream(baos.toByteArray());
                InputStream stream2 = new ByteArrayInputStream(baos.toByteArray());
                Date date=new Date();
                filePath=filePath+DateHelper.formtDate(date,"yyyy")+
                        File.separator+DateHelper.formtDate(date,"MM")+
                        File.separator+DateHelper.formtDate(date,"dd")+
                        File.separator+"Receive"+File.separator;
                File pa=new File(filePath);
                if(!pa.exists()){
                    pa.mkdirs();
                }
                pa=new File(filePath+DateHelper.formtDate(date,"yyyyMMdd")+fileName);
                OutputStream out = new FileOutputStream(pa);
                byte[] bytes= new byte[1024];
                //将文件流信息读取文件缓存区，如果读取结果不为-1就代表文件没有读取完毕，反之已经读取完毕
                while(stream1.read(bytes)!=-1){
                    //将缓存区中的内容写到afterfile文件中
                    out.write(bytes);
                    out.flush();
                }
                out.close();
                InputStreamReader isr=new InputStreamReader(stream2);
                BufferedReader reader = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String line = null;
                int num = 0;
                while ((line = reader.readLine()) != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                    num++;
                    String[] SJ = line.split("\t");
                    GsmSupplyShortageMaterial g = new GsmSupplyShortageMaterial();
                    GsmSupplyShortageMaterialChild gc = new GsmSupplyShortageMaterialChild();
                    g.setCloudIFcstNo(SJ[0]);
                    g.setMaterial(SJ[1]);
                    g.setDescripitionCn(SJ[2]);
                    g.setDescripitionEn(SJ[3]);
                    g.setMaterialGroup(SJ[4]);
                    g.setImpact(SJ[5]);
                    g.setWhereuserd(SJ[6]);
                    g.setBuyer(SJ[7]);
                    g.setAlt(SJ[8]);
                    g.setAltgroup(SJ[9]);
                    g.setVmiStock(Integer.valueOf(SJ[10]));
                    g.setRoh(SJ[11]);
                    g.setQiStock(Integer.valueOf(SJ[12]));
                    g.setRunTime(sdf.parse(SJ[13]));
                    g.setDoi(Integer.valueOf(SJ[14]));
                    g.setVendor(SJ[15]);
                    g.setVendorEmail(SJ[16]);
                    g.setQuoda(SJ[17]);
                    g.setShortageTtlNumber(Integer.valueOf(SJ[18]));
                    g.setSupplyTtlNumber(Integer.valueOf(SJ[19]));
                    g.setDeltaTtlNumber(Integer.valueOf(SJ[20]));
                    g.setIsTest(Integer.valueOf(SJ[21]));
                    g.setRemark(Integer.valueOf(SJ[22]));
                    g.setIsSuccess(Integer.valueOf(SJ[23]));
                    g.setText1(SJ[24]);
                    g.setText2(SJ[25]);
                    g.setText3(SJ[26]);
                    g.setFieldDrillsInventory(Integer.valueOf(SJ[27]));
                    g.setHeavyWare(SJ[28]);
                    g.setDefectiveReturnWare(SJ[29]);
                    g.setDisableInventory(Integer.valueOf(SJ[30]));
                    g.setVersion(SJ[31]);
                    g.setShortage(SJ[32]);
                    g.setSendStatus(Integer.valueOf(SJ[33]));

                    if(SJ.length>34) {
                        gc.setPredictDate(sdf.parse(SJ[34]));
                        gc.setShortageNumber(Integer.valueOf(SJ[35]));
                        gc.setSupplyNumber(Integer.valueOf(SJ[36]));
                        gc.setDeltaNumber(Integer.valueOf(SJ[37]));
                        gc.setGsmSupply(Integer.valueOf(SJ[38]));
                        gc.setLongId(Integer.valueOf(SJ[39]));
                        json.put("gc", gc);
                        apiService.saveOrUpdateGsmSupplyShortageMaterialChild(gc);
                    }
                    apiService.saveOrUpdateGsmSupplyShortageMaterial(g);
                    //   line = br.readLine(); // 一次读入一行数据

                }
                json.put("msg","共计："+num);
            }else{
                //解析xml
                JSONObject data= ApiHelper.getApiData(request,json,apiFilePath.getGsmSupply());
                //处理字符串 存库 data
                List<GsmSupplyShortageMaterial> datas=JSONArray.toList(data.getJSONArray("data"),GsmSupplyShortageMaterial.class );
                for(GsmSupplyShortageMaterial gsmSupplyShortageMaterial:datas){
                    gsmSupplyShortageMaterial.setList(JSONArray.toList(JSONArray.fromObject(gsmSupplyShortageMaterial.getList()), GsmSupplyShortageMaterialChild.class ));
                    if(gsmSupplyShortageMaterial.getRunTime()==null){
                        gsmSupplyShortageMaterial.setRunTime(new Date());
                    }
                    for(GsmSupplyShortageMaterialChild gssmc:gsmSupplyShortageMaterial.getList()){
                        apiService.saveOrUpdateGsmSupplyShortageMaterialChild(gssmc);
                    }
                    apiService.saveOrUpdateGsmSupplyShortageMaterial(gsmSupplyShortageMaterial);
                }
                json.put("msg","共计："+datas.size());
            }
        }catch(Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("msg",e.getMessage());
        }
        return json.toString();
    }

    @RequestMapping("/GsmSupplyTxt")
    public String GsmSupplyTxt(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject json=new JSONObject();
        try{
            String type = request.getParameter("type");
            //输出xml
            if(type!=null&&type.trim().length()>0) {
                String vendor = "JAAT2";//厂商名称
                List<GsmSupplyShortageMaterial> list = apiService.findGsmSupplyShortageMaterialByVendor(vendor);
                System.out.println(list.size() + "<<<<<<<<<<<<<<<<<<<<<<");
                Date date = new Date();

                String apiPathTex = apiFilePath.getGsmSupply() + DateHelper.formtDate(date, "yyyy") +
                        File.separator + DateHelper.formtDate(date, "MM") +
                        File.separator + DateHelper.formtDate(date, "dd") +
                        File.separator + "sendOut" + File.separator;
                File pa = new File(apiPathTex);
                File file = new File( apiPathTex + DateHelper.formtDate(date, "yyyyMMdd") + "-GsmSupplyShortageMaterial" + ".txt");
                //File file = new File(apiPathTex + DateHelper.formtDate(date, "yyyyMMdd") + "-GsmSupplyShortageMaterial" + ".txt");
                StringBuffer stringBuffer = new StringBuffer();
                for (GsmSupplyShortageMaterial g : list) {
                    List<GsmSupplyShortageMaterialChild> c = g.getList();

                    if (c.size() > 0) {
                        GsmSupplyShortageMaterialChild gc = c.get(1);
                        stringBuffer.append(g.getCloudIFcstNo() + "\t" + g.getMaterial() + "\t" + g.getDescripitionCn() + "\t"+ g.getDescripitionEn() + "\t" + g.getMaterialGroup() + "\t" + g.getImpact() + "\t" + g.getWhereuserd() +
                                "\t" + g.getBuyer() + "\t"+ g.getAlt() + "\t" + g.getAltgroup() + "\t" + g.getVmiStock() + "\t" + g.getRoh() + "\t"+ g.getQiStock() + "\t"+ g.getRunTime() + "\t" + g.getDoi() + "\t" + g.getVendor() +
                                "\t"+ g.getVendorEmail() + "\t" + g.getQuoda() +"\t" + g.getShortageTtlNumber() + "\t" + g.getSupplyTtlNumber() + "\t" + g.getDeltaTtlNumber() + "\t"+ g.getIsTest() + "\t" + g.getRemark() +
                                "\t"+ g.getIsSuccess() + "\t"+ g.getText1() + "\t" + g.getText2() + "\t" + g.getText3() + "\t" + g.getFieldDrillsInventory() + "\t" + g.getHeavyWare() + "\t" + g.getDefectiveReturnWare() +
                                "\t" + g.getDisableInventory() + "\t" + g.getVersion() + "\t" + g.getShortage() + "\t" + g.getSendStatus() + "\t"+ gc.getPredictDate() + "\t" + gc.getShortageNumber() + "\t" + gc.getSupplyNumber() +
                                "\t" + gc.getDeltaNumber() + "\t" + gc.getGsmSupply() + "\t" + gc.getLongId() + "\r\n");
                    } else {
                        stringBuffer.append(g.getCloudIFcstNo() + "\t" + g.getMaterial() + "\t" + g.getDescripitionCn() + "\t"+ g.getDescripitionEn() + "\t" + g.getMaterialGroup() + "\t" + g.getImpact() + "\t" + g.getWhereuserd() +
                                "\t" + g.getBuyer() + "\t"+ g.getAlt() + "\t" + g.getAltgroup() + "\t" + g.getVmiStock() + "\t" + g.getRoh() + "\t"+ g.getQiStock() + "\t"+ g.getRunTime() + "\t" + g.getDoi() + "\t" + g.getVendor() +
                                "\t"+ g.getVendorEmail() + "\t" + g.getQuoda() +"\t" + g.getShortageTtlNumber() + "\t" + g.getSupplyTtlNumber() + "\t" + g.getDeltaTtlNumber() + "\t"+ g.getIsTest() + "\t" + g.getRemark() +
                                "\t"+ g.getIsSuccess() + "\t"+ g.getText1() + "\t" + g.getText2() + "\t" + g.getText3() + "\t" + g.getFieldDrillsInventory() + "\t" + g.getHeavyWare() + "\t" + g.getDefectiveReturnWare() +
                                "\t" + g.getDisableInventory() + "\t" + g.getVersion() + "\t" + g.getShortage() + "\t" + g.getSendStatus() + "\r\n");
                    }
                }
                FileWriter fw = new FileWriter(file);
                fw.write(stringBuffer.toString());
                //     fw.flush();
                fw.close();

                response.setContentType("application/octet-stream");
                response.addHeader("Content-Disposition", "attachment;   filename=" + "-GsmSupplyShortageMaterial" + ".txt");
                response.setContentLength((int) file.length());
                response.setHeader("Accept-Ranges", "bytes");
                FileInputStream fi = new FileInputStream(file);
                InputStream in = new BufferedInputStream(fi, 4096);
                OutputStream os = new BufferedOutputStream(response.getOutputStream());
                byte[] bytes = new byte[4096];
                int i = 0;
                while ((i = in.read(bytes)) > 0) {
                    os.write(bytes, 0, i);
                }
                os.flush();
                fi.close();
                in.close();
                os.close();
                // JsonConfig cfg = new JsonConfig();
                //  cfg.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor());
                // String xml=JSONStringHelper.jsonToXML(JSONArray.fromObject(list,cfg).toString());
                //  ApiHelper.xmlStrToIoTxt(response,xml,vendor+"-GsmSupplyShortageMaterial",apiFilePath.getGsmSupply());
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
            json.put("result",false);
            json.put("msg",e.getMessage());
        }
        return json.toString();
    }

        @RequestMapping("/VendorPOInfoTxt")
        public String VendorPOInfoTxt(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
            JSONObject json=new JSONObject();
            try{
                String type = request.getParameter("type");

                if(type!=null&&type.trim().length()>0) {
                    List<POVendorPOInfo> poInfos = apiService.getPOInfoByVendor("JTAT1");
                    StringBuffer stringBuffer = new StringBuffer();
                    for(POVendorPOInfo poInfo:poInfos){
                        stringBuffer.append(//poInfo.getId()+"\t"+
                                poInfo.getVersion()+"\t"+poInfo.getPlant()+"\t"
                                +poInfo.getVendorCode()+"\t"+poInfo.getMaterial()+"\t"+poInfo.getPo()+"\t"
                                +poInfo.getPoLine()+"\t"+poInfo.getQuantity()+"\t"+poInfo.getCurrency()+"\t"
                                +poInfo.getPrice()+"\t"+poInfo.getRma()+"\t"+poInfo.getDeliveryDate()+"\t"
                                +poInfo.getActualShipmentTime()+"\t"+poInfo.getGRQty()+"\t"+poInfo.getOpenASN()+"\t"
                                +poInfo.getLocation()+"\t"+poInfo.getLocationDes()+"\t"+poInfo.getBuyerCode()+"\t"
                                +poInfo.getSpecification()+"\t"+poInfo.getUnit()+"\t"+poInfo.getManual()+"\t"
                                +poInfo.getPoStatus()+"\t"+poInfo.getRetCode()+"\t"+poInfo.getRetMessage()+"\t"+
                                poInfo.getCreateTime()+"\t"+poInfo.getUpdateTime() + "\r\n");

                    }

                    SimpleDateFormat dateFormat= new SimpleDateFormat("yyMMddhhmmss");
                    String fileName = dateFormat.format(new Date());
                    fileName = "PO-JTAT1-" + fileName + ".txt";

                    response.reset();
                    String str=new String(stringBuffer);
                    response.setHeader("content-disposition", "attachment;filename="+ fileName);
                    byte[] line = str.getBytes();
                    response.getOutputStream().write(line);
                    response.getOutputStream().close();
                    return null;
                }

            }catch(Exception e){
                e.printStackTrace();
                json.put("result",false);
                json.put("msg",e.getMessage());
            }


            return json.toString();
        }

    /**
     * 用户在做上传的时候，前台默认不会加上后缀Txt，因此会进到这里面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/VendorPOInfo")
    public String VendorPOInfo(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject json=new JSONObject();
        String encoding = "UTF-8";

        MultipartFile file = request.getFile("file");
        String fileName= file.getOriginalFilename();
        String V1 = fileName.substring(fileName.lastIndexOf(".")+1);
        File file1 = new File("d://"+file.getOriginalFilename());
        file.transferTo(file1);

        if("txt".equals(V1)){

            Long lenn = file1.length();
            byte[] filecontent = new byte[lenn.intValue()];
            FileInputStream in = new FileInputStream(file1);
            in.read(filecontent);
            in.close();
            String result = new String(filecontent, encoding);

            String[] lines = result.split("\r\n");
            String[] columns = null;
            POVendorPOInfo poInfo = new POVendorPOInfo();
            if(lines.length == 0){
                json.put("msg","请上传正确的文件!!");
                return json.toString();
            }else{
                for(String line:lines){
                    columns = line.split("\t");
                    if(columns.length != 25){
                        json.put("msg","请上传正确的文件!!");
                        return json.toString();
                    }else{
                        poInfo.setVersion(columns[0]);
                        poInfo.setPlant(columns[1]);
                        poInfo.setVendorCode(columns[2]);
                        poInfo.setMaterial(columns[3]);
                        poInfo.setPo(columns[4]);
                        poInfo.setPoLine(new Integer(columns[5]));
                        poInfo.setQuantity(new Integer(columns[6]));
                        poInfo.setCurrency(columns[7]);
                        poInfo.setPrice(new Float(columns[8]));
                        poInfo.setRma(columns[9]);
                        poInfo.setDeliveryDate(new Date(columns[10]));
                        poInfo.setActualShipmentTime(new Date(columns[11]));
//                        GRQty
//                                openASN
//                        location
//                                LOCATIon_Des
//                        buyer_CodE
//                                specification
//                        uNIT
//                                manual
//                        po_STATUs
//                                REt_Code
//                        ret_MessAGE
//                                CrEATE_Time
//                        update_TiME
                    }

                }

            }


            json.put("msg",result);
            return json.toString();
        }

        json.put("msg","请上传TXT类型的文件!!");
        return json.toString();
    }

    /**
     * 在后台数据库表维护好了URL之后，链接在Mapping的时候会自动在后面加上Txt，因此在controller里面也需要
     * 加上Txt
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/testUrlTxt1Txt")
    public String testUrlTxt1Txt(MultipartHttpServletRequest request, HttpServletResponse response){
        return "333";
    }

}
