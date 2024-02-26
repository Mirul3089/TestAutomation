package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import client.RestClient;
import utils.TestUtil;

public class GetApiTest extends TestBase {

	TestBase testbase;
	String uri;
	String serviceUrl;
	String URL;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;

	public GetApiTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		testbase = new TestBase();

		uri = prop.getProperty("URI");
		serviceUrl = prop.getProperty("serviceURL");

		URL = uri + serviceUrl;

	}

	@Test
	public void getAPITest() throws ClientProtocolException, IOException {

		restClient = new RestClient();
		closeableHttpResponse = restClient.get(URL);

		// a. status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);

		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "staus code is not 200");

		// b. Json String
		String resposeString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

		JSONObject responseJson = new JSONObject(resposeString);
		System.out.println("Response JSON from API" + responseJson);

		String perPageValue = TestUtil.getValueByJPath(responseJson, "/per_page");
		System.out.println(perPageValue);

		Assert.assertEquals(Integer.parseInt(perPageValue), 6);

		String totalValue = TestUtil.getValueByJPath(responseJson, "/total");
		System.out.println(totalValue);

		Assert.assertEquals(Integer.parseInt(totalValue), 12);

		// get the value from JSON ARRAY
		String lastName = TestUtil.getValueByJPath(responseJson, "/data[0]/last_name");

		// c. All headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println(allHeaders);

	}

	@Test
	public void getAPITestwithHeaders() throws ClientProtocolException, IOException {

		restClient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-type", "application/json");
		// headerMap.put("username", "nsbhdhdb");

		closeableHttpResponse = restClient.get(URL, headerMap);

		// a. status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode);

		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "staus code is not 200");

		// b. Json String
		String resposeString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

		JSONObject responseJson = new JSONObject(resposeString);
		System.out.println("Response JSON from API" + responseJson);

		String perPageValue = TestUtil.getValueByJPath(responseJson, "/per_page");
		System.out.println(perPageValue);

		Assert.assertEquals(Integer.parseInt(perPageValue), 6);

		String totalValue = TestUtil.getValueByJPath(responseJson, "/total");
		System.out.println(totalValue);

		Assert.assertEquals(Integer.parseInt(totalValue), 12);

		// get the value from JSON ARRAY
		String lastName = TestUtil.getValueByJPath(responseJson, "/data[0]/last_name");

		// c. All headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println(allHeaders);

	}
}
