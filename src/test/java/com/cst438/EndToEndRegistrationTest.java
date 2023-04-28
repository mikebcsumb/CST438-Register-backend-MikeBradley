package com.cst438;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cst438.domain.Course;
import com.cst438.domain.CourseRepository;
import com.cst438.domain.Enrollment;
import com.cst438.domain.EnrollmentRepository;
import com.cst438.domain.Student;
import com.cst438.domain.StudentRepository;

/*
 * This example shows how to use selenium testing using the web driver 
 * with Chrome browser.
 * 
 *  - Buttons, input, and anchor elements are located using XPATH expression.
 *  - onClick( ) method is used with buttons and anchor tags.
 *  - Input fields are located and sendKeys( ) method is used to enter test data.
 *  - Spring Boot JPA is used to initialize, verify and reset the database before
 *      and after testing.
 *      
 *    Make sure that TEST_COURSE_ID is a valid course for TEST_SEMESTER.
 *    
 *    URL is the server on which Node.js is running.
 */

@SpringBootTest
public class EndToEndRegistrationTest {
	public static final String CHROME_DRIVER_FILE_LOCATION = "C:/chromedriver_win32/chromedriver.exe";

	public static final String URL = "http://localhost:3000/admin";

	public static final String TEST_USER_EMAIL = "testCod3";
	
	public static final String TEST_USER_NAME = "Naemtesto";

	public static final int SLEEP_DURATION = 1000; // 1 second.

	/*
	 * When running in @SpringBootTest environment, database repositories can be used
	 * with the actual database.
	 */
	
	@Autowired
	StudentRepository studentrepo;

	/*
	 * Student is added to the register.
	 */
	
	@Test
	public void addStudentTest() throws Exception {

		/*
		 * if student is exists then remove student.
		 */
		
		Student x = null;
		do {
			x = studentrepo.findByEmail(TEST_USER_EMAIL);
			
			if (x != null)
				studentrepo.delete(x);
		} while (x != null);

		// set the driver location and start driver
		//@formatter:off
		// browser	property name 				Java Driver Class
		// edge 	webdriver.edge.driver 		EdgeDriver
		// FireFox 	webdriver.firefox.driver 	FirefoxDriver
		// IE 		webdriver.ie.driver 		InternetExplorerDriver
		//@formatter:on

		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_FILE_LOCATION);
		WebDriver driver = new ChromeDriver();
		// Puts an Implicit wait for 10 seconds before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			driver.get(URL);
			Thread.sleep(SLEEP_DURATION);

			// Locate and click "Add student" button
			
			driver.findElement(By.xpath("//button[@id='addstudent']")).click();
			Thread.sleep(SLEEP_DURATION);

			// enter email + name and click Add button
			driver.findElement(By.xpath("//input[@name='name']")).sendKeys(TEST_USER_NAME);
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(TEST_USER_EMAIL);

			driver.findElement(By.xpath("//button[@id='Add']")).click();
			Thread.sleep(SLEEP_DURATION);

			/*
			* verify that new student shows in database.
			*/ 
		
			Student student = studentrepo.findByEmail(TEST_USER_EMAIL);
			boolean found = false;
			if (student.getEmail().equals(TEST_USER_EMAIL)) {
				found = true;
			}
			
			
			assertTrue( found, "Student added to database");
			
			// verify that enrollment row has been inserted to database.
			

		} catch (Exception ex) {
			throw ex;
		} finally {

			// clean up database.
			x = null;
			x = studentrepo.findByEmail(TEST_USER_EMAIL);
			if (x != null)
				studentrepo.delete(x);
		} 

			driver.quit();
	}

}
