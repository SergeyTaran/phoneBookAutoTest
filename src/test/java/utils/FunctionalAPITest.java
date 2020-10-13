package utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import org.json.JSONObject;

import java.io.IOException;
import java.util.logging.Logger;

public class FunctionalAPITest {

    public final static Logger LOGGER_API = Logger.getLogger(FunctionalAPITest.class.getName());

    /**
     * for getting error/success message from body.
     * @param response
     * @return
     * @throws IOException
     */
    public static JSONObject getJsonFromResponse(HttpResponse response) throws IOException {  //
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        if (responseString.equals(""))
            return new JSONObject().put("!---Response string---", "---is empty---!");
        if (responseString.startsWith("[{"))
            return new JSONObject().put("!---Response string---", "---is Array---!");
        return new JSONObject(responseString);

    }
}
