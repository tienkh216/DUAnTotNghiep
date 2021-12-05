package com.gymshop.serviceImpl;

import java.util.List;

import com.gymshop.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymshop.dao.ProductDAO;
import com.gymshop.entities.Product;
import com.gymshop.service.productService;

@Service
public class productServiceImpl implements productService{
	@Autowired
	ProductDAO dao;

	@Override
	public List<Product> findByCategoryId(String string) {
		// TODO Auto-generated method stub
		return dao.findProductByCategory(string);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}


	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return dao.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return dao.save(product);
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public List<Product> findTopNewProduct() {
		return dao.findTopNewProduct();
	}


	@Override
	public List<Product> findTopProductWithProductStatus(String ProductStatus) {
		return dao.findTopProductWithProductStatus(ProductStatus);
	}

	@Override
	public List<Category> getCategoryId() {
		return dao.getCategoryId();
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}



}
