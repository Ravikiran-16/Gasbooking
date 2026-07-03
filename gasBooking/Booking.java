package gasBooking;

import Customers.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public class Booking extends gasConnection {
    
    public double otp = 5678, amount = 825.0, refund = 0;
    
    public String dt, delDate, status, delMobileNo = "7658045540";
    
    public Date dt_1,dt_2;
    
    public Booking(String name, String street, String area, String pincode, String mobile, int numberOfCylinders) {
        super(name, street, area, pincode, mobile, numberOfCylinders);
    }
    
    public void getDates() {
        System.out.println("Enter booking date: ");
        Scanner sc = new Scanner(System.in);
        dt = sc.nextLine();
        dt_1 = null;
        dt_2 = null;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            dt_1 = dateFormat.parse(dt);
        } catch (Exception e) {
            System.out.println("The error in getDates function: " + e);
        }

        // Ask user to enter delivery date
System.out.println("Enter Delivery Date : ");

// Read delivery date as String
delDate = new Scanner(System.in).nextLine();

try {
    // Convert entered String into Date object
    dt_2 = dateFormat.parse(delDate);
}
catch (Exception exp) {
    // Handle invalid date format
    System.out.println("Error parsing date dt_2: " + exp);
}

// Find difference between booking date and delivery date
try {

    // Difference in milliseconds
    long difference = dt_2.getTime() - dt_1.getTime();

    // Convert milliseconds into days
    long newDifference =
            TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);

    // If delivery date is more than 7 days after booking date
    if (newDifference > 7) {
        status = "P";   // Pending
    }

}
catch (Exception exp) {
    System.out.println("Error: " + exp);
}
    }

    public void validate() {

    // Calculate difference between current booking date
    // and previous booking date

    long elapsedms = dt_1.getTime() - lastDate.getTime();

    // Convert milliseconds to days
    long diff =
            TimeUnit.DAYS.convert(elapsedms, TimeUnit.MILLISECONDS);

    System.out.println("Difference between two dates is : " + diff);

    // If customer wants 1 cylinder
    if (numberOfCylinders == 1) {

        // Must wait at least 30 days
        if (diff < 30) {

            System.out.println("Booking cannot be done");

            status = "C";   // Cancelled
        }
        else {

            status = "B";   // Booked

            // Update last booking date
            lastDate = dt_1;
        }
    }

    // If customer wants 2 cylinders
    else if (numberOfCylinders == 2) {

        // Must wait at least 50 days
        if (diff < 50) {

            System.out.println("Booking cannot be done");

            status = "C";   // Cancelled
        }
        else {

            status = "B";   // Booked

            // Update last booking date
            lastDate = dt_1;
        }
    }
}
}