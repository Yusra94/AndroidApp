package cput.ac.za.companymanager.Model;


/**
 * Created by yusraAdmin on 9/25/2015.
 */
public class Customer {

    Long customerID;
    String name;
    String surname;
    String address;
    String email;
    String contactNumber;

    public Customer() {
    }

    public Customer(String name, String surname,String contactNumber, String email, String address) {
       // this.customerID = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.contactNumber = contactNumber;
    }


    public Customer(Long customerID, String name, String surname,String contactNumber, String email, String address) {
        this.customerID = customerID;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(java.lang.String surname) {
        this.surname = surname;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public Customer getCustomer()
    {
        return this;
    }
}
