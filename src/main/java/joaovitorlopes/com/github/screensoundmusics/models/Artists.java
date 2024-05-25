package joaovitorlopes.com.github.screensoundmusics.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private TypeArtist type;

    @OneToMany(mappedBy = "artists", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musics> musics = new ArrayList<>();

    public Artists() {}

    public Artists(String artistsName, TypeArtist typeArtist) {
        this.name = artistsName;
        this.type = typeArtist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeArtist getType() {
        return type;
    }

    public void setType(TypeArtist type) {
        this.type = type;
    }

    public List<Musics> getMusics() {
        return musics;
    }

    public void setMusics(List<Musics> musics) {
        this.musics = musics;
    }

    @Override
    public String toString() {
        return  "Artist='" + name + '\'' +
                ", type=" + type +
                ", musics=" + musics;
    }
}
