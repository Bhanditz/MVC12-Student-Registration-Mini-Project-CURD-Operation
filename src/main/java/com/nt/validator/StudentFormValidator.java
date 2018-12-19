package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.StudentCommand;

public class StudentFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(StudentCommand.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		StudentCommand cmd = null;

		// downCast the StudentCommand class object
		cmd = (StudentCommand) command;

		if (cmd.getSname() == null || cmd.getSname().trim().equals("") || cmd.getSname().trim().length()==0 ) {
			errors.rejectValue("sname", "sname.required");
		}
		
		if (cmd.getSaddrs() == null || cmd.getSaddrs().trim().equals("") || cmd.getSaddrs().trim().length()==0 ) {
			errors.rejectValue("saddrs", "saddrs.required");
		}
		
		if (cmd.getCourse() == null || cmd.getCourse().trim().equals("") || cmd.getCourse().trim().length()==0) {
			errors.rejectValue("course", "course.required");
		}
		
		if (cmd.getFee()<=0) {
			errors.rejectValue("fee", "spring.fee.required");
			cmd.setFee(1200);
		}

	}// end of validate method

}//end of class
