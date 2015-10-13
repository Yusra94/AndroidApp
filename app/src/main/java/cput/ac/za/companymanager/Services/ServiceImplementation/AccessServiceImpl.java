package cput.ac.za.companymanager.Services.ServiceImplementation;

import cput.ac.za.companymanager.Model.Access;
import cput.ac.za.companymanager.Repositories.RestAPIAccess;
import cput.ac.za.companymanager.Repositories.rest.RestAccessAPI;
import cput.ac.za.companymanager.Services.AccessService;

/**
 * Created by yusraAdmin on 9/25/2015.
 */
public class AccessServiceImpl implements AccessService {

    final RestAPIAccess rest = new RestAccessAPI();

    @Override
    public boolean userLogIn(String username, String password){

        return rest.getUser(username, password);

    }
}
