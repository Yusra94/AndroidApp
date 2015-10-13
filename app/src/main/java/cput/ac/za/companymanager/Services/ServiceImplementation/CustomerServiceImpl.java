package cput.ac.za.companymanager.Services.ServiceImplementation;

import java.util.List;

import cput.ac.za.companymanager.Model.Customer;
import cput.ac.za.companymanager.Repositories.RestAPI;
import cput.ac.za.companymanager.Repositories.rest.RestCustomerAPI;
import cput.ac.za.companymanager.Services.CustomerService;

/**
 * Created by yusraAdmin on 9/25/2015.
 */

public class CustomerServiceImpl implements CustomerService {

    final RestAPI<Customer,Long> rest = new RestCustomerAPI();

    @Override
    public Customer findById(Long id){return rest.get(id);}

    @Override
    public String save(Customer entity){ return rest.post(entity);}

    @Override
    public String update(Customer entity){return rest.put(entity);}

    @Override
    public String delete(Customer entity){ return rest.delete(entity);}

    @Override
    public List<Customer> findAll(){return rest.getAll();}
}
