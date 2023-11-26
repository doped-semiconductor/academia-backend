package esd.academia.service.impl;

import org.springframework.stereotype.Service;

import esd.academia.model.Student;
import esd.academia.repository.StudentRepository;
import esd.academia.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepo;

	public StudentServiceImpl(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

}
