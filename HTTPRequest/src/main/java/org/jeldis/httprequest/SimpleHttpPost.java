/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jeldis.httprequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import static org.apache.http.HttpHeaders.USER_AGENT;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author jorge.gonzalez
 */
public class SimpleHttpPost {

    static void HttpPost() throws UnsupportedEncodingException, IOException {
        
        String url = "https://selfsolve.apple.com/wcResults.do";

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
        urlParameters.add(new BasicNameValuePair("cn", ""));
        urlParameters.add(new BasicNameValuePair("locale", ""));
        urlParameters.add(new BasicNameValuePair("caller", ""));
        urlParameters.add(new BasicNameValuePair("num", "12345"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        
        System.out.println(result.toString());
    }
    
    static void HttpGet() throws IOException
    {
        String url = "http://www.google.com/search?q=httpClient";
 
	HttpClient client = HttpClientBuilder.create().build();
	HttpGet request = new HttpGet(url);
 
	// add request header
	request.addHeader("User-Agent", USER_AGENT);
	HttpResponse response = client.execute(request);
 
	System.out.println("Response Code : " 
                + response.getStatusLine().getStatusCode());
 
	BufferedReader rd = new BufferedReader(
		new InputStreamReader(response.getEntity().getContent()));
 
	StringBuilder result = new StringBuilder();
	String line;
	while ((line = rd.readLine()) != null) {
		result.append(line);
	}
        
        System.out.println(result.toString());
    }

    public static void main(String[] args) {

        try {
           HttpPost();
            //HttpGet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
