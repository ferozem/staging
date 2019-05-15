package com.jp.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jp.insurance.entities.Incident;
import com.jp.insurance.exception.IncidentException;


//prep-work 1 -@Repository IncidentDaoImpl
@Repository
public class IncidentDaoImpl implements IncidentDao {
	//prep-work 2 - > @PersistenceContext EntityManager Object
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Integer addIncident(Incident incident) throws IncidentException {
		entityManager.persist(incident);
		return incident.getIncidentId();
	}
	
	@Override
	public List<Incident> getIncidentList() throws IncidentException {
		Query query = entityManager.createQuery("from Incident");
		return query.getResultList();
	}

	@Override
	public boolean updateIncident(Incident incident) throws IncidentException {
	
		return entityManager.merge(incident)!=null;
	}

	@Override
	public boolean deleteIncidentById(Integer incidentId) throws IncidentException {
		Incident incident = getIncidentById(incidentId);
		if(incident == null)
		return false;
		else{
			entityManager.remove(incident);
			return true;
		}
	}

	@Override
	public Incident getIncidentById(Integer incidentId) throws IncidentException {
		
		return entityManager.find(Incident.class, incidentId);
	}

}
