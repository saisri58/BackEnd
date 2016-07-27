package com.niit;




import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.models.Product;
//import com.niit.project.Product;

public class ProductTest {

public static void main(String[] args) 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		Product product = (Product) context.getBean("product");
		product.setId("TAB_004");
		product.setName("Tablet4");
		product.setDescription("Tablet product1");
		product.setPrice(500);
		productDAO.saveOrUpdate(product);
		
		productDAO.delete("CAT_1");
		productDAO.get("CAT_1");
	
		List<Product>  list =    productDAO.list();
	
		for(Product cat : list)
		{
			System.out.println(cat.getId()  + ":" +  cat.getName()  + ":"+  cat.getDescription() +":"+ cat.getPrice());
		}
			
			
		context.close();
		
	}


}




