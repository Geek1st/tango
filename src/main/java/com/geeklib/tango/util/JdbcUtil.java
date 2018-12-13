package com.geeklib.tango.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcUtil
{
	private static final String classpath = JdbcUtil.class.getResource("/").getPath();
	private static final String propertiesPath = classpath.substring(0, classpath.length() - 8) + "jdbc.properties";
	private static DriverManagerDataSource dataSource = null;
	
	static 
	{
		Properties properties = new Properties();
		InputStream inputStream = null;
		try
		{
			inputStream = new FileInputStream(new File(propertiesPath));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			properties.load(inputStream);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		dataSource = new DriverManagerDataSource("jdbc:mysql://127.0.0.1:3306/tango", "root", "root");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	}
	
	public static DriverManagerDataSource getConnection()
	{
		return dataSource;
	}
}
