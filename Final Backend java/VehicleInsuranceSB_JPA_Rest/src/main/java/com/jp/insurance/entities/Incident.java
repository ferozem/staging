package com.jp.insurance.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INCIDENT")
public class Incident {

	@SequenceGenerator(name="INCIDENT_GEN", sequenceName="INCIDENT_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="INCIDENT_GEN")
    @Id
    @Column(name="INCIDENT_ID")
    private Integer incidentId;

    @Column(name="INCIDENT_TYPE")
    private String incidentType;

    @Column(name="INCIDENT_DATE")
    private Date incidentDate;

    @Column(name="INCIDENT_DESCRIPTION")
    private String incidentDescription;

	public Integer getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(Integer incidentId) {
		this.incidentId = incidentId;
	}

	public String getIncidentType() {
		return incidentType;
	}

	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}

	public Date getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(Date incidentDate) {
		this.incidentDate = incidentDate;
	}

	public String getIncidentDescription() {
		return incidentDescription;
	}

	public void setIncidentDescription(String incidentDescription) {
		this.incidentDescription = incidentDescription;
	}

	public Incident() {
		super();
	}

	public Incident(Integer incidentId, String incidentType, Date incidentDate, String incidentDescription) {
		super();
		this.incidentId = incidentId;
		this.incidentType = incidentType;
		this.incidentDate = incidentDate;
		this.incidentDescription = incidentDescription;
	}

	@Override
	public String toString() {
		return "Incident [incidentId=" + incidentId + ", incidentType=" + incidentType + ", incidentDate="
				+ incidentDate + ", incidentDescription=" + incidentDescription + "]";
	}

   

}
