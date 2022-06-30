package wtf.darius.muse.model;

import jakarta.persistence.*;

import java.net.URL;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;

    @Column (nullable = false, unique = true)
    private String userName;
    @Column
    private String bio;
    @Column
    private URL profilePicture;
    @Column
    private URL youtubeLink;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    public Profile() {
    }

    public Profile(String userName, String bio, URL profilePicture, URL youtubeLink) {
        this.userName = userName;
        this.bio = bio;
        this.profilePicture = profilePicture;
        this.youtubeLink = youtubeLink;
    }

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

    public URL getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(URL youtubeLink) {
        this.youtubeLink = youtubeLink;
    }
}
