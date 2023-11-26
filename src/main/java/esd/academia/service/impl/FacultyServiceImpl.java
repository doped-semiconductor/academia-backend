package esd.academia.service.impl;

import org.springframework.stereotype.Service;

import esd.academia.model.Faculty;
import esd.academia.repository.FacultyRepository;
import esd.academia.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {
	
	private FacultyRepository facultyRepo;

	public FacultyServiceImpl(FacultyRepository facultyRepo) {
		super();
		this.facultyRepo = facultyRepo;
	}

	@Override
	public Faculty saveFaculty(Faculty faculty) {
		return facultyRepo.save(faculty);
	}

}
