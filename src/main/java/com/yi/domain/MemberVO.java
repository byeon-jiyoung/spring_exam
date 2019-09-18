package com.yi.domain;

import java.util.Date;

public class MemberVO {
	private String userid;
	private String userpw;
	private String username;
	private String email;
	private String tel;
	private Date regdate;
	
	public MemberVO() {
	}
	
	public MemberVO(String userid) {
		super();
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", email=" + email
				+ ", tel=" + tel + ", regdate=" + regdate + "]";
	}
	

}
