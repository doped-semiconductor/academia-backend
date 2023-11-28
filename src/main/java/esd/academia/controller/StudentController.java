package esd.academia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import esd.academia.model.Student;
import esd.academia.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private static Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	private StudentService studentService;	
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<String>("HelloStudentController", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("test")
	public ResponseEntity<String> testpost(@RequestBody String hi) {
		logger.debug("hi");
		return new ResponseEntity<String>("mix", HttpStatus.CREATED);		
	}
	
	@PostMapping("add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		logger.debug("hi");
		logger.debug(student.toString());
		return new ResponseEntity<Student>(this.studentService.saveStudent(student), HttpStatus.CREATED);		
	}

}
