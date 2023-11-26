package esd.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import esd.academia.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
