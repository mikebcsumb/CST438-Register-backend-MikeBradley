package com.cst438.domain;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository <Student, Integer> {
	
	public Student findByEmail(String email);
	
//	@Modifying
//	@Query("update Student e set e.status_code =:code where e.email =:email")
//	void setStudentStatus(@Param("code") String statusCode, @Param("email") String email);
	
	// declare the following method to return a single Student object
	// default JPA behavior that findBy methods return List<Student> except for findById.
	
	
	

}
