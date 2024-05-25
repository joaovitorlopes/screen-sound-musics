package joaovitorlopes.com.github.screensoundmusics;

import joaovitorlopes.com.github.screensoundmusics.repository.ArtistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import joaovitorlopes.com.github.screensoundmusics.main.Main;

@SpringBootApplication
public class ScreensoundmusicsApplication implements CommandLineRunner {
	@Autowired
	private ArtistsRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScreensoundmusicsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(repository);
		main.showMenu();
	}
}
