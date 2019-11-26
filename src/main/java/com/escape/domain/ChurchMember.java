package com.escape.domain;

import java.util.Date;

public class ChurchMember {
	
	private String id = "";
	
	private String email = "";
	
	private String name = "";
	
	private String church_name = "";
	
	private String church_root = "";
	
	private String church_category = "";
	
	private String send_email_yn = "N";
	
	private String send_zc_yn = "N";
	
	private String del_yn = "N";
	
	private Date ins_date = new Date();
	
	private Date upd_date = new Date();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChurch_name() {
		return church_name;
	}

	public void setChurch_name(String church_name) {
		this.church_name = church_name;
	}

	public String getChurch_root() {
		return church_root;
	}

	public void setChurch_root(String church_root) {
		this.church_root = church_root;
	}

	public String getChurch_category() {
		return church_category;
	}

	public void setChurch_category(String church_category) {
		this.church_category = church_category;
	}

	public String getSend_email_yn() {
		return send_email_yn;
	}

	public void setSend_email_yn(String send_email_yn) {
		this.send_email_yn = send_email_yn;
	}

	public String getSend_zc_yn() {
		return send_zc_yn;
	}

	public void setSend_zc_yn(String send_zc_yn) {
		this.send_zc_yn = send_zc_yn;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

	public Date getIns_date() {
		return ins_date;
	}

	public void setIns_date(Date ins_date) {
		this.ins_date = ins_date;
	}

	public Date getUpd_date() {
		return upd_date;
	}

	public void setUpd_date(Date upd_date) {
		this.upd_date = upd_date;
	}

}
