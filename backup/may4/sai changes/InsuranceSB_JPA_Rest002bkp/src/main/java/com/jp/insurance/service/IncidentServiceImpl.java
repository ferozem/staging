package com.jp.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.insurance.dao.IncidentDao;
import com.jp.insurance.entities.Incident;
import com.jp.insurance.exception.IncidentException;



@Service
public class IncidentServiceImpl implements IncidentService {
	
	@Autowired
	private IncidentDao incidentDao;
	
	@Override
	@Transactional
	public Integer addIncident(Incident incident) throws IncidentException {
		// call dao layer method and return to Incident.
		return incidentDao.addIncident(incident);
	}

	@Override
	public List<Incident> getIncidentList() throws IncidentException {
		// call dao layer method and return to Incident.
		System.out.println("From Incident service");
		return incidentDao.getIncidentList();
	}

	@Override
	@Transactional
	public boolean updateIncident(Incident incident) throws IncidentException {
		// call dao layer method and return to Incident.
		return incidentDao.updateIncident(incident);
	}

	@Override
	@Transactional
	public boolean deleteIncidentById(Integer incidentId) throws IncidentException {
		// call dao layer method and return to Incident.
		return incidentDao.deleteIncidentById(incidentId);
	}

	@Override
	public Incident getIncidentById(Integer incidentId) throws IncidentException {
		// call dao layer method and return to Incident.
		return incidentDao.getIncidentById(incidentId);
	}

}
