package com.jp.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.insurance.dao.ProductDao;
import com.jp.insurance.entities.Product;
import com.jp.insurance.exception.ProductException;



@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	@Transactional
	public Integer addProduct(Product product) throws ProductException {
		// call dao layer method and return to Client.
		return productDao.addProduct(product);
	}

	@Override
	public List<Product> getProductList() throws ProductException {
		// call dao layer method and return to Client.
		System.out.println("From service");
		return productDao.getProductList();
	}

	@Override
	@Transactional
	public boolean updateProduct(Product product) throws ProductException {
		// call dao layer method and return to Client.
		return productDao.updateProduct(product);
	}

	@Override
	@Transactional
	public boolean deleteProductById(Integer productNumber) throws ProductException {
		// call dao layer method and return to Client.
		return productDao.deleteProductById(productNumber);
	}

	@Override
	public Product getProductById(Integer productNumber) throws ProductException {
		// call dao layer method and return to Client.
		return productDao.getProductById(productNumber);
	}

}
