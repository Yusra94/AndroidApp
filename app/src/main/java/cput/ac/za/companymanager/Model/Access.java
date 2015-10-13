package cput.ac.za.companymanager.Model;

/**
 * Created by yusraAdmin on 9/25/2015.
 */
public class Access {

    String username;
    String password;

    public Access(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
