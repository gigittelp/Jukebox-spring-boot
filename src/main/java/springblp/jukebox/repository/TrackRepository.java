package springblp.jukebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springblp.jukebox.model.Track;


public interface TrackRepository extends JpaRepository<Track, Long>{

	List<Track> findByTitleIgnoreCaseContaining(String title) ;
}
