package com.zhaoya.service;

import java.util.ArrayList;


import com.github.pagehelper.PageInfo;
import com.zhaoya.domain.Course;
import com.zhaoya.domain.Student;
import com.zhaoya.domain.Vo;

public interface StudentService {

	PageInfo<Student> getStudentList(Vo vo, int pageNum);

	void del(String sid);

	ArrayList<Course> getCourseList();

	void addStudent(Student student);

	Student getStudentById(int sid);

	void updateStudent(Student student);

}
