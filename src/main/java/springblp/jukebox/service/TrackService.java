package springblp.jukebox.service;

import java.util.List;
import java.util.Optional;

import springblp.jukebox.model.Track;


public interface TrackService {

	Optional<Track> findById(Long id);
	List<Track> findAll(String search);
	Track insert(Track track);
	Track update(Long id, Track track);
	void delete(Long id);
}
