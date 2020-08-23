package com.student.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.student.utils.PropertyReader;

import io.restassured.RestAssured;

public class TestBase {

	public static PropertyReader prop;
	
	@Rule
	public TestRule listener=new TestWatcher() {
		
		@Override
		protected  void succeeded(Description desc)
		{
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(desc.getMethodName().toUpperCase());
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}
		
	};
	
	@BeforeClass
	public static void initURL() throws IOException
	{

		prop=PropertyReader.getInstance();
		RestAssured.baseURI=prop.getProperty("baseurl");
		RestAssured.port=Integer.valueOf(prop.getProperty("port"));
		
		
		
	}
}
