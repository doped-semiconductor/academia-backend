package esd.academia.model;

import esd.academia.model.Course;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="faculty")
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="faculty_id")
	private long faculty_id;
	
	@Column(name="fname", nullable=false)
	private String firstName;
	
	@Column(name="lname")
	private String lastName;
	
	@Column(name="email",unique = true, nullable=false)
	private String email;
	
	@Column(name="photo")
	private String photoUrl;
	
	@Column(name="title", nullable=false)
	private String title;	
	
	@OneToMany(mappedBy = "facultyId")
	private Set<Course> courses;

}
