package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {
	private StudentDAO dao = null;

	public StudentServiceImpl(StudentDAO dao) {
		System.out.println("StudentServiceImpl-0-param-Constructor");
		this.dao = dao;
	}

	@Override
	public List<StudentDTO> retrieveStudentDetails() {
		List<StudentDTO> listDTO = new ArrayList<StudentDTO>();
		List<StudentBO> listBO = null;

		// call the DAO class method
		listBO = dao.getStudentDetails();

		// convert listBO data into listDTO dat
		listBO.forEach(bo -> {
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});// end of forEach() method

		return listDTO;
	}// end of retrieveStudentDetails() method

	@Override
	public String registerStudentRecord(StudentDTO dto) {
		System.out.println("registerStudentRecord(StudentDTO dto) method is called");
		String msg = null;
		int sno = 0;
		StudentBO bo = null;

		// create the StudentBO class operation
		bo = new StudentBO();
		// convert StudentBO class object data into StudentDTO class object data
		BeanUtils.copyProperties(dto, bo);

		// call the StudentDAO class method
		sno = dao.insertStudentRecord(bo);

		// check the Condition
		if (sno != 0)
			msg = "Student Registration Successful with Registration Id::" + sno;
		else
			msg = "Student Registration Failed..Please again Fillup the Form with Valid Input";
		return msg;
	}// end of registerStudentRecoed() method

	@Override
	public StudentDTO retrieveStudentDetailBySno(int sno) {
		StudentDTO dto = null;
		StudentBO bo = null;

		// create StudentDTO class object
		dto = new StudentDTO();
		// call the dao class method
		bo = dao.getStudentRecordBySno(sno);

		// convert StudentBO class data into StudnetDTO class data
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}// end of retrieveStudentDetail() method

	@Override
	public String modifyStudentRecord(StudentDTO dto) {
		System.out.println("modifyStudentRecord(StudentDTO dto) method is called");
		String msg = null;
		int result = 0;
		StudentBO bo = null;

		// create the StudentBO class operation
		bo = new StudentBO();
		// convert StudentBO class object data into StudentDTO class object data
		BeanUtils.copyProperties(dto, bo);

		// call the dao class update method
		result = dao.updateStudentRecord(bo);

		// check the Condition
		if (result != 0)
			msg = "Student Record Updated Successfully with Registration Id::" + dto.getSno();
		else
			msg = "Student Updataion Failed..Please again Fillup the Form with Valid Input";
		return msg;
	}// end of modify() method

	@Override
	public String removeStudentDetailBySno(int sno) {
		System.out.println("removeStudentDetailBySno(int sno) method is called");
		int result = 0;
		String msg = null;

		// call the dao class delete method
		result = dao.deleteStudentRecordBySno(sno);

		// check the Condition
		if (result != 0)
			msg = "Student Record Deleted Successfully with Registration Id::" + sno;
		else
			msg = "Student Record not Deleted";

		return msg;
	}// end of remove method

}// end of class
