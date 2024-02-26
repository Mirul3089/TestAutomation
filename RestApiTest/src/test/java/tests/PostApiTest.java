package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import base.TestBase;
import client.RestClient;
import data.UsersData;

public class PostApiTest extends TestBase {

	TestBase testbase;
	String uri;
	String serviceUrl;
	String URL;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;

	public PostApiTest() throws FileNotFoundException {
		super();
	}

	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		testbase = new TestBase();
		uri = prop.getProperty("URI");
		serviceUrl = prop.getProperty("serviceURL");
		URL = uri + serviceUrl;
	}

	@Test
	public void postApiTest() throws StreamWriteException, DatabindException, IOException {
		restClient = new RestClient();

		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");

		// jackson API
		ObjectMapper mapper = new ObjectMapper(); // from JSON to java objects

		UsersData userdata = new UsersData("Mirul", "Teacher"); // expected userdata

		// object to json file
		mapper.writeValue(new File("E:\\QA\\Selenium_WorkSpace\\RestApiTest\\src\\main\\java\\data\\users.json"),
				userdata);

		// object to JSON in string
		String usersJsonString = mapper.writeValueAsString(userdata);
		System.out.println(usersJsonString);

		closeableHttpResponse = restClient.post(URL, usersJsonString, headerMap);
		Assert.assertEquals(closeableHttpResponse.getStatusLine().getStatusCode(), testbase.RESPONSE_STATUS_CODE_201);

		// 2.JsonString
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		System.out.println(responseString);

		JSONObject responseJson = new JSONObject(responseString); // converts into json string
		System.out.println("The response from API is:" + responseJson);

		UsersData userResObj = mapper.readValue(responseString, UsersData.class); // actual userdata object
		// System.out.println(userResObj);
		Assert.assertTrue(userdata.getName().equals(userResObj.getName()));
	}

}
