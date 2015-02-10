package br.com.caelum.payfast.client;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class WebClient {
	private final String url;
	private final HttpClient cliente = HttpClientBuilder.create().build();
	private final HttpGet httpGet;
	
	public WebClient(String url) {
		this.url = url;
		this.httpGet = new HttpGet(url);
	}
	
	public HttpResponse doGet() throws ClientProtocolException, IOException { 
		return cliente.execute(httpGet);
	}
}