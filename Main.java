import Customers.*;
import gasBooking.*;
import gasSupplier.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static int count;

    static int bcount = 0;
    static int ccount = 0;
    static int dcount = 0;
    static int pcount = 0;

    static String dpname;

    public static void cylinderCount(Delivery[] obj) {

        String[] months = {
            "January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
        };

        for (Delivery delivery : obj) {

            count = 0;

            System.out.println(
                "In the month of "
                + months[delivery.dt_2.getMonth()]
                + " : "
            );

            System.out.println(
                " In "
                + delivery.area
            );

            if (delivery.status.equals("D")) {

                count += delivery.numberOfCylinders;
            }

            System.out.println(
                " - "
                + count
                + " cylinders delivered"
            );
        }

        System.out.println("\n");
    }

    public static void checkLateDel(Delivery[] obj) {

    String[] months = {
        "January", "February", "March",
        "April", "May", "June",
        "July", "August", "September",
        "October", "November", "December"
    };

    int[] month = new int[12];

    for (Delivery delivery : obj) {

        if (delivery.status.equals("D")
                && delivery.amount == 783.75) {

            month[delivery.dt_2.getMonth()] += 1;

            // Example:
            // February -> getMonth() = 1
            // month[1] = month[1] + 1
        }
    }

    System.out.println("----------- Late Delivery -----------");

    for (int i = 0; i < 12; i++) {

        if (month[i] != 0) {

            System.out.println(
                "* In " + months[i]
                + " there are "
                + month[i]
                + " late deliveries"
            );
        }
    }

    System.out.println("\n");
}

public static void numOfSingleCylinders(Delivery[] obj) {

    System.out.println("-----------Single Cylinder Holders-----------");

    for (int i = 0; i < obj.length; i++) {

        if (obj[i].numberOfCylinders == 1) {

            System.out.println("* Customer Name : " + obj[i].name);

            System.out.println("* Mobile No. : " + obj[i].mobile);

            System.out.println("* Gas Connection No.: " + (i + 101));
        }
    }

    System.out.println("\n");
}

public static void DeliveryDetails(Delivery[] obj) {

    System.out.println("-----------Delivery Details-----------");

    System.out.println("Enter the name of delivery person: ");

    dpname = new Scanner(System.in).next();

    for (Delivery delivery : obj) {

        if (delivery.status.equals("D")
                && delivery.delPersonName.equals(dpname)) {

            System.out.println("* Customer Name : "
                    + delivery.name);

            System.out.println(" - "
                    + delivery.Street + ", "
                    + delivery.area + ", "
                    + delivery.pincode);
        }
    }

    System.out.println("\n");
}

public static void printReport(Delivery[] obj) {

    System.out.println("------------Delivery Report------------");

    for (int i = 0; i < obj.length; i++) {

        if (obj[i].status.equals("D")) {
            dcount++;
        }
        else if (obj[i].status.equals("B")) {
            bcount++;
        }
        else if (obj[i].status.equals("C")) {
            ccount++;
        }
        else if (obj[i].status.equals("P")) {
            pcount++;
        }
        else {
            System.out.println("Status invalid");
        }
    }

    System.out.println("* Booked");
    System.out.println(" - " + bcount + " booked");

    System.out.println("* Delivered");
    System.out.println(" - " + dcount + " delivered");

    System.out.println("* Cancelled");
    System.out.println(" - " + ccount + " cancelled");

    System.out.println("* Pending");
    System.out.println(" - " + pcount + " pending");
}

public static void printInvoice(Delivery[] obj) {

    Date d = new Date();

    SimpleDateFormat sdf =
            new SimpleDateFormat("dd/MM/yyyy");

    String invoiceDate = sdf.format(d);

    for (int i = 0; i < obj.length; i++) {

        if ("D".equals(obj[i].status)) {

            System.out.println("------------------------------------------------------------");
            System.out.println("                        INVOICE");
            System.out.println("------------------------------------------------------------");

            System.out.println(
                    "Gas Agency Code : " + GasAgency.AGENCY_CODE +
                    "\t\tDate Of Invoice : " + invoiceDate);

            System.out.println(
                    "Gas Agency Name : " + GasAgency.AGENCY_NAME +
                    "\t\tAgency Phone No. : " + GasAgency.PHONE_NUMBER );

            System.out.println(
                    "Gas Connection No. : " + (i + 101) +
                    "\t\tCustomer Name : " + obj[i].name);

            System.out.println(
                    "Booking Date : " + sdf.format(obj[i].dt_1) +
                    "\t\tCustomer Mobile No. : " + obj[i].mobile);

            System.out.println("------------------------------------------------------------");

            System.out.println("Amount : " + obj[i].amount);

            System.out.println("Refund : " + obj[i].refund);

            System.out.println(
                    "Total Amount : "
                    + (obj[i].amount - obj[i].refund));

            System.out.println("------------------------------------------------------------");

            System.out.println(
                    "Delivery Person Name : "
                    + obj[i].delPersonName
                    + "\t\tDelivery Person Mobile : "
                    + obj[i].delMobileNo);

            System.out.println(
                    "Delivery Date : "
                    + sdf.format(obj[i].dt_2));

            System.out.println("------------------------------------------------------------");
            System.out.println("\n");
        }
    }
}

    public static void main(String[] args){
        System.out.println("*************************************************");
        System.out.println("               Bharat Gas Agency                 ");
        System.out.println("*************************************************");

        // Initializing the Delivery array as seen in the video screenshot
        Delivery[] deliveryObject = new Delivery[5];
        
        deliveryObject[0] = new Delivery("Parvati", "6th Avenue", "Alpha-2", "201308", "9990033379", 1);
        deliveryObject[1] = new Delivery("Hanuman", "4th Avenue", "Gamma-2", "201308", "9885018485", 2);
        deliveryObject[2] = new Delivery("Krishna", "4th Avenue", "Alpha-2", "201308", "7858048146", 1);
        deliveryObject[3] = new Delivery("Ganga", "4th Avenue", "Alpha-2", "201308", "9765551711", 2);
        deliveryObject[4] = new Delivery("Nandi", "4th Avenue", "Pi-2", "201310", "9930137570", 1);

        // Loop to execute the business logic for each delivery object
        for (Delivery delivery : deliveryObject) {
            delivery.delPersonDetails();
            delivery.getlastDate();
            delivery.getDates();
            delivery.validate();
            delivery.amountCalc();
            delivery.verifyOtp();
            System.out.println("-------------------------------------------------");

    } 
}
}