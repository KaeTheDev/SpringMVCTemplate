package com.test.util;

public class Customer
{
    private String customerID;
    private String companyName;
    private String city;

    //No Args Constructor
    public Customer ()
    {
        customerID ="";
        companyName = "";
        city = "";
    }

    //All Args Constructor
    public Customer (String cid , String cname, String city)
    {
        customerID = cid;
        companyName = cname;
        this.city = city;
    }

    //Getter and Setters

    public String getCustomerID(){return customerID;}

    public void setCustomerID(String customerID) {this.customerID = customerID;}

    public String getCompanyName() {return companyName;}

    public void setCompanyName(String companyName) {this.companyName = companyName;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}
}
