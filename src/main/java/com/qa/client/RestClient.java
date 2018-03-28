package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	
	//Get Method:
	public void get(String url) throws ClientProtocolException, IOException{
	 CloseableHttpClient httpClient =	HttpClients.createDefault();
	 HttpGet httpget = new HttpGet(url);  // this method will connect with the url   //http Request
	CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget);//hit the  Get URL
	
	//a. Status code
    int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
    System.out.println("StatusCode---> " + statuscode);
    
    //b.JSON String
    String responseString =  EntityUtils.toString(closeableHttpResponse.getEntity(),"UFT-8");
    
    JSONObject responseJson = new JSONObject(responseString);
    System.out.println("ResponseJson----> " + responseJson);
    
    //c.ALLHeaders
  Header [] headersArray =  closeableHttpResponse.getAllHeaders();
  
  HashMap<String,String> allHeaders = new HashMap<String,String>();
  for(Header header:headersArray){
	  allHeaders.put(header.getName(), header.getValue());
  }
  System.out.println("All Headers-->"+allHeaders);
		
		
		
	}
	

}
