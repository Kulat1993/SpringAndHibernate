package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	// annotate class as an entity and map to db table
	
	// define the fields
	
	// annotate columns to db
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;

	// create constructors
	public InstructorDetail() {
		
	}
	
	public InstructorDetail(String youtube, String hobby) {
		super();
		this.youtubeChannel = youtube;
		this.hobby = hobby;
	}
	
	// create getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutube() {
		return youtubeChannel;
	}

	public void setYoutube(String youtube) {
		this.youtubeChannel = youtube;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	// create toString() method
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtube=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
}
