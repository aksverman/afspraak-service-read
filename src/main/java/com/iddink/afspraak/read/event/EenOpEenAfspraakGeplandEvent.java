package com.iddink.afspraak.read.event;

import java.io.Serializable;
import java.util.Date;

public class EenOpEenAfspraakGeplandEvent implements Serializable{	
	
	private static final long serialVersionUID = 1L;

	private String afspraakID;
	
	private Date dtStamp;
	
	private EenOpEenAfspraak appointmentData;
	
	public EenOpEenAfspraakGeplandEvent() {

	}

	public EenOpEenAfspraakGeplandEvent(String afspraakID, Date dtStamp, EenOpEenAfspraak appointmentData) {
		this.afspraakID = afspraakID;
		this.dtStamp = dtStamp;
		this.appointmentData = appointmentData;
	}

	public String getAfspraakID() {
		return afspraakID;
	}

	public void setAfspraakID(String afspraakID) {
		this.afspraakID = afspraakID;
	}

	public Date getDtStamp() {
		return dtStamp;
	}

	public void setDtStamp(Date dtStamp) {
		this.dtStamp = dtStamp;
	}

	public EenOpEenAfspraak getAppointmentData() {
		return appointmentData;
	}

	public void setAppointmentData(EenOpEenAfspraak appointmentData) {
		this.appointmentData = appointmentData;
	}

	@Override
	public String toString() {
		return "EenOpEenAfspraakGeplandEvent [afspraakID=" + afspraakID + ", dtStamp=" + dtStamp + ", appointmentData="
				+ appointmentData + "]";
	}	
}
