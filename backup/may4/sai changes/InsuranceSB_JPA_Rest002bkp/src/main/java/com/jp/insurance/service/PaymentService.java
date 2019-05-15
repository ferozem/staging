package com.jp.insurance.service;
import java.util.List;

import com.jp.insurance.entities.Payment;
import com.jp.insurance.exception.PaymentException;



/** @author Feroze **/
public interface PaymentService {
	//CRUDS Operation
	public Integer addPayment(Payment payment)throws PaymentException;//C-create
	public List<Payment> getPaymentList()throws PaymentException;//R All Payment -retrieve
	public boolean updatePayment(Payment payment)throws PaymentException;//U-update
	public boolean deletePaymentById(Integer paymentId)throws PaymentException;//D-delete
	public Payment getPaymentById(Integer paymentId)throws PaymentException;//S-search
}
