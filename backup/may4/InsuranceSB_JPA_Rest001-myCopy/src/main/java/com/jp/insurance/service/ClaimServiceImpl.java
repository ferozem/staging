package com.jp.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.insurance.dao.ClaimDao;
import com.jp.insurance.entities.Claim;
import com.jp.insurance.exception.ClaimException;

@Service
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired
	private ClaimDao claimDao;
	
	@Override
	@Transactional
	public Integer addClaim(Claim claim) throws ClaimException {
		// call dao layer method and return to Client.
		return claimDao.addClaim(claim);
	}

	@Override
	public List<Claim> getClaimList() throws ClaimException {
		// call dao layer method and return to Client.
		System.out.println("From service");
		return claimDao.getClaimList();
	}

	@Override
	@Transactional
	public boolean updateClaim(Claim claim) throws ClaimException {
		// call dao layer method and return to Client.
		return claimDao.updateClaim(claim);
	}

	@Override
	@Transactional
	public boolean deleteClaimById(Integer claimId) throws ClaimException {
		// call dao layer method and return to Client.
		return claimDao.deleteClaimById(claimId);
	}

	@Override
	public Claim getClaimById(Integer claimId) throws ClaimException {
		// call dao layer method and return to Client.
		return claimDao.getClaimById(claimId);
	}

}
