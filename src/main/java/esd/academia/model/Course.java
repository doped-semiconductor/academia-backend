package esd.academia.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
	private long course_id;
	
	@Column(name="code", unique = true, nullable=false)
	private String courseCode;
	
	@Column(name="name", nullable=false)
	private String courseName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="credits", nullable=false)
	private int credits;
	
	@Column(name="capacity")
	private int capacity;	
	
	@ManyToOne
	@JoinColumn(name="fac_id", nullable=false)
	private Faculty facultyId;
	
	@ManyToMany(mappedBy = "enrolledCourses")
	private Set<Student> enrolledStudents;

}
