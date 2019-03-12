package com.suock.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "t_api_sap_basic")
public class SapBasic implements Serializable {

    private static long serialVersionUID = 1L;
    @Id //主键
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "assigned")
    private String id;

    @Column(name = "name",nullable = true,length = 100)
    private String name;

    @Column(name = "content",nullable = true,length = 255)
    private String content;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "infoid")
    private SapInfo infoid;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        SapBasic.serialVersionUID = serialVersionUID;
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

    public SapInfo getInfoid() {
        return infoid;
    }

    public void setInfoid(SapInfo infoid) {
        this.infoid = infoid;
    }
}
