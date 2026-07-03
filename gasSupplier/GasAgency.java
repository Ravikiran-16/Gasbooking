package gasSupplier;

public interface GasAgency {

     String AGENCY_NAME = "Bharat Gas";

    int AGENCY_CODE = 1234;

    long PHONE_NUMBER = 783555L;

    int PINCODE = 201310;

    default void agencyDisplay() {

        System.out.println("The agency name is: " + AGENCY_NAME);

        System.out.println("The agency code is: " + AGENCY_CODE);

        System.out.println("The agency phone number is: " + PHONE_NUMBER);

        System.out.println("The agency pincode is: " + PINCODE);
    }
}