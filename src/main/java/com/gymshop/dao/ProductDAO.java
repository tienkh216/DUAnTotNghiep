package com.gymshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gymshop.entities.*;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
	
	@Query(value ="select * from product join category "
			+ "on product.category_id =category.id where product.name like %" 
			+":name"
			+ "% or category.name like %"+":name"+ "%", nativeQuery =true)
	List<Product> findByName(@Param("name") String name);
	
	@Query(value ="select * "
			+ "from product join category on product.category_id ="
			+ "category.id where category.name = :name", nativeQuery =true)
	List<Product> findProductByCategory(@Param("name") String name);


	@Query(value = "select top(20) * from Products\n" +
			"order by id desc",nativeQuery =true )
	List<Product> findTopNewProduct();


	@Query(value = "SELECT TOP(20)\n" +
			" id,name,image,count,special ,price, description,category_id,product_status_id,create_date\n" +
			"FROM Products\n" +
			"where product_status_id = productStatus\n" +
			"ORDER BY create_date;",nativeQuery =true )
	List<Product> findTopProductWithProductStatus(@Param("productStatus") String productStatus);

	@Query(value = "SELECT DISTINCT category_id\n" +
			"FROM Products",nativeQuery =true )
	List<Category> getCategoryId();


}
