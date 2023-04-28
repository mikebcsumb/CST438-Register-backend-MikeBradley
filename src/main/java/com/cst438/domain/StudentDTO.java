package com.cst438.domain;

public class StudentDTO {

	public int id;
	public String email;
	public String name;
	public int statusCode;
	
	public StudentDTO() {
		this.id = 0;
		this.email=null;
		this.name=null;
		this.statusCode=0;
	}
	
	
	public StudentDTO(String studentEmail, String studentName) {
		this.id = 0;
		this.email=studentEmail;
		this.name=studentName;
		this.statusCode=0;
		
	}


	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", studentEmail=" + email + ", studentName=" + name
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (statusCode != other.statusCode)
			return false;
		return true;
	}
	
	
	
	
}