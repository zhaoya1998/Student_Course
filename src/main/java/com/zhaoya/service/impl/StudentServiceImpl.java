package com.zhaoya.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaoya.dao.StudentMapper;
import com.zhaoya.domain.Course;
import com.zhaoya.domain.Student;
import com.zhaoya.domain.Vo;
import com.zhaoya.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentMapper mapper;
	@Override
	public PageInfo<Student> getStudentList(Vo vo, int pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 3);
		ArrayList<Student> list=mapper.getStudentList(vo);
		PageInfo<Student> info=new PageInfo<Student>(list);
		return info;
	}
	@Override
	public void del(String sid) {
		// TODO Auto-generated method stub
		mapper.del(sid);
		mapper.delCenter(sid);
	}
	@Override
	public ArrayList<Course> getCourseList() {
		// TODO Auto-generated method stub
		return mapper.getCourseList();
	}
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		mapper.addStudent(student);
		if(student.getCids()!=null) {
			int[] cids=student.getCids();
			for (int cid : cids) {
				mapper.addCenter(student.getSid(),cid);
			}
		}
	}
	@Override
	public Student getStudentById(int sid) {
		// TODO Auto-generated method stub
		return mapper.getStudentById(sid);
	}
	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		mapper.updateStudent(student);
	}

}
