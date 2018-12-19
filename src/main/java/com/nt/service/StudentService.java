package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDTO;

public interface StudentService {
	public List<StudentDTO> retrieveStudentDetails();
	public String registerStudentRecord(StudentDTO dto);
	public StudentDTO retrieveStudentDetailBySno(int sno);
	public String modifyStudentRecord(StudentDTO dto);
	public String removeStudentDetailBySno(int sno);
}
