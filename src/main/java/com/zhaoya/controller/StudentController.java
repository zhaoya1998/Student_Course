package com.zhaoya.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhaoya.domain.Course;
import com.zhaoya.domain.Student;
import com.zhaoya.domain.Vo;
import com.zhaoya.service.StudentService;

@Controller
public class StudentController {

	@Resource
	private StudentService service;
	
	@RequestMapping("list")
	public String list(Model m,Vo vo,@RequestParam(defaultValue = "1")int pageNum) {
		PageInfo<Student> info=service.getStudentList(vo,pageNum);
		m.addAttribute("vo", vo);
		m.addAttribute("info", info);
		return "list";
	}
	
	@ResponseBody
	@RequestMapping("del")
	public boolean del(String sid) {
		try {
			service.del(sid);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("toAdd")
	public String toAdd(Model m) {
		ArrayList<Course> courses=service.getCourseList();
		m.addAttribute("courses", courses);
		m.addAttribute("student", new Student());
		return "add";
	}
	
	@RequestMapping("add")
	public String add(Model m,@Valid @ModelAttribute("student")Student student,BindingResult result ) {
		if(result.hasErrors()) {
			ArrayList<Course> courses=service.getCourseList();
			m.addAttribute("courses", courses);
			return "add";
		}
		service.addStudent(student);
		return "redirect:list";
	}
	
    @RequestMapping("toUpdate")
    public String toUpdate(Model m,int sid) {
    	ArrayList<Course> courses=service.getCourseList();
		m.addAttribute("courses", courses);
		Student student=service.getStudentById(sid);
		m.addAttribute("student", student);
		return "update";
    }
    
    @RequestMapping("update")
	public String update(Model m,@Valid @ModelAttribute("student")Student student,BindingResult result ) {
		if(result.hasErrors()) {
			ArrayList<Course> courses=service.getCourseList();
			m.addAttribute("courses", courses);
			return "update";
		}
		service.updateStudent(student);
		return "redirect:list";
	}
}
