package com.zhaoya.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.zhaoya.domain.Course;
import com.zhaoya.domain.Student;
import com.zhaoya.domain.Vo;

public interface StudentMapper {

	ArrayList<Student> getStudentList(Vo vo);

	void del(@Param("sid")String sid);

	void delCenter(@Param("sid")String sid);

	ArrayList<Course> getCourseList();

	void addCenter(@Param("sid")Integer sid, @Param("cid")int cid);

	void addStudent(Student student);

	Student getStudentById(@Param("sid")int sid);

	void updateStudent(Student student);

}
