package com.jp.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.insurance.dao.PaymentDao;
import com.jp.insurance.entities.Payment;
import com.jp.insurance.exception.PaymentException;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentDao paymentDao;

	@Override
	@Transactional
	public Integer addPayment(Payment payment) throws PaymentException {
		// call dao layer method and return to Client.
		return paymentDao.addPayment(payment);
	}

	@Override
	public List<Payment> getPaymentList() throws PaymentException {
		// call dao layer method and return to Client.
		System.out.println("From service");
		return paymentDao.getPaymentList();
	}

	@Override
	@Transactional
	public boolean updatePayment(Payment payment) throws PaymentException {
		// call dao layer method and return to Client.
		return paymentDao.updatePayment(payment);
	}

	@Override
	@Transactional
	public boolean deletePaymentById(Integer paymentId) throws PaymentException {
		// call dao layer method and return to Client.
		return paymentDao.deletePaymentById(paymentId);
	}

	@Override
	public Payment getPaymentById(Integer paymentId) throws PaymentException {
		// call dao layer method and return to Client.
		return paymentDao.getPaymentById(paymentId);
	}

}
