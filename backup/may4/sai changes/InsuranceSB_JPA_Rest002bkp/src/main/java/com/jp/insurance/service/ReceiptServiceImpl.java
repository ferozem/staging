package com.jp.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.insurance.dao.ReceiptDao;
import com.jp.insurance.entities.Receipt;
import com.jp.insurance.exception.ReceiptException;



@Service
public class ReceiptServiceImpl implements ReceiptService {
	
	@Autowired
	private ReceiptDao receiptDao;
	
	@Override
	@Transactional
	public Integer addReceipt(Receipt receipt) throws ReceiptException {
		// call dao layer method and return to Client.
		return receiptDao.addReceipt(receipt);
	}

	@Override
	public List<Receipt> getReceiptList() throws ReceiptException {
		// call dao layer method and return to Client.
		System.out.println("From service");
		return receiptDao.getReceiptList();
	}

	@Override
	@Transactional
	public boolean updateReceipt(Receipt receipt) throws ReceiptException {
		// call dao layer method and return to Client.
		return receiptDao.updateReceipt(receipt);
	}

	@Override
	@Transactional
	public boolean deleteReceiptById(Integer receiptId) throws ReceiptException {
		// call dao layer method and return to Client.
		return receiptDao.deleteReceiptById(receiptId);
	}

	@Override
	public Receipt getReceiptById(Integer receiptId) throws ReceiptException {
		// call dao layer method and return to Client.
		return receiptDao.getReceiptById(receiptId);
	}

}
