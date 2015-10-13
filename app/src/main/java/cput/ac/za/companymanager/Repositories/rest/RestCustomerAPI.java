package cput.ac.za.companymanager.Repositories.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import cput.ac.za.companymanager.Model.Customer;
import cput.ac.za.companymanager.Repositories.RestAPI;

/**
 * Created by yusraAdmin on 9/25/2015.
 */
public class RestCustomerAPI implements RestAPI<Customer,Long>{

    final String BASE_URL="http://companymanager-dumac.rhcloud.com/customers/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();

    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Customer get(Long id) {
        final String url = BASE_URL+"customer/"+id.toString();
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(requestHeaders);
        ResponseEntity<Customer> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Customer.class);
        Customer Customer = responseEntity.getBody();
        return Customer;
    }

    @Override
    public String post(Customer entity) {
        final String url = BASE_URL+"create/";
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Customer entity) {
        final String url = BASE_URL+"update/"+entity.getCustomerID().toString();
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Customer entity) {
        final String url = BASE_URL+"customer/delete/"+entity.getCustomerID().toString();
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customersList = new ArrayList<>();
        final String url = BASE_URL+"all/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Customer[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Customer[].class);
        Customer[] results = responseEntity.getBody();

        for (Customer customer : results) {
            customersList.add(customer);
        }
        return customersList;
    }
}
