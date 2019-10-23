package com.iddink.afspraak.read.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Attendees {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String attendee;
	
	@ManyToOne
	@JoinColumn(name="afspraak_id")
	private Afspraak afspraak;
	
	public Attendees() {
		
	}

	public Attendees(String attendee) {
		this.attendee = attendee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttendee() {
		return attendee;
	}

	public void setAttendee(String attendee) {
		this.attendee = attendee;
	} 
}
