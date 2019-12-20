package com.zhaoya.domain;

public class Vo {

	private String sname;
	private String start;
	private String end;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Vo(String sname, String start, String end) {
		super();
		this.sname = sname;
		this.start = start;
		this.end = end;
	}
	public Vo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
