package springblp.jukebox.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Name can't be empty")
	private String name;
	
	@ManyToMany
	@JoinTable(
			name = "playlist_track",
			joinColumns = @JoinColumn(name = "playlist_id"),
			inverseJoinColumns = @JoinColumn(name = "track_id")
			  )
	List<Track> tracks;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	
}
