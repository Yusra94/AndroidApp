package cput.ac.za.companymanager.Repositories.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import cput.ac.za.companymanager.Model.Access;
import cput.ac.za.companymanager.Repositories.RestAPIAccess;

public class RestAccessAPI implements RestAPIAccess{

    final String BASE_URL="http://companymanager-rhcloud.rhcloud.com/signin";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public boolean getUser(String username, String password)
    {
        final String url = BASE_URL+"login/"+username.toString() + "/" + password.toString();
        HttpEntity<Access> requestEntity = new HttpEntity<Access>(requestHeaders);

        try{
        ResponseEntity<Access> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Access.class);
        Access access = responseEntity.getBody();
        if (access != null)
            return false;
        else
            return true;
    }
        catch(Exception e)
        {
        return false;
        }
    }

    @Override
    public List<Access> getAll() {
        List<Access> Accesss = new ArrayList<>();
        final String url = BASE_URL+"all_Accesss/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Access[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Access[].class);
        Access[] results = responseEntity.getBody();

        for (Access Access : results) {
            Accesss.add(Access);
        }
        return Accesss;
    }
}
