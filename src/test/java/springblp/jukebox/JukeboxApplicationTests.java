package springblp.jukebox;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import springblp.jukebox.controller.AlbumController;
import springblp.jukebox.controller.ArtistController;
import springblp.jukebox.controller.PlaylistController;
import springblp.jukebox.controller.TrackController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JukeboxApplicationTests {

	@Autowired
	private ArtistController artistController;

	@Autowired
	private AlbumController albumController;

	@Autowired
	private TrackController trackController;

	@Autowired
	private PlaylistController playlistController;

	@Test
	void contextLoads() {
		assertThat(artistController).isNotNull();
		assertThat(albumController).isNotNull();
		assertThat(trackController).isNotNull();
		assertThat(playlistController).isNotNull();
	}

}
