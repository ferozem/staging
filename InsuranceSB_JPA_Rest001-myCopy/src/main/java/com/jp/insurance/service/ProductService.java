package com.jp.insurance.service;
import java.util.List;

import com.jp.insurance.entities.Product;
import com.jp.insurance.exception.ProductException;



/** @author Chandra **/
public interface ProductService {
	//CRUDS Operation
	public Integer addProduct(Product product)throws ProductException;//C-create
	public List<Product> getProductList()throws ProductException;//R All Product -retrieve
	public boolean updateProduct(Product product)throws ProductException;//U-update
	public boolean deleteProductById(Integer productNumber)throws ProductException;//D-delete
	public Product getProductById(Integer productNumber)throws ProductException;//S-search
}
