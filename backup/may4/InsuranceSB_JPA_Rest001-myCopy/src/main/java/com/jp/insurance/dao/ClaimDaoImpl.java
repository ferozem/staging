package com.jp.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jp.insurance.entities.Claim;
import com.jp.insurance.exception.ClaimException;


//prep-work 1 -@Repository ClaimDaoImpl
@Repository
public class ClaimDaoImpl implements ClaimDao {
	//prep-work 2 - > @PersistenceContext EntityManager Object
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Integer addClaim(Claim claim) throws ClaimException {
		entityManager.persist(claim);
		return claim.getClaimId();
	}
	
	@Override
	public List<Claim> getClaimList() throws ClaimException {
		Query query = entityManager.createQuery("from Claim");
		return query.getResultList();
	}

	@Override
	public boolean updateClaim(Claim claim) throws ClaimException {
	
		return entityManager.merge(claim)!=null;
	}

	@Override
	public boolean deleteClaimById(Integer claimId) throws ClaimException {
		Claim claim = getClaimById(claimId);
		if(claim == null)
		return false;
		else{
			entityManager.remove(claim);
			return true;
		}
	}

	@Override
	public Claim getClaimById(Integer claimId) throws ClaimException {
		
		return entityManager.find(Claim.class, claimId);
	}

}
