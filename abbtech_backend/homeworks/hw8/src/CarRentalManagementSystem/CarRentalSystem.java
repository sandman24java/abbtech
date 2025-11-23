package CarRentalManagementSystem;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CarRentalSystem {
    Set<Car> all_cars = new HashSet<>();
    Set<Car> available_cars = new HashSet<>();
    Map<Customer,Car> customers = new HashMap<>();
    Map<Car,LocalDateTime> rental_times = new HashMap<>();
    Map<Car,LocalDateTime> rent_history = new HashMap<>();

    public void addCar(Car car){
        available_cars.add(car);
        all_cars.add(car);
    }
    public void rentCar(Car car,Customer customer){
        if (!available_cars.contains(car)){
            System.out.println("Car not available");
        }
        else{
            LocalDateTime start = LocalDateTime.now();
            available_cars.remove(car);
            customers.put(customer,car);
            rental_times.put(car,start);
            System.out.println(car.toString() +  " rented by " + customer.getName() +
                    "\nStart of rent: " + start);
        }
    }
    public void returnCar(Customer customer){
        if (customers.containsKey(customer)){
            available_cars.add(customers.get(customer));
            LocalDateTime end = LocalDateTime.now();
            rent_history.put(customers.get(customer),end);

            var start_time = rental_times.get(customers.get(customer));
            Duration duration = Duration.between(start_time , end);
            System.out.println(customer.getName() + " returned " + customers.get(customer)
                    + " after " + duration.toDays() + " days ( " + duration.toHours() + " hours )" );
        }
        else {
            System.out.println("Customer not found");
        }

    }
    public void printActiveRentals(){
        for (Map.Entry<Customer,Car> entry : customers.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " (rented at " + rental_times.get(entry.getValue()) + ")");
        }
    }
    public void printRentalHistory(){
        for (Map.Entry<Car,LocalDateTime> entry : rent_history.entrySet()) {
            System.out.println(entry.getKey() + " rented at " + entry.getValue() + " returned at "+ rental_times.get(entry.getKey()));
        }
    }
    public void printAvailableCars(){
        for (Car car : available_cars){
            System.out.println(car.toString() + " "+ car.getYear());
        }
    }
}
