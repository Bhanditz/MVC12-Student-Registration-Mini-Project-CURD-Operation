package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class StudentListController extends AbstractController {
	private StudentService service;

	public StudentListController(StudentService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
        List<StudentDTO> listDTO=null;
        ModelAndView mav=null;
        
        //call the Service class method
        listDTO=service.retrieveStudentDetails();
        //create the ModelAndView class  object
        mav=new ModelAndView();
        mav.setViewName("stud_list");
        mav.addObject("studentList", listDTO);
		return mav;
	}//end of handleRequestInternal() method
	
}//end of class
