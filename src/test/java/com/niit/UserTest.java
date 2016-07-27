
package com.niit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.models.User;

public class UserTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User user =(User)context.getBean("user");
		user.setId("12345");
		user.setName("sai");
		user.setPassword("user_p");
		user.setMobile("900000000");
		user.setMail("saisri@gmail.com");
		user.setAddress("chennai");
		userDAO.saveOrUpdate(user);

		userDAO.delete("CAT_1");
		userDAO.get("CAT_1");

		

		context.close();

	}
}
