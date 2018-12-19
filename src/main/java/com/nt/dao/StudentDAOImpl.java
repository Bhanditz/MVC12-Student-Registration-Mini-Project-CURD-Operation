package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String GET_STUDENT_DETAILS = "SELECT SNO,SNAME,SADDRS,COURSE,FEE FROM STUDENT1 ORDER BY SNO";
	private static final String INSERT_STUDENT_DETAILS = "INSERT INTO STUDENT1(SNO,SNAME,SADDRS,COURSE,FEE)VALUES(?,?,?,?,?)";
	private static final String GET_STUDENT_SEQUENCE = "SELECT SEQ_STUDENT.NEXTVAL FROM DUAL";
	private static final String GET_STUDENT_DETAIL_BY_SNO = "SELECT SNO,SNAME,SADDRS,COURSE,FEE FROM STUDENT1 WHERE SNO=?";
	private static final String UPDATE_STUDENT_DETAIL = "UPDATE STUDENT1 SET SNAME=?,SADDRS=?,COURSE=?,FEE=?  WHERE SNO=?";
	private static final String DELETE_STUDENT_DETAIL_BY_SNO="DELETE FROM STUDENT1 WHERE SNO=?";
	private JdbcTemplate jd;

	public StudentDAOImpl(JdbcTemplate jd) {
		System.out.println("StudentDAOImpl-0-param-constructor");
		this.jd = jd;
	}

	@Override
	public List<StudentBO> getStudentDetails() {
		List<StudentBO> listBO = null;

		// call the method of Jdbc Template
		listBO = jd.query(GET_STUDENT_DETAILS, (ResultSet rs) -> {
			List<StudentBO> list = null;
			StudentBO bo = null;

			// create the arraylist object
			list = new ArrayList<StudentBO>();

			// extracting the data from ResultSet Object
			while (rs.next()) {
				bo = new StudentBO();
				bo.setSno(rs.getInt(1));
				bo.setSname(rs.getString(2));
				bo.setSaddrs(rs.getString(3));
				bo.setCourse(rs.getString(4));
				bo.setFee(rs.getFloat(5));
				list.add(bo);
			} // end of while

			return list;
		}// end of Lamda Inner class

		);// end of jd.query() method

		return listBO;
	}// end of getStudentDetails() method

	@Override
	public int insertStudentRecord(StudentBO bo) {
		System.out.println("insertStudentRecord(StudentBO bo)  method is called");
		int count = 0;
		int sno = 0;
		sno = getSequence();
		System.out.println(sno);
		// method is calling for insert record
		if (sno != 0)
			count = jd.update(INSERT_STUDENT_DETAILS, sno, bo.getSname(), bo.getSaddrs(), bo.getCourse(), bo.getFee());
		// condition to return the record
		if (count != 0)
			return sno;
		else
			return count;
	}// end of insert method

	private int getSequence() {
		System.out.println("getSequence method is called");
		return jd.queryForInt(GET_STUDENT_SEQUENCE);
	}// end of helper method

	@Override
	public StudentBO getStudentRecordBySno(int sno) {
		StudentBO bo = null;

		bo = jd.queryForObject(GET_STUDENT_DETAIL_BY_SNO, new BeanPropertyRowMapper<StudentBO>(StudentBO.class), sno);
		return bo;
	}// end of student detail method

	@Override
	public int updateStudentRecord(StudentBO bo) {
		System.out.println("updateStudentRecord(StudentBO bo)  method is called");
		int result = 0;

		// call the method for update the record
		result = jd.update(UPDATE_STUDENT_DETAIL, bo.getSname(), bo.getSaddrs(), bo.getCourse(), bo.getFee(),
				bo.getSno());

		return result;
	}// end of update method
	
	@Override
	public int deleteStudentRecordBySno(int sno) {
		System.out.println("deleteStudentRecordBySno(int sno)  method is called");
		int result = 0;

		// call the method for update the record
		result = jd.update(DELETE_STUDENT_DETAIL_BY_SNO,sno);

		return result;
	}//end of delete method

}// end of class
