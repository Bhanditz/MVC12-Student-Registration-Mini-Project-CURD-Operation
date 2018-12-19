package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.StudentCommand;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class StudentInsertController extends SimpleFormController {
	private StudentService service;

	public StudentInsertController(StudentService service) {
		System.out.println("StudentInsertController-0-param-controller");
		this.service = service;
	}// end of constructor

	@Override
	public ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object command, BindException errors)
			throws Exception {
       System.out.println("onSubmit() method is called");
		StudentCommand cmd = null;
		StudentDTO dto = null;
		String msg = null;
		List<StudentDTO> listDTO=null;
		ModelAndView mav=null;
		

		// create the StudentDTO class object
		dto = new StudentDTO();
		// downcast the StudentCommand class object
		cmd = (StudentCommand) command;

		// convert the StudentCommand class object data into StudentDTO class object
		// data
		BeanUtils.copyProperties(cmd, dto);

		// call the Service Class object
		msg = service.registerStudentRecord(dto);
		//call the service class get student details method
		listDTO=service.retrieveStudentDetails();
		
		//create the ModelAndView class object
		mav=new ModelAndView();
		mav.addObject("studentList", listDTO);
		mav.addObject("message", msg);
		mav.setViewName("stud_list");
		
		return mav;
	}//end of the onSubmit() method
	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		return showNewForm(req, res);
	}
	
}// end of class
