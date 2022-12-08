package springblp.jukebox.controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import springblp.jukebox.model.Track;
import springblp.jukebox.service.TrackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TrackController {

	@Autowired
	TrackService service;
	
	/**
	 * Liste des pistes
	 * @param search : critère de recherche
	 * @return liste des pistes
	 */
	@CrossOrigin
	@GetMapping("/tracks")
	public ResponseEntity<List<Track>> getAllTrack(@RequestParam(value="search", defaultValue="") String search) {
		List<Track> listTrack;
		try {
			listTrack = service.findAll(search);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(listTrack);
	}

	/**
	 * recherche d'une piste par son id
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@GetMapping("/tracks/{id}")
	ResponseEntity<Track> getTrackById(@PathVariable(value="id") long id) {
		Optional<Track> track = service.findById(id);
		if (track.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(track.get());
	}
	
	/**
	 * creation d'une piste
	 * @param track
	 * @return
	 */
	@CrossOrigin
	@PostMapping("/tracks")
	ResponseEntity<Track> addTrack(@Valid @RequestBody Track track){
		return ResponseEntity.ok().body(service.insert(track));
	}
	
	@CrossOrigin
	@PutMapping("/tracks/{id}")
	ResponseEntity<Track> updateTrack(@PathVariable(value="id") long id, @Valid @RequestBody Track track){
		Track updatedTrack = service.update(id, track);
		if(updatedTrack == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(updatedTrack);
	}

	@CrossOrigin
	@DeleteMapping("/tracks/{id}")
	ResponseEntity<Track> deleteTrack(@PathVariable(value="id") long id){
		Optional<Track> track = service.findById(id);
		if(track.isEmpty())
			return ResponseEntity.notFound().build();
		
		service.delete(track.get().getId());
		return ResponseEntity.accepted().build();
	}
	
}
