import java.util.Scanner;
import java.util.Random;

public class CabBookingChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean bookingActive = false;
        boolean otpShared = false;

        String pickup = "";
        String destination = "";
        String cabType = "";
        double distance = 0;
        double fare = 0;
        int bookingId = 0;

        while (true) {

            System.out.println("\n===== CAB BOOKING CHATBOT =====");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter 1 or 2.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                if (bookingActive) {
                    System.out.println("An active booking already exists.");
                    continue;
                }

                System.out.println("\nSelect Cab Type:");
                System.out.println("1. Auto - Rs. 12/km");
                System.out.println("2. Sedan - Rs. 18/km");
                System.out.println("3. SUV - Rs. 25/km");
                System.out.print("Enter cab choice: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid cab choice!");
                    sc.nextLine();
                    continue;
                }

                int cab = sc.nextInt();
                sc.nextLine();

                if (cab == 1) {
                    cabType = "Auto";
                } else if (cab == 2) {
                    cabType = "Sedan";
                } else if (cab == 3) {
                    cabType = "SUV";
                } else {
                    System.out.println("Invalid cab type!");
                    continue;
                }

                System.out.println("\nSelect Route:");
                System.out.println("1. Pune Station to Shivajinagar - 5 km");
                System.out.println("2. Sangamner to Kotul - 8 km");
                System.out.println("3. Hinjawadi to Wakad - 10 km");
                System.out.print("Enter route number: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid route choice!");
                    sc.nextLine();
                    continue;
                }

                int route = sc.nextInt();
                sc.nextLine();

                if (route == 1) {
                    pickup = "Pune Station";
                    destination = "Shivajinagar";
                    distance = 5;
                } else if (route == 2) {
                    pickup = "Sangamner";
                    destination = "Kotul";
                    distance = 8;
                } else if (route == 3) {
                    pickup = "Hinjawadi";
                    destination = "Wakad";
                    distance = 10;
                } else {
                    System.out.println("Invalid route!");
                    continue;
                }

                double rate;

                if (cab == 1) {
                    rate = 12;
                } else if (cab == 2) {
                    rate = 18;
                } else {
                    rate = 25;
                }

                fare = distance * rate;

                System.out.println("\n===== FARE DETAILS =====");
                System.out.println("Cab Type: " + cabType);
                System.out.println("Pickup: " + pickup);
                System.out.println("Destination: " + destination);
                System.out.println("Distance: " + distance + " km");
                System.out.println("Rate: Rs. " + rate + "/km");
                System.out.println("Total Fare: Rs. " + fare);

                System.out.println("\n1. Confirm & Share OTP");
                System.out.println("2. Cancel Ride");
                System.out.print("Enter your choice: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid choice. Booking cancelled.");
                    sc.nextLine();
                    continue;
                }

                int confirm = sc.nextInt();
                sc.nextLine();

                if (confirm == 1) {

                    int otp = 1000 + random.nextInt(9000);
                    bookingId = 1000 + random.nextInt(9000);

                    System.out.println("\nYour 4-digit OTP is: " + otp);
                    System.out.print("Enter OTP to confirm ride: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid OTP. Booking not confirmed.");
                        sc.nextLine();
                        continue;
                    }

                    int enteredOtp = sc.nextInt();
                    sc.nextLine();

                    if (enteredOtp == otp) {
                        bookingActive = true;
                        otpShared = true;

                        System.out.println("\nBooking confirmed!");
                        System.out.println("Booking ID: CAB" + bookingId);
                        System.out.println("Cab Type: " + cabType);
                        System.out.println("Pickup: " + pickup);
                        System.out.println("Destination: " + destination);
                        System.out.println("Distance: " + distance + " km");
                        System.out.println("Total Fare: Rs. " + fare);
                    } else {
                        System.out.println("Incorrect OTP. Booking not confirmed.");
                    }

                } else if (confirm == 2) {
                    System.out.println("Booking cancelled before OTP sharing.");
                } else {
                    System.out.println("Invalid choice. Booking not confirmed.");
                }

            } else if (choice == 2) {
                System.out.println("Thank you for using Cab Booking Chatbot!");
                break;

            } else {
                System.out.println("Invalid choice! Select 1 or 2.");
            }
        }

        sc.close();
    }
}
