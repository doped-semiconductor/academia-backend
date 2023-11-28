package esd.academia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esd.academia.model.Faculty;
import esd.academia.service.FacultyService;
import esd.academiaa.dto.FacultyDTO;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	
	private FacultyService facultyService;
	
	public FacultyController(FacultyService facultyService) {
		super();
		this.facultyService = facultyService;
	}
	
	@GetMapping("test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<String>("HelloFacultyController", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Faculty>> getAllFaculty(){
		List<Faculty> res = null;
		HttpStatus status = HttpStatus.ACCEPTED;
		
		try {
			List<Faculty> lFac = facultyService.getFaculties();	
			res = lFac;
		}
		catch (Exception e) {
			System.out.println("Error: "+e.getClass());
			System.out.println("Error: "+e.getMessage());
			System.out.println("Error: "+e.getStackTrace());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<List<Faculty>>(res, status);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Faculty> getFacultyById(@PathVariable long id){
		Faculty res = null;
		HttpStatus status = HttpStatus.ACCEPTED;
		
		try {
			Optional<Faculty> fac = facultyService.getFacultyById(id);
			if(fac.isPresent()) {
				res = fac.get();
			}
		}
		catch (Exception e) {
			System.out.println("Error: "+e.getClass());
			System.out.println("Error: "+e.getMessage());
			status = HttpStatus.NOT_FOUND;
		}
		
		return new ResponseEntity<Faculty>(res, status);
		
	}
	
	@PostMapping(path = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> addFaculty(@RequestBody Faculty faculty){
		System.out.println("Adding: "+faculty);
		String msg = "Successfully Added!";
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			Faculty newFac = facultyService.saveFaculty(faculty);		
			System.out.println("Added: "+newFac);
		}
		catch (Exception e) {
			System.out.println("Error: "+e.getClass());
			System.out.println("Error: "+e.getMessage());
			System.out.println("Error: "+e.getStackTrace());
			System.out.println("Error: "+e.getCause());
			msg = "Something went wrong - "+e.getMessage();
			status = HttpStatus.UNPROCESSABLE_ENTITY;
		}
		return new ResponseEntity<String>(msg, status);		
	}

}
