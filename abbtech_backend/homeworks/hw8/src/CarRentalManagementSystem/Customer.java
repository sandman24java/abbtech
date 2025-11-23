package CarRentalManagementSystem;

import java.util.Objects;

public class Customer {
    private int id;
    private String name;
    private String licenseNumber;
    public Customer(int id, String name, String licenseNumber) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    public String toString() {
        return this.id + " " + this.name;
    }
    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Customer other = (Customer) o;
        return this.id == other.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
