package esd.academia.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="specialization")
public class Specialization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="spec_id")
	private long spec_id;
	
	@Column(name="code", unique = true, nullable = false)
	private String code;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="credits_req", nullable = false)
	private int credits_req;
	
	@OneToMany(mappedBy = "specId")
	private Set<Course> associatedCourses = new HashSet<>();

}
