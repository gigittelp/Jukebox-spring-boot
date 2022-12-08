package springblp.jukebox.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	@NotBlank(message = "Name can't be empty")
	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	private String name;

	private String bio;

	@PositiveOrZero(message = "fan number must be positive")
	private Integer fanNumber;
	
	@OneToMany(mappedBy = "artist")
	@JsonBackReference
	private List<Album> albums;

	
	public Artist() {
		super();
	}

	public Artist(String name, String bio, Integer fanNumber) {
		super();
		this.name = name;
		this.bio = bio;
		this.fanNumber = fanNumber;
	}

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

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Integer getFanNumber() {
		return fanNumber;
	}

	public void setFanNumber(Integer fanNumber) {
		this.fanNumber = fanNumber;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	
}
