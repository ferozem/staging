package com.jp.insurance.service;
import java.util.List;

import com.jp.insurance.entities.Claim;
import com.jp.insurance.exception.ClaimException;



/** @author Chandra **/
public interface ClaimService {
	//CRUDS Operation
	public Integer addClaim(Claim Claim)throws ClaimException;//C-create
	public List<Claim> getClaimList()throws ClaimException;//R All Claim -retrieve
	public boolean updateClaim(Claim Claim)throws ClaimException;//U-update
	public boolean deleteClaimById(Integer claimId)throws ClaimException;//D-delete
	public Claim getClaimById(Integer claimId)throws ClaimException;//S-search
	public List<Claim> getClaimListbyCustID(Integer custId)throws ClaimException;//R All Policies -By Cust ID
}
