package springblp.jukebox.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springblp.jukebox.common.AppException;
import springblp.jukebox.model.Track;
import springblp.jukebox.repository.TrackRepository;


@Service
public class TrackServiceImpl implements TrackService {

	@Autowired
	private TrackRepository repository;
	
	@Override
	public List<Track> findAll(String search) {
		if (! "".equals(search))
			return repository.findByTitleIgnoreCaseContaining(search);
		else
			return repository.findAll();
	}
	
	@Override
	public Optional<Track> findById (Long id) {
		return repository.findById(id);
	}
	
	@Override
	public Track insert(Track track) {
		return repository.save(track);
	}
	
	@Override
	public Track update(Long id, Track track) {
		Optional<Track> optionalTrack = this.findById(id);
		if(optionalTrack.isPresent()) {
			return repository.save(track);
		}
		return null;
	}
	
	@Override
	public void delete(Long id) {
		Optional<Track> track = this.findById(id);
		if (track.isPresent()) {
			
			// verification que le track n'est pas dans une playlist
			if (!track.get().getPlaylists().isEmpty())
				throw new AppException("Invalid Delete, track in use", "Track in playlist");
			repository.delete(track.get());
		}
	}

}
