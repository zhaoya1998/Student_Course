package com.zhaoya.domain;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Student {

	private Integer sid;
	@NotEmpty(message="不能为空")
	private String sname;
	@NotEmpty(message="不能为空")
	@Size(min=1,max=6)
	private String pwd;
	private String age;
	@NotEmpty(message="不能为空")
	private String birthday;
	@NotEmpty(message="不能为空")
	private String sex;
	
	private int[] cids;
	
	private List<Course> courses;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int[] getCids() {
		return cids;
	}

	public void setCids(int[] cids) {
		this.cids = cids;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Student(Integer sid, @NotEmpty(message = "不能为空") String sname,
			@NotEmpty(message = "不能为空") @Size(min = 1, max = 6) String pwd, String age,
			@NotEmpty(message = "不能为空") String birthday, @NotEmpty(message = "不能为空") String sex, int[] cids,
			List<Course> courses) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.pwd = pwd;
		this.age = age;
		this.birthday = birthday;
		this.sex = sex;
		this.cids = cids;
		this.courses = courses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
