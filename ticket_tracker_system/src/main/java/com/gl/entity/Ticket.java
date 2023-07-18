package com.gl.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ticket")
public class Ticket {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "content")
	private String content;
	
	@Column(name = "createdOn")
//	@DateTimeFormat(pattern="dd-MM-yyyy")
//	@Column(name = "createdOn", nullable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreatedDate
	private Date createdOn;

	public Ticket() {

	}

	public Ticket(int id, String title, String desc, String content, Date createdDt) {
		this.id = id;
		this.title = title;
		this.description = desc;
		this.content = content;
		this.createdOn = createdDt;
		System.out.println("dt=>"+this.createdOn);
	}

	public Ticket(String title, String desc, String content, Date createdDt) {
		this.title = title;
		this.description = desc;
		this.content = content;
		this.createdOn = createdDt;
		System.out.println("dt1=>"+this.createdOn);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	

}
