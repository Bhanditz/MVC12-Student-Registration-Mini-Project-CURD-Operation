package com.nt.dao;

import java.util.List;

import com.nt.bo.StudentBO;

public interface StudentDAO {
	public List<StudentBO> getStudentDetails();
	public int insertStudentRecord(StudentBO bo);
	public StudentBO  getStudentRecordBySno(int sno);
	public int updateStudentRecord(StudentBO bo);
	public int  deleteStudentRecordBySno(int sno);
}
