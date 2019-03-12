package com.suock.pub.helper;

import com.suock.api.dao.GsmSupplyShortageMaterialChildDao;
import com.suock.api.model.GsmSupplyShortageMaterial;
import com.suock.api.model.GsmSupplyShortageMaterialChild;
import com.suock.api.service.ApiService;
import com.suock.pub.helper.model.ApiFilePath;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class ApiHelper {
    @Autowired
    private ApiService apiService;

    @Autowired
    private ApiFilePath apiFilePath;
    public static JSONObject getApiData(MultipartHttpServletRequest request,JSONObject json,String filePath) throws Exception{
        MultipartFile file = request.getFile("file");
        String fileName=file.getOriginalFilename();
        String jsonData = request.getParameter("jsonData");
        JSONObject data=new JSONObject();
        if(file!=null) {//上传类型为XML
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
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            stream1.close();
            stream2.close();
            isr.close();
            reader.close();
            baos.close();
            try {
                data.put("data", JSONArray.fromObject(JSONStringHelper.xmlToJson(sb.toString())));
                json.put("result", true);
                json.put("msg", "XML");
            }catch(Exception e){
                json.put("result",false);
                json.put("msg","XML格式错误");
            }
        }else if(jsonData!=null&&jsonData.trim().length()>0){
            try{
                data=JSONObject.fromObject(jsonData);
                json.put("result",true);
                json.put("msg","JSON");
            }catch(Exception e){
                json.put("result",false);
                json.put("msg","JSON格式错误");
            }
        }else{
            json.put("result",false);
            json.put("msg","参数错误");
        }
        return data;
    }

    public static void xmlStrToIo(HttpServletResponse response,String xml,String fileName,String filePath)throws Exception{
        Document document = DocumentHelper.parseText(xml);
        OutputFormat format = OutputFormat.createPrettyPrint();
        /** 指定XML编码 */
        format.setEncoding("UTF-8");
        /** 将document中的内容写入文件中 */
        XMLWriter writer;
        try {
            Date date=new Date();
            filePath=filePath+DateHelper.formtDate(date,"yyyy")+
                    File.separator+DateHelper.formtDate(date,"MM")+
                    File.separator+DateHelper.formtDate(date,"dd")+
                    File.separator+"sendOut"+File.separator;
            File pa=new File(filePath);
            if(!pa.exists()){
                pa.mkdirs();
            }
            File file=new File(filePath+DateHelper.formtDate(date,"yyyyMMdd")+fileName+".xml");
            FileWriter fw=new FileWriter(file);
            writer = new XMLWriter(fw, format);
            writer.write(document);
            fw.close();
            writer.close();
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;   filename="+fileName+".xml");
            response.setContentLength((int)file.length());
            response.setHeader("Accept-Ranges", "bytes");
            FileInputStream fi=new FileInputStream(file);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void xmlStrToIoTxt(HttpServletResponse response,String xml,String fileName,String filePath)throws Exception{
        Document document = DocumentHelper.parseText(xml);
        OutputFormat format = OutputFormat.createPrettyPrint();
        /** 指定XML编码 */
        format.setEncoding("UTF-8");
        /** 将document中的内容写入文件中 */
        XMLWriter writer;
        try {
            Date date=new Date();
            filePath=filePath+DateHelper.formtDate(date,"yyyy")+
                    File.separator+DateHelper.formtDate(date,"MM")+
                    File.separator+DateHelper.formtDate(date,"dd")+
                    File.separator+"sendOut"+File.separator;
            File pa=new File(filePath);
            if(!pa.exists()){
                pa.mkdirs();
            }
            File file=new File(filePath+DateHelper.formtDate(date,"yyyyMMdd")+fileName+".txt");
            StringBuffer stringBuffer = new StringBuffer();
            FileWriter fw=new FileWriter(file);
            writer = new XMLWriter(fw, format);
            writer.write(document);
            fw.close();
            writer.close();
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;   filename="+fileName+".xml");
            response.setContentLength((int)file.length());
            response.setHeader("Accept-Ranges", "bytes");
            FileInputStream fi=new FileInputStream(file);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
