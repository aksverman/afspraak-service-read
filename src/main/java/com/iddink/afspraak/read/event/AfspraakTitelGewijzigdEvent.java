package com.iddink.afspraak.read.event;

import java.io.Serializable;
import java.util.UUID;

public class AfspraakTitelGewijzigdEvent implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private UUID afspraakID;
	
	private String updatedTitle;
	
	public AfspraakTitelGewijzigdEvent() {
		
	}

	public AfspraakTitelGewijzigdEvent(UUID afspraakID, String updatedTitle) {
		this.afspraakID = afspraakID;
		this.updatedTitle = updatedTitle;
	}

	public UUID getAfspraakID() {
		return afspraakID;
	}

	public void setAfspraakID(UUID afspraakID) {
		this.afspraakID = afspraakID;
	}

	public String getUpdatedTitle() {
		return updatedTitle;
	}

	public void setUpdatedTitle(String updatedTitle) {
		this.updatedTitle = updatedTitle;
	}

	@Override
	public String toString() {
		return "AfspraakTitelGewijzigdEvent [afspraakID=" + afspraakID + ", updatedTitle=" + updatedTitle + "]";
	}
}
