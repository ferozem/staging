package com.jp.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jp.insurance.entities.Receipt;
import com.jp.insurance.exception.ReceiptException;


//prep-work 1 -@Repository ReceiptDaoImpl
@Repository
public class ReceiptDaoImpl implements ReceiptDao {
	//prep-work 2 - > @PersistenceContext EntityManager Object
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Integer addReceipt(Receipt receipt) throws ReceiptException {
		entityManager.persist(receipt);
		return receipt.getReceiptId();
	}
	
	@Override
	public List<Receipt> getReceiptList() throws ReceiptException {
		Query query = entityManager.createQuery("from Receipt");
		return query.getResultList();
	}

	@Override
	public boolean updateReceipt(Receipt receipt) throws ReceiptException {
	
		return entityManager.merge(receipt)!=null;
	}

	@Override
	public boolean deleteReceiptById(Integer receiptId) throws ReceiptException {
		Receipt receipt = getReceiptById(receiptId);
		if(receipt == null)
		return false;
		else{
			entityManager.remove(receipt);
			return true;
		}
	}

	@Override
	public Receipt getReceiptById(Integer receiptId) throws ReceiptException {
		
		return entityManager.find(Receipt.class, receiptId);
	}

}
