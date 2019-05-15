package com.jp.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jp.insurance.entities.Nominee;
import com.jp.insurance.exception.NomineeException;

//prep-work 1 -@Repository NomineeDaoImpl
@Repository
public class NomineeDaoImpl implements NomineeDao {
	//prep-work 2 - > @PersistenceContext EntityManager Object
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Long addNominee(Nominee nominee) throws NomineeException {
		System.out.println("From dao: " + nominee);
		entityManager.persist(nominee);
		return nominee.getNomineeId();
	}
	
	@Override
	public List<Nominee> getNomineeList() throws NomineeException {
		Query query = entityManager.createQuery("from Nominee");
		return query.getResultList();
	}

	@Override
	public boolean updateNominee(Nominee nominee) throws NomineeException {
	
		return entityManager.merge(nominee)!=null;
	}

	@Override
	public boolean deleteNomineeById(Long nomineeId) throws NomineeException {
		Nominee nominee = getNomineeById(nomineeId);
		if(nominee == null)
		return false;
		else{
			entityManager.remove(nominee);
			return true;
		}
	}

	@Override
	public Nominee getNomineeById(Long nomineeId) throws NomineeException {
		
		return entityManager.find(Nominee.class, nomineeId);
	}

}
