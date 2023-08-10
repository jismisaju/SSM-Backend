package com.infy.ssm.controller;

import java.util.ArrayList;

import java.util.List;

import com.infy.ssm.model.Product;
import com.infy.ssm.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CRUDController {
	
	@Autowired
	private CRUDService crudService;
	
	//@RequestMapping(path = "/getproductlist", method = RequestMethod.GET)
	@GetMapping("/getproductlist")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> fetchProductList(){
		List<Product> productsList=new ArrayList<Product>();
		//logic to fetch list from db
		productsList=crudService.fetchProductsList();
		return productsList;
	}
	//also acts as update method(if product with same id is provided it just 
	//gets updated)
	@PostMapping("/addproduct")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product addProduct(@RequestBody Product product){
		return crudService.addProductToDb(product);
	}
	//path parameter passed - id will be path parameter, 
	//read id from url and fetch the product using that
	@GetMapping("/getproductbyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product fetchProductById(@PathVariable int id){
		return crudService.fetchProductById(id).get();
	}
	@DeleteMapping("/deleteproductbyid/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String deleteProductById(@PathVariable int id){
		return crudService.deleteProductById(id);
	}
	
}
