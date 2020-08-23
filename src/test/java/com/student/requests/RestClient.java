package com.student.requests;

import java.io.IOException;

import com.student.specs.SpecificationFactory;
import com.student.tests.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClient extends TestBase{
	
	public Response doGetRequest(String requestPath)
	{
		
		return RestAssured.given()
					.when()
					.get(requestPath);
	}
	
	public Response doPostRequest(String uri,Object body) throws IOException
	{
		
		return RestAssured.given()
							.contentType(ContentType.JSON)
							.spec(SpecificationFactory.logPayloadResponsenfo())
							.when()
							.body(body)
							.post(uri);
	}

}
