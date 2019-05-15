package com.jp.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.insurance.dao.NomineeDao;
import com.jp.insurance.entities.Nominee;
import com.jp.insurance.exception.NomineeException;

@Service
public class NomineeServiceImpl implements NomineeService {
	
	@Autowired
	private NomineeDao nomineeDao;
	
	@Override
	@Transactional
	public Long addNominee(Nominee nominee) throws NomineeException {
		// call dao layer method and return to Client.
		return nomineeDao.addNominee(nominee);
	}

	@Override
	public List<Nominee> getNomineeList() throws NomineeException {
		// call dao layer method and return to Client.
		System.out.println("From service");
		return nomineeDao.getNomineeList();
	}

	@Override
	@Transactional
	public boolean updateNominee(Nominee nominee) throws NomineeException {
		// call dao layer method and return to Client.
		return nomineeDao.updateNominee(nominee);
	}

	@Override
	@Transactional
	public boolean deleteNomineeById(Long nomineeId) throws NomineeException {
		// call dao layer method and return to Client.
		return nomineeDao.deleteNomineeById(nomineeId);
	}

	@Override
	public Nominee getNomineeById(Long nomineeId) throws NomineeException {
		// call dao layer method and return to Client.
		return nomineeDao.getNomineeById(nomineeId);
	}

}
