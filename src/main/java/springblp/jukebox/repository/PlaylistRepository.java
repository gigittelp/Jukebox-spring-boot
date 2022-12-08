package springblp.jukebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springblp.jukebox.model.Playlist;


public interface PlaylistRepository extends JpaRepository<Playlist, Long>{

	List<Playlist> findByNameIgnoreCaseContaining(String name) ;
}
