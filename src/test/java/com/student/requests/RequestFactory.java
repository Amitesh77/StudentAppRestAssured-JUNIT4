package com.student.requests;

import java.io.IOException;
import java.util.List;

import com.Student.Pojo.StudentPojo;
import com.github.javafaker.Faker;
import com.student.tests.TestBase;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

// this class contains reuasble methods


public class RequestFactory extends TestBase{
	
	
	RestClient restClient=new RestClient();
	@Step("Getting all the student information from database")
	public Response getAllStudents()
	{
		Response response=restClient.doGetRequest("/list");
		
		return response;

	}
	@Step("Creating a new Student : {0} ,{1} , {2} ,{3} ,{4}")
	public Response createNewStudent(String url,String firstname,String lastName,String email,String programme,List<String> cources) throws IOException
	{
		
		StudentPojo body=new StudentPojo();
		
		body.setFirstName(firstname);
		body.setLastName(lastName);
		body.setEmail(email);
		body.setProgramme(programme);
		body.setCources(cources);
		
		return restClient.doPostRequest(url, body);
		
		
	}

}
