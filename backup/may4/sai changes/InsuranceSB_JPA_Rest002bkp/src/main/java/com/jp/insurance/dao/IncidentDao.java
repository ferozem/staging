package com.jp.insurance.dao;
import java.util.List;

import com.jp.insurance.entities.Incident;
import com.jp.insurance.exception.IncidentException;



/** @author Chandra **/
public interface IncidentDao {
	public Integer addIncident(Incident incident)throws IncidentException;//C-create
	public List<Incident> getIncidentList()throws IncidentException;//R All Customer -retrieve
	public boolean updateIncident(Incident incident)throws IncidentException;//U-update
	public boolean deleteIncidentById(Integer incidentId)throws IncidentException;//D-delete
	public Incident getIncidentById(Integer incidentId)throws IncidentException;//S-search
}
