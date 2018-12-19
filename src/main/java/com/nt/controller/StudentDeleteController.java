package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class StudentDeleteController extends AbstractController {
	private StudentService service;

	public StudentDeleteController(StudentService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int sno = 0;
		String msg = null;
		List<StudentDTO> listDTO = null;
		ModelAndView mav = null;

		// get the data from request Parameter
		sno = Integer.parseInt(req.getParameter("sno"));

		// call the service class method
		msg = service.removeStudentDetailBySno(sno);

		// call the service class get student details method
		listDTO = service.retrieveStudentDetails();

		// create the ModelAndView class object
		mav = new ModelAndView();
		mav.addObject("studentList", listDTO);
		mav.addObject("message", msg);
		mav.setViewName("stud_list");

		return mav;
	}// end of handleRequestInternal() method

}// end of class
