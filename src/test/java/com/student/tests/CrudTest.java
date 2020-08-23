package com.student.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.Student.Tags.Smoke;
import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.restassured.RestAssured;


@Story("This is a crud testing story")
public class CrudTest extends TestBase{
	
	RequestFactory requests=new RequestFactory();
	
	
	@Category(Smoke.class)
	@Story("This is a crud testing story")
	@DisplayName("This a test to get All Students")
	@Feature("This a test to get All Students")
	@Tag("Smoke")
	@Test
	public void getAllStudentd()
	{
		
		requests.getAllStudents().then().spec(SpecificationFactory.getGenericResponseSpec()).statusCode(200);
		

		
	}
	
	@Story("This is a crud testing story")
	@DisplayName("This a test to create and verify new Student")
	@Feature("This a test to create and verify new Student")
	@Test
	public void createNewStudent() throws IOException
	{
		
		Faker fake=new Faker();
		String firstName=fake.name().firstName();
		String lastName=fake.name().lastName();
		String email=fake.internet().emailAddress();
		String programme="computer Science";
		 
		List<String> cources=new ArrayList<String>();
		cources.add("Java");
		cources.add("Python");
	
		
		requests.createNewStudent("", firstName, lastName, email, programme, cources)
								
								.then().spec(SpecificationFactory.getGenericResponseSpec()).statusCode(201);
		

		
	}
	


}
