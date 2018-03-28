package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GETAPITest extends TestBase {
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String Url;
	RestClient restClient;
	
	
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException{
		testBase = new TestBase();
		 serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("ServiceURL");
		
		
         Url = serviceUrl+apiUrl;
		
	}
	@Test
	public void getAPITest() throws ClientProtocolException, IOException{
		 restClient =  new RestClient();
		restClient.get(Url);
		
	
	}
	
	
	
	
	
	
	
	
	

}
