package com.suock.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_api_url_param")
public class UrlPermissionParam implements Serializable {
    private static long serialVersionUID = 1L;
    @Id //主键
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "assigned")
    private String id;

    @Column(name = "url",nullable = true,length = 1000)
    private String url;

    @Column(name = "params",nullable = true,length = 50)
    private String params;

    @Column(name = "parent",nullable = true,length = 64)
    private String parent;

    @Column(name = "isfarray",nullable = true)
    private int isfArray;//是否数组1是0不是

    @Column(name = "describes",nullable = true,length = 100)
    private String describes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getIsfArray() {
        return isfArray;
    }

    public void setIsfArray(int isfArray) {
        this.isfArray = isfArray;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }
}
