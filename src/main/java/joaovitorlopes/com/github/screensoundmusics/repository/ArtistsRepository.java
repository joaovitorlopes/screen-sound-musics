package joaovitorlopes.com.github.screensoundmusics.repository;

import joaovitorlopes.com.github.screensoundmusics.models.Artists;
import joaovitorlopes.com.github.screensoundmusics.models.Musics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;

public interface ArtistsRepository extends JpaRepository<Artists, Long> {
    Optional<Artists> findByNameContainingIgnoreCase(String name);

    @Query("SELECT m FROM Artists a JOIN a.musics m WHERE a.name ILIKE %:name%")
    List<Musics> searchMusicsByArtists(String name);

}
