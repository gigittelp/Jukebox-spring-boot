package springblp.jukebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springblp.jukebox.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long>{

	List<Artist> findByNameContaining(String name);
}
