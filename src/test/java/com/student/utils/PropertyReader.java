package com.student.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	private static volatile PropertyReader propinstance;
	
	private PropertyReader()
	{
		
	}
	
	public static synchronized PropertyReader getInstance()
	{
		if(propinstance==null)
		{
			propinstance=new PropertyReader();
		}
		return propinstance;
	}
	
	public String getProperty(String propertyname) throws IOException
	{
		Properties prop=new Properties();
		
		try
		{
			
		
			InputStream inputstream=getClass().getClassLoader()
					.getResourceAsStream("application.properties");
		
			prop.load(inputstream);
		
			if(prop.getProperty(propertyname)!=null)
			{
				return prop.getProperty(propertyname);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("property not found");
		}
		
		return null;
		
	}
}
