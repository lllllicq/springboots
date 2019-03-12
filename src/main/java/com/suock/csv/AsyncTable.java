package com.suock.csv;

import com.suock.csv.model.CsvFile;
import com.suock.csv.model.CsvTableCols;
import com.suock.csv.service.CsvService;
import com.suock.pub.helper.DateHelper;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class AsyncTable implements ApplicationRunner {
    @PersistenceUnit
    private EntityManagerFactory entityManager;

    @Autowired
    private CsvService csvService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                init();
            }
        },0, 1000*60*20);//每隔20分钟执行一次
    }

    private void init(){
        EntityManager em = entityManager.createEntityManager();
        em.getTransaction().begin();
        List<CsvFile> list=csvService.getAllCsvFile();
        for (CsvFile cf:list) {
            if(cf.getStatus()==null||cf.getStatus()!=1){
                continue;
            }
            File file=new File(cf.getFilePath());
            if(file.exists()&&file.isFile()){
                BufferedReader reader=null;
                try {
                    DataInputStream in=new DataInputStream(new FileInputStream(file));
                    reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));
                    String tempString=null;
                    reader.readLine();
                    int i=1;
                    String[] title=null;
                    while ((tempString=reader.readLine())!=null){
                        if(i>1){
                            tempString=tempString.replace("\"","");
                            String[] values=tempString.split(",");
                            String sql="insert into "+cf.getTableName()+"(";
                            List<CsvTableCols> ctList=csvService.getCsvTable(cf.getId());
                            for (CsvTableCols ctc:ctList) {
                                sql+=ctc.getTableColName()+",";
                            }
                            sql=sql.substring(0,sql.length()-1);
                            sql+=") values(";
                            for (CsvTableCols ctc:ctList) {
                                sql+= "'"+values[getIndexByStringArray(title,ctc.getCsvColName())]+"',";
                            }
                            sql= sql.substring(0,sql.length()-1);
                            sql+=")";
                            System.out.print(sql);//输出打印sql语句
                            int res = em.createNativeQuery(sql).executeUpdate();
                        }else{
                            tempString=tempString.replace("\"","");
                            title=tempString.split(",");
                        }
                        i++;
                    }
                    em.getTransaction().commit();
                    reader.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }finally {
                    if (reader!=null){
                        try {
                            reader.close();
                        }catch (IOException o){
                            o.fillInStackTrace();
                        }
                    }
                    if(em!=null){
                        em.close();
                    }
                    if(!new File(file.getParent()+File.separator+"bak"+DateHelper.formtDate(new Date(),"yyy-MM-dd")+File.separator).exists()){
                        new File(file.getParent()+File.separator+"bak"+DateHelper.formtDate(new Date(),"yyy-MM-dd")+File.separator).mkdirs();
                    }
                   file.renameTo(new File(file.getParent()+File.separator+"bak"+DateHelper.formtDate(new Date(),"yyy-MM-dd")+File.separator+ DateHelper.formtDate(new Date(),"yyy-MM-dd-") +file.getName()));
                }
            }
        }
    }
    private Integer getIndexByStringArray(String[] array,String str){
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(str)){
                return i;
            }
        }
        return -1;
    }
}
