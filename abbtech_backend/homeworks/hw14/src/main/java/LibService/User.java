package LibService;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;


        return age == user.age &&
                Objects.equals(name, user.name);
    }


    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

}

