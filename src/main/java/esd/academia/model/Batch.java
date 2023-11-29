package esd.academia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="batch")
public class Batch {
	
	@Id
	@Column(name="batch_id")
	private String batch_id;
	
	@Column(name="degree")
	private String degree;
	
	@Column(name="year")
	private int year;	
	
	@Column(name="batch_code")
	private String batch_code;
	
	@PrePersist
	public void generateBatchCode() {
		this.batch_id = this.degree + Integer.toString(this.year);
		
	}

	public Batch() {
		super();
	}

	public String getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBatch_code() {
		return batch_code;
	}

	public void setBatch_code(String batch_code) {
		this.batch_code = batch_code;
	}

}
