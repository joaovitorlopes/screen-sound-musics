package joaovitorlopes.com.github.screensoundmusics.models;

import jakarta.persistence.*;

@Entity
@Table(name = "musics")
public class Musics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private Artists artists;

    public Musics() {}

    public Musics(String musicName) {
        this.title = musicName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return  "Music='" + title + '\'' +
                ", artists=" + artists.getName();
    }
}
