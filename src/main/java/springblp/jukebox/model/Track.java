package springblp.jukebox.model;

import java.util.List;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
	uniqueConstraints=@UniqueConstraint(name = "uc_title", columnNames={"title", "album_id"})
	)
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Title can't be empty")
	private String title;

	private int duration;
	
	private String preview;
	
	@ManyToOne @JoinColumn(name="album_id")
	@JsonBackReference
	private Album album;
	
	@ManyToMany(mappedBy = "tracks")
	@JsonIgnore
	private List<Playlist> playlists;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	
}
