package wtf.darius.muse.model;

import jakarta.persistence.*;

@Entity
public class Audio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String location;
    private String audioArtist;
    private String audioName;

    public int getId() {
        return id;
    }

    @ManyToOne
    private User user;
    public Audio() {
    }

    public Audio(int id, String userId, String location, String audioArtist, String audioName) {
        this.id = id;
        this.location = location;
        this.audioArtist = audioArtist;
        this.audioName = audioName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAudioArtist() {
        return audioArtist;
    }

    public void setAudioArtist(String audioArtist) {
        this.audioArtist = audioArtist;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }
}
