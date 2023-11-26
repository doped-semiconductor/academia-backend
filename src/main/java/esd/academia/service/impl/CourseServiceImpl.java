package esd.academia.service.impl;

import org.springframework.stereotype.Service;

import esd.academia.model.Course;
import esd.academia.repository.CourseRepository;
import esd.academia.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	private CourseRepository courseRepo;
	
	public CourseServiceImpl(CourseRepository courseRepo) {
		super();
		this.courseRepo = courseRepo;
	}

	@Override
	public Course saveCourse(Course course) {
		return courseRepo.save(course);
	}

}
