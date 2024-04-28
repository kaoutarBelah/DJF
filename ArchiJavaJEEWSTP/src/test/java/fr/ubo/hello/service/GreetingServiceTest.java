package fr.ubo.hello.service;

//package fr.ubo.hello.service;

import fr.ubo.hello.bean.Greeting;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreetingServiceTest {
    @Test
    public void badGreeting() throws ClientProtocolException, IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet mockRequest = new HttpGet("http://192.168.59.1:8083/ArchiJEEWSRestTP_war/greeting");
        HttpResponse mockResponse = client.execute(mockRequest);
        // String responseContent = EntityUtils.toString(mockResponse.getEntity().Content());
        BufferedReader rd = new BufferedReader(new InputStreamReader((mockResponse.getEntity().getContent())));
        ObjectMapper mapper = new ObjectMapper();
        Greeting greeting = mapper.readValue(rd, Greeting.class);

        String name = "John"; // Define the name you want to check

        Assert.assertNotNull(greeting);
        Assert.assertFalse(greeting.getMessage().contains(name));
        Assert.assertEquals("Name est obligatoire. Merci de le renseigner.", greeting.getMessage());
    }

}

