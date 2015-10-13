package cput.ac.za.companymanager.Repositories.rest;

/**
 * Created by yusraAdmin on 9/25/2015.
 */

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestMethods {

    public static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // Add the Gson message converter
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return restTemplate;
    }

    public static HttpHeaders getHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;
    }
}
