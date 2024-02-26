package client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import base.TestBase;

public class RestClient extends TestBase {

	public RestClient() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	// GET method
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpGet httpget = new HttpGet(url); // http GET Request
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget); // hit the GET URL

		return closeableHttpResponse;

	}

	// method overloading
	// GET method with headers
	public CloseableHttpResponse get(String url, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpGet httpget = new HttpGet(url); // http GET Request
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget); // hit the GET URL

		return closeableHttpResponse;

	}

	// 3. POST method
	public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url); // for post request

		httppost.setEntity(new StringEntity(entityString)); // for payload or body

		// for headers
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httppost.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httppost);
		return closeableHttpResponse;
	}
}