package com.iddink.afspraak.read.event;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class EenOpEenAfspraak implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	private String title;
	
	private String type;
	
	private String description;
	
	private Date startDate;
	
	private Date endDate;
	
	private String onderwijsProduct;
	
	private String location;
	
	private List<String> attendees;
	
	public EenOpEenAfspraak() {
		
	}

	public EenOpEenAfspraak(String title, String type, String description, Date startDate, Date endDate,
			String onderwijsProduct, String location, List<String> attendees) {
		this.title = title;
		this.type = type;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.onderwijsProduct = onderwijsProduct;
		this.location = location;
		this.attendees = attendees;
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

	public List<String> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<String> attendees) {
		this.attendees = attendees;
	}

	@Override
	public String toString() {
		return "EenOpEenAfspraak [title=" + title + ", type=" + type + ", description=" + description + ", startDate="
				+ startDate + ", endDate=" + endDate + ", onderwijsProduct=" + onderwijsProduct + ", location="
				+ location + ", attendees=" + attendees + "]";
	}
}
