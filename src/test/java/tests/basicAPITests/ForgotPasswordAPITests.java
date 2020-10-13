package tests.basicAPITests;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.FunctionalAPITest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PortUnreachableException;
import java.net.URL;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static utils.Constants.*;

public class ForgotPasswordAPITests extends FunctionalAPITest {

    CloseableHttpClient client;

    public ForgotPasswordAPITests() throws IOException {
    }


    HttpPost postRequest;
    URL object = new URL(passForgotAPIUrl);
    HttpResponse response;
    HttpGet getRequest;
    HttpDelete deleteRequest;
    HttpURLConnection connection = (HttpURLConnection) object.openConnection();
    HttpPut putRequest;


    String token = "be25cc22-b25c-4541-8755-13fe6e60ca13";


    @Before
    public void init() {
        client = HttpClientBuilder.create().build();
        postRequest = new HttpPost(passForgotAPIUrl);
        postRequest.addHeader("Content-Type", "application/json");
    }

    @After
    public void afterTest() throws IOException {
        client.close();
        System.out.println("client closed");
    }

    @Test
    public void testRetrievePasswordExistedUser() throws IOException {
        String json = "{\"email\":\"" + userExisted + "\"}";
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(200, response.getStatusLine().getStatusCode());
    }

    @Test
    public void testRetrievePasswordSetNewPass() throws IOException {
        putRequest = new HttpPut(passRenewAPIUrl);
        putRequest.addHeader("Content-Type", "application/json");
        String json = "{\"password\":\"" + passwordExisted + "\"" + "," + "\"token\":\"" + token + "\"}";
        putRequest.setEntity(new StringEntity(json));
        response = client.execute(putRequest);
        JSONObject jsonObject = getJsonFromResponse(response);
        LOGGER_API.info(jsonObject.toString());
        try {
            assertEquals(200, response.getStatusLine().getStatusCode());
        }catch (AssertionError tokenError){
            LOGGER_API.info("token not found");
            assertEquals("Your link is not active anymore", jsonObject.getString("message"));
            fail();
        }

        assertEquals(200, response.getStatusLine().getStatusCode());
    }

    @Test
    public void testRetrievePasswordSetNewPassTokenNotExist() throws IOException {
        putRequest = new HttpPut(passRenewAPIUrl);
        putRequest.addHeader("Content-Type", "application/json");
        String json = "{\"password\":\"" + passwordExisted + "\"" + "," + "\"token\":\"" + token + "\"}";
        putRequest.setEntity(new StringEntity(json));
        response = client.execute(putRequest);

        assertEquals(400, response.getStatusLine().getStatusCode());
        JSONObject jsonObject = getJsonFromResponse(response);
        assertEquals("Your link is not active anymore", jsonObject.getString("message"));
        LOGGER_API.info(jsonObject.toString());
    }

    @Test
    public void testRetrievePasswordInvalidUser() throws IOException {
        String json = "{\"email\":\"" + newRandomUser + "\"}";
        postRequest.setEntity(new StringEntity(json));
        response = client.execute(postRequest);
        System.out.println(response);

        assertEquals(500, response.getStatusLine().getStatusCode());
        JSONObject jsonObject = getJsonFromResponse(response);
        assertEquals("Error! This user doesn't exist in our DB", jsonObject.getString("message"));


    }


}
