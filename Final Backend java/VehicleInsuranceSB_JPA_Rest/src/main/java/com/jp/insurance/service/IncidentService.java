package com.jp.insurance.service;
import java.util.List;

import com.jp.insurance.entities.Incident;
import com.jp.insurance.exception.IncidentException;



/** @author Chandra **/
public interface IncidentService {
	//CRUDS Operation
	public Integer addIncident(Incident Incident)throws IncidentException;//C-create
	public List<Incident> getIncidentList()throws IncidentException;//R All Incident -retrieve
	public boolean updateIncident(Incident Incident)throws IncidentException;//U-update
	public boolean deleteIncidentById(Integer incidentId)throws IncidentException;//D-delete
	public Incident getIncidentById(Integer incidentId)throws IncidentException;//S-search
}
