package UserBackupSystem;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String email;
    private int age;
    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
    public String toString() {
        return username + " " + email + " " + age;
    }

}
