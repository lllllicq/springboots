package com.suock.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_api_user")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static long serialVersionUID = 1L;
	@Id //主键
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "assigned")
    private String id;
	
	@Column(name = "loginname",nullable = true)
	private String loginName;
	

	@Column(name = "realname",nullable = true)
	private String realName;

	@Column(name = "passwd",nullable = true)
	private String passwd;


	@Column(name = "createdate",nullable = true)
	private Date date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
