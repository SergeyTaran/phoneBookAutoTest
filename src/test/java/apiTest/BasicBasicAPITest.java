package apiTest;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import uiTest.utils.FunctionalTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BasicBasicAPITest extends FunctionalTest {

    private HttpPost postRequest;
    private HttpPut putRequest;
    private HttpGet getRequest;
    private HttpDelete deleteRequest;

    private HttpResponse response;
    private CloseableHttpClient client = HttpClientBuilder.create().build();

    private String userEmail = "";
    private String userPassword = "";
    private final String TOKEN = "";

    private String baseUrl = "";

    @Before
    public void init() {
    }
}
