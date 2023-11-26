package esd.academia.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private long student_id;
	
	@Column(name="roll", unique = true, nullable=false)
	private String rollNumber;
	
	@Column(name="fname", nullable=false)
	private String firstName;
	
	@Column(name="lname")
	private String lastName;
	
	@Column(name="email",unique = true, nullable=false)
	private String email;
	
	@Column(name="photo")
	private String photoUrl;
	
	@Column(name="cgpa", nullable=false)
	private double cgpa = 0.0;
	
	@Column(name="credits", nullable=false)
	private int totalCredits;
	
	@Column(name="gradyear")
	private int graduationYear;	
	
	@ManyToMany
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> enrolledCourses;

}
