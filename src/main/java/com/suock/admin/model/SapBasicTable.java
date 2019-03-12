package com.suock.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "t_api_sap_basic_table")
public class SapBasicTable implements Serializable {
    private static long serialVersionUID = 1L;
    @Id //主键
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "assigned")
    private String id;

    @ManyToOne
    @JoinColumn(name = "basicid")
    private SapBasic basicid;

    @ManyToOne
    @JoinColumn(name = "tableid")
    private SapTable tableid;


    @Column(name = "type")
    private Integer type;//0输入参数   1输出参数

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        SapBasicTable.serialVersionUID = serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SapBasic getBasicid() {
        return basicid;
    }

    public void setBasicid(SapBasic basicid) {
        this.basicid = basicid;
    }

    public SapTable getTableid() {
        return tableid;
    }

    public void setTableid(SapTable tableid) {
        this.tableid = tableid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
