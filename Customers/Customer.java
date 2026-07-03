package Customers;

import gasSupplier.GasAgency;

public class Customer {
    // Attributes
    public String name;
    public String Street;
    public String area;
    public String pincode;
    public String mobile;

    // Constructor
    public Customer(String name, String street, String area, String pincode, String mobile) {
        this.name = name;
        this.Street = street;
        this.area = area;
        this.pincode = pincode;
        this.mobile = mobile;
    }
}