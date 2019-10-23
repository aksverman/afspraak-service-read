package com.iddink.afspraak.read.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Afspraak {
	
	@Id
	@Column(length=50)
	private String afspraakId; 
	
	private String title;
	
	private String type;
	
	private String description;
	
	private Date startDate;
	
	private Date endDate;
	
	private String onderwijsProduct;
	
	private String location;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="afspraak_id")
	private List<Attendees> attendees;
	
	public Afspraak() {

	}

	public Afspraak(String afspraakId, String title, String type, String description, Date startDate, Date endDate,
			String onderwijsProduct, String location, List<Attendees> attendees) {
		this.afspraakId = afspraakId;
		this.title = title;
		this.type = type;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.onderwijsProduct = onderwijsProduct;
		this.location = location;
		this.attendees = attendees;
	}

	public String getAfspraakId() {
		return afspraakId;
	}

	public void setAfspraakId(String afspraakId) {
		this.afspraakId = afspraakId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getOnderwijsProduct() {
		return onderwijsProduct;
	}

	public void setOnderwijsProduct(String onderwijsProduct) {
		this.onderwijsProduct = onderwijsProduct;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Attendees> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<Attendees> attendees) {
		this.attendees = attendees;
	}
}
