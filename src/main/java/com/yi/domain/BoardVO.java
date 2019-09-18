package com.yi.domain;

import java.util.Date;
import java.util.List;

public class BoardVO {
	private int bno;
	private Date regdate;
	private List<String> files;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public List<String> getFiles() {
		return files;
	}
	public void setFiles(List<String> files) {
		this.files = files;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", regdate=" + regdate + ", files=" + files + "]";
	}
	
}
