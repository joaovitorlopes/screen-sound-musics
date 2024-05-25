package joaovitorlopes.com.github.screensoundmusics.repository;

import joaovitorlopes.com.github.screensoundmusics.models.Artists;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistsRepository extends JpaRepository<Artists, Long> {
    Optional<Artists> findByNameContainingIgnoreCase(String name);
}
