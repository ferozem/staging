package com.jp.insurance.service;

import java.util.List;

import com.jp.insurance.entities.Nominee;
import com.jp.insurance.exception.NomineeException;

public interface NomineeService {
	//CRUDS Operation
	public Long addNominee(Nominee Nominee)throws NomineeException;//C-create
	public List<Nominee> getNomineeList()throws NomineeException;//R All Nominee -retrieve
	public boolean updateNominee(Nominee Nominee)throws NomineeException;//U-update
	public boolean deleteNomineeById(Long nomineeId)throws NomineeException;//D-delete
	public Nominee getNomineeById(Long nomineeId)throws NomineeException;//S-search
}
