package SmartTransportManagementSystem;

import java.util.Scanner;

public class TransportManager {
    static Transport getTransport(TransportType transport_type) {
        switch (transport_type) {
            case BUS:
                return new Bus();
            case TAXI:
                return new Taxi();
            case BICYCLE:
                return new Bicycle();
            case SCOOTER:
                return new Scooter();
            default:
                System.out.println("Invalid transport type");
                return null;
        }
    }


    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the type of transport:");
        String userInput = input.nextLine().toUpperCase();
        TransportType transport_type = TransportType.valueOf(userInput);
        System.out.println("Enter the distance(km):");
        double distance = input.nextDouble();
        System.out.println("Enter the number of passengers:");
        int number_passengers = input.nextInt();

        Transport transport = TransportManager.getTransport(transport_type);
        System.out.println("Transport details:\n" + transport.getTransportInfo(transport_type));
        System.out.println("Fare for " + number_passengers + " passenger(s):" +
                transport.calculateFare(distance, number_passengers));
        System.out.println("Estimated time: "  +
                transport.calculateTime(distance)*60 + " minutes");









    }
}
