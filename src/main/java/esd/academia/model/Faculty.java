package esd.academia.model;

import java.util.Set;

import org.antlr.v4.runtime.misc.NotNull;

import esd.academiaa.dto.FacultyDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="faculty")
public class Faculty {
	
	public Faculty() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="faculty_id")
	private long faculty_id;
	
	@Column(name="firstname", nullable=false)
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="email",unique = true, nullable=false)
	private String email;
	
	@Column(name="photourl")
	private String photourl;
	
	@Column(name="title", nullable=false)
	private String title;	
	
	@OneToMany(mappedBy = "facultyId")
	private Set<Course> courses;

	public Faculty(FacultyDTO fac) {
		super();
		this.firstname = fac.getFirstname();
		this.lastname = fac.getLastname();
		this.email = fac.getEmail();
		this.photourl = fac.getPhotourl();
		this.title = fac.getTitle();
	}

	@Override
	public String toString() {
		return "Faculty [faculty_id=" + faculty_id + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", photourl=" + photourl + ", title=" + title + ", courses=" + courses + "]";
	}

	public long getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(long faculty_id) {
		this.faculty_id = faculty_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhotourl() {
		return photourl;
	}

	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	

}
