package springblp.jukebox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springblp.jukebox.model.Album;


public interface AlbumRepository extends JpaRepository<Album, Long>{

	List<Album> findByTitleIgnoreCaseContaining(String title) ;
	List<Album> findByArtistId(Long artistId);
}
