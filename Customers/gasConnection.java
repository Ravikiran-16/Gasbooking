package Customers;

import java.text.SimpleDateFormat;
import java.util.*;

public class gasConnection extends Customer {
    
     public int numberOfCylinders;
    String date;
    
    static int connectionNumber = 100;
    
    {
        connectionNumber += 1;
    }
    
    public Date lastDate = null;
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public gasConnection(String name, String street, String area, String pincode, String mobile, int numberOfCylinders) {
        super(name, street, area, pincode, mobile);
        this.numberOfCylinders = numberOfCylinders;
    }
    
    public void getlastDate() {
        System.out.println("Enter the last Date: ");
        Scanner sc = new Scanner(System.in);
        date = sc.nextLine();
        
        try {
            lastDate = dateFormat.parse(date);//checks with date pattern - order  
        }
        catch(Exception e) {
            System.out.println("error in getlastdate: " + e);
        }
    }
}
