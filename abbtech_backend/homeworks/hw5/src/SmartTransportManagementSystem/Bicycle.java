package SmartTransportManagementSystem;

public class Bicycle implements Transport {

    private final double ratePerKm = 0.1;
    private final double speed = 15;

    @Override
    public double calculateFare(double distance) {

        return distance*ratePerKm;
    }

    @Override
    public double calculateTime(double distance) {

        return distance/speed;
    }

    @Override
    public String getTransportInfo(TransportType transport) {
        return "Transport type:" + transport + "\n" +
                "Rate per km: " + ratePerKm + "\n" +
                "Speed: " + speed + " km/h";
    }

    @Override
    public double calculateFare(double distance, int number_passengers) {

        return distance*ratePerKm*number_passengers;
    }
}
