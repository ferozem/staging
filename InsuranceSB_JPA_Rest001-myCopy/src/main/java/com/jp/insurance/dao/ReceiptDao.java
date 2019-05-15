package com.jp.insurance.dao;
import java.util.List;
import com.jp.insurance.entities.Receipt;
import com.jp.insurance.exception.ReceiptException;



/** @author Chandra **/
public interface ReceiptDao {
	public Integer addReceipt(Receipt receipt)throws ReceiptException;//C-create
	public List<Receipt> getReceiptList()throws ReceiptException;//R All Customer -retrieve
	public boolean updateReceipt(Receipt receipt)throws ReceiptException;//U-update
	public boolean deleteReceiptById(Integer receiptId)throws ReceiptException;//D-delete
	public Receipt getReceiptById(Integer receiptId)throws ReceiptException;//S-search
}
