package com.suock.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "t_api_sap_info")
public class SapInfo implements Serializable {
    private static long serialVersionUID = 1L;
    @Id //主键
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "assigned")
    private String id;

    @Column(name = "language",nullable = true,length = 20)
    private String language;

    @Column(name = "client")
    private Integer client;

    @Column(name = "passwd",nullable = true,length = 100)
    private String passwd;

    @Column(name = "user",nullable = true,length = 20)
    private String user;

    @Column(name = "sysnr",nullable = true,length = 20)
    private String sysnr;

    @Column(name = "ashost",nullable = true,length = 30)
    private String ashost;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        SapInfo.serialVersionUID = serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSysnr() {
        return sysnr;
    }

    public void setSysnr(String sysnr) {
        this.sysnr = sysnr;
    }

    public String getAshost() {
        return ashost;
    }

    public void setAshost(String ashost) {
        this.ashost = ashost;
    }
}
