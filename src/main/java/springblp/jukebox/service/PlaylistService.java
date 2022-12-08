package springblp.jukebox.service;

import java.util.List;
import java.util.Optional;

import springblp.jukebox.model.Playlist;


public interface PlaylistService {

	Optional<Playlist> findById(Long id);
	List<Playlist> findAll(String search);
	Playlist insert(Playlist PlayList);
	Playlist update(Long id, Playlist PlayList);
	void delete(Long id);
}
