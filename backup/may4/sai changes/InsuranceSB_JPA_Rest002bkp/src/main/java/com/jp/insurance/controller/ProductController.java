package com.jp.insurance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.insurance.entities.Product;
import com.jp.insurance.exception.ProductException;
import com.jp.insurance.service.ProductService;


//prep work
//1)@CrossOrigin
@CrossOrigin(origins = "*", allowedHeaders = "*")
//2)@RestController
@RestController
//3)@RequestMapping
@RequestMapping("/api/products")
public class ProductController {
	// @Autowired ProductService
	@Autowired
	private ProductService productService;
	
	@GetMapping(value="",produces="application/json")
	public List<Product> getProductList() throws ProductException {
		// call dao layer method and return to Client.
		System.out.println("Product list");
		return productService.getProductList();
	}

	//http://localhost:8082/api/products/1
	@GetMapping("/{productNumber}")
	public ResponseEntity<Product> getProductById(@PathVariable(value="productNumber") Integer productNumber) throws ProductException{
		Product product = productService.getProductById(productNumber);
		return ResponseEntity.ok().body(product);
	}
	
	//http://localhost:8082/api/products/save
	@PostMapping("/save")
	public HttpStatus saveProduct(@RequestBody Product product) throws ProductException{
		return productService.addProduct(product)!=null?HttpStatus.CREATED:HttpStatus.BAD_REQUEST;
	}
	//http://localhost:8082/api/products/1
	@PutMapping("/{productNumber}")
	public HttpStatus updateProduct(@PathVariable(value="productNumber") Integer productNumber,@Valid @RequestBody Product productDetails) throws ProductException{
		Product product = productService.getProductById(productNumber);
		if(product==null)
			return HttpStatus.BAD_REQUEST;
		else{
			product.setProductName(productDetails.getProductName());
			product.setProductPrice(productDetails.getProductPrice());
			product.setProductType(productDetails.getProductType());
			return productService.updateProduct(product)?HttpStatus.ACCEPTED:HttpStatus.BAD_REQUEST;
		}
	}
	
	@DeleteMapping("/{productNumber}")
	public Map<String, Boolean> deleteProductById(@PathVariable(value="productNumber")Integer productNumber) throws ProductException{
		Product product = productService.getProductById(productNumber);
		Map<String, Boolean> response = new HashMap<>();
		if(product!=null){
			productService.deleteProductById(productNumber);
			response.put("deleted", Boolean.TRUE);
		}
		return response;
	}
}
