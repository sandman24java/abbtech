package CarRentalManagementSystem;

import java.util.Objects;

public class Car {
    private int id;
    private String brand;
    private String model;
    private int year;

    public Car(int id, String brand, String model, int year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return brand + " " + model;
    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Car other = (Car) o;
        return this.id == other.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

