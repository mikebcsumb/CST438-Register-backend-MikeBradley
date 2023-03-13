package com.cst438.domain;

public class StudentDTO {

	public int id;
	public String studentEmail;
	public String studentName;
	public int statusCode;
	
	public StudentDTO() {
		this.id = 0;
		this.studentEmail=null;
		this.studentName=null;
		this.statusCode=0;
	}
	
	
	public StudentDTO(String studentEmail, String studentName) {
		this.id = 0;
		this.studentEmail=studentEmail;
		this.studentName=studentName;
		this.statusCode=0;
		
	}


	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", studentEmail=" + studentEmail + ", studentName=" + studentName
				+ "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentDTO other = (StudentDTO) obj;
		if (id != other.id)
			return false;
		if (studentEmail == null) {
			if (other.studentEmail != null)
				return false;
		} else if (!studentEmail.equals(other.studentEmail))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (statusCode != other.statusCode)
			return false;
		return true;
	}
	
	
	
	
}
