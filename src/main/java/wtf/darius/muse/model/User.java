package wtf.darius.muse.model;

import jakarta.persistence.*;

import java.net.URL;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false, unique = true)
    private int id;

    @Column (nullable = false, unique = true)
    private String email;
    @Column (nullable = false, unique = true)
    private String userName;
    @Column (nullable = false)
    private String password;
    private String bio;

    private URL profilePicture;

    //constructors
    public User() {
    }

    public User(String email, String userName, String password, String bio, URL profilePicture) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.bio = bio;
        this.profilePicture = profilePicture;
    }
    public User(int id, String email, String userName, String password, String bio, URL profilePicture) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.bio = bio;
        this.profilePicture = profilePicture;
    }

    public User(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    //setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public URL getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(URL profilePicture) {
        this.profilePicture = profilePicture;
    }

    //equals hashCode toString


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                ", profilePicture=" + profilePicture +
                '}';
    }
}
