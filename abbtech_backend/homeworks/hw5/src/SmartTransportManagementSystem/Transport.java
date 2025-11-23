package SmartTransportManagementSystem;

public interface Transport {
    double calculateFare(double distance);
    double calculateTime(double distance);
    String getTransportInfo(TransportType transport);
    double calculateFare(double distance, int number_passengers);
}
