package SmartLibrarySystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int age;
    private List<BorrowRecord> borrowRecords;
    public User(String name, int age,List<BorrowRecord> borrowRecords) {
        this.name = name;
        this.age = age;
        this.borrowRecords = borrowRecords;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public List<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }

    public String toString() {
        return "USER " + this.name + " AGE " + this.age + " RECORDS " + this.borrowRecords;
    }

}

