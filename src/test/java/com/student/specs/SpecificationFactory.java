package com.student.specs;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import com.student.tests.TestBase;

import io.restassured.builder.ResponseSpecBuilder;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.CoreMatchers.is;

public class SpecificationFactory extends TestBase{

	
			public static synchronized ResponseSpecification  getGenericResponseSpec()
			{
				ResponseSpecBuilder responsespec;
				ResponseSpecification responseSpecification;
				
				responsespec=new ResponseSpecBuilder();
				responsespec.expectHeader("Content-Type", "application/json;charset=UTF-8");
				responsespec.expectHeader("Transfer-Encoding", "chunked");
				//responsespec.expectResponseTime(lessThan(6L), TimeUnit.SECONDS);
				
				responseSpecification=responsespec.build();
				return responseSpecification;
			}
			
			public static synchronized RequestSpecification logPayloadResponsenfo() throws IOException
			{
				RequestSpecBuilder logbuilder;
				RequestSpecification logspecification;
				
				logbuilder=new RequestSpecBuilder();
				logspecification=logbuilder.build();
				
				
				
				if(prop.getProperty("log").equals("ENABLE"))
				{
					logbuilder.addFilter(new AllureRestAssured());
					
				}
				
				logspecification=logbuilder.build();
				
				return logspecification;
				
				
				}
}
