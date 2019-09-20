package com.yi.domain;

import java.util.Date;
import java.util.List;

public class BoardVO {
	private int bno;
	private Date regdate;
	private String file;
	private String originfile;
	private String writer;
	
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
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getOriginfile() {
		return originfile;
	}
	public void setOriginfile(String originfile) {
		this.originfile = originfile;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", regdate=" + regdate + ", file=" + file + ", originfile=" + originfile
				+ ", writer=" + writer + "]";
	}
}
