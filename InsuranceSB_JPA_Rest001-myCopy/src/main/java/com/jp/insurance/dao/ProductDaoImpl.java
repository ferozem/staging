package com.jp.insurance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jp.insurance.entities.Product;
import com.jp.insurance.exception.ProductException;


//prep-work 1 -@Repository ProductDaoImpl
@Repository
public class ProductDaoImpl implements ProductDao {
	//prep-work 2 - > @PersistenceContext EntityManager Object
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Integer addProduct(Product product) throws ProductException {
		entityManager.persist(product);
		return product.getProductNumber();
	}
	
	@Override
	public List<Product> getProductList() throws ProductException {
		Query query = entityManager.createQuery("from Product");
		return query.getResultList();
	}

	@Override
	public boolean updateProduct(Product product) throws ProductException {
	
		return entityManager.merge(product)!=null;
	}

	@Override
	public boolean deleteProductById(Integer productNumber) throws ProductException {
		Product product = getProductById(productNumber);
		if(product == null)
		return false;
		else{
			entityManager.remove(product);
			return true;
		}
	}

	@Override
	public Product getProductById(Integer productNumber) throws ProductException {
		
		return entityManager.find(Product.class, productNumber);
	}

}
