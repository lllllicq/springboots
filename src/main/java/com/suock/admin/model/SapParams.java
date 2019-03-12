package com.suock.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "t_api_sap_params")
public class SapParams implements Serializable {
    private static long serialVersionUID = 1L;
    @Id //主键
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "assigned")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "type")
    private String type;


    @Column(name = "length")
    private Integer length;

    @Column(name = "isnull")
    private Integer isnull;//0不能为空  1可为空


    @Column(name = "remake")
    private String remake;

    @ManyToOne
    @JoinColumn(name = "tableid")
    private SapTable tableid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        SapParams.serialVersionUID = serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SapTable getTableid() {
        return tableid;
    }

    public void setTableid(SapTable tableid) {
        this.tableid = tableid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getIsnull() {
        return isnull;
    }

    public void setIsnull(Integer isnull) {
        this.isnull = isnull;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }
}
