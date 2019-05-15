package com.jp.insurance.dao;
import java.util.List;

import com.jp.insurance.entities.Claim;
import com.jp.insurance.entities.Customer;
import com.jp.insurance.entities.Policy;
import com.jp.insurance.exception.ClaimException;
import com.jp.insurance.exception.CustomerException;
import com.jp.insurance.exception.PolicyException;



/** @author Smita **/
public interface ClaimDao {
	public Integer addClaim(Claim claim)throws ClaimException;//C-create
	public List<Claim> getClaimList()throws ClaimException;//R All Customer -retrieve
	public boolean updateClaim(Claim claim)throws ClaimException;//U-update
	public boolean deleteClaimById(Integer claimId)throws ClaimException;//D-delete
	public Claim getClaimById(Integer claimId)throws ClaimException;//S-search
	public List<Claim> getClaimListbyCustID(Integer custId)throws ClaimException;//R All Policies -By Cust ID
}
