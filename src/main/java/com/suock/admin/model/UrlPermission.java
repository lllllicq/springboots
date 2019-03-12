package com.suock.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_api_url")
public class UrlPermission implements Serializable {
    private static long serialVersionUID = 1L;
    @Id //主键
    @GeneratedValue(generator = "url")
    @GenericGenerator(name = "url", strategy = "assigned")
    private String url;

    @Column(name = "describes",nullable = true,length = 100)
    private String describes;

    @Column(name = "status",nullable = true)
    private Integer status=1;//1可用，0禁用

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
