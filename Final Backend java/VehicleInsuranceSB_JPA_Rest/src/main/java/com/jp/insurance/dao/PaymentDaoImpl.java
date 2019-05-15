package com.jp.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jp.insurance.entities.Payment;
import com.jp.insurance.exception.PaymentException;


//prep-work 1 -@Repository PaymentDaoImpl
@Repository
public class PaymentDaoImpl implements PaymentDao {
	
	//prep-work 2 - > @PersistenceContext EntityManager Object
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Integer addPayment(Payment payment) throws PaymentException {
		entityManager.persist(payment);
		return payment.getPaymentId();
	}

	@Override
	public List<Payment> getPaymentList() throws PaymentException {
		Query query = entityManager.createQuery("from Payment");
		return query.getResultList();
	}

	@Override
	public boolean updatePayment(Payment payment) throws PaymentException {
		return entityManager.merge(payment)!=null;
	}

	@Override
	public boolean deletePaymentById(Integer paymentId) throws PaymentException {
		Payment payment = getPaymentById(paymentId);
		if(payment == null)
		return false;
		else{
			entityManager.remove(payment);
			return true;
		}
	}

	@Override
	public Payment getPaymentById(Integer paymentId) throws PaymentException {
		return entityManager.find(Payment.class, paymentId);
	}

}
