package CarRentalManagementSystem;

public class Simulation {
    public static void main(String[] args){
        CarRentalSystem system = new CarRentalSystem();
        Car c1 = new Car(1, "Toyota", "Camry", 2022);
        Car c2 = new Car(2, "BMW", "X5", 2023);
        Car c3 = new Car(3, "Hyundai", "Elantra", 2021);
        system.addCar(c1);
        system.addCar(c2);
        system.addCar(c3);
        Customer u1 = new Customer(101, "Aydin", "AZ12345");
        Customer u2 = new Customer(102, "Nigar", "AZ67890");
        system.rentCar(c1,u1);
        system.rentCar(c2,u2);
        system.printActiveRentals();
        system.printAvailableCars();
        system.returnCar(u1);
        system.printRentalHistory();
        system.printAvailableCars();










    }
}
