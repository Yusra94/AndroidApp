package cput.ac.za.companymanager.Repositories;

import java.util.List;

import cput.ac.za.companymanager.Model.Access;

/**
 * Created by yusraAdmin on 9/25/2015.
 */
public interface RestAPIAccess {

    boolean getUser(String username, String password);
    List<Access> getAll();
}
