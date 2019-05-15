package com.jp.insurance.dao;

import java.util.List;

import com.jp.insurance.entities.Nominee;
import com.jp.insurance.exception.NomineeException;

public interface NomineeDao {
	
	public Long addNominee(Nominee nominee)throws NomineeException;//C-create
	public List<Nominee> getNomineeList()throws NomineeException;//R All Customer -retrieve
	public boolean updateNominee(Nominee nominee)throws NomineeException;//U-update
	public boolean deleteNomineeById(Long nomineeId)throws NomineeException;//D-delete
	public Nominee getNomineeById(Long nomineeId)throws NomineeException;//S-search

}
