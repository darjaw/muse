package wtf.darius.muse.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false, unique = true)
    private int id;

    @Column (nullable = false, unique = true)
    private String email;
    @Column (nullable = false)
    private String password;
    private String bio;

    //constructors
    public User() {
    }

    public User(String email, String password, String bio) {
        this.email = email;
        this.password = password;
        this.bio = bio;
    }

    //setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
