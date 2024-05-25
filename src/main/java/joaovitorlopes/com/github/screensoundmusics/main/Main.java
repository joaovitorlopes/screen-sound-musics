package joaovitorlopes.com.github.screensoundmusics.main;

import joaovitorlopes.com.github.screensoundmusics.models.Artists;
import joaovitorlopes.com.github.screensoundmusics.models.Musics;
import joaovitorlopes.com.github.screensoundmusics.models.TypeArtist;
import joaovitorlopes.com.github.screensoundmusics.repository.ArtistsRepository;
import joaovitorlopes.com.github.screensoundmusics.services.SearchByChatGPT;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private final ArtistsRepository repository;
    private Scanner reading = new Scanner(System.in);

    public Main(ArtistsRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        var option = -1;

        while (option != 9) {
            var menu = """
                    *** Screen Sound Music ***
                                        
                    1- Register Artists
                    2- Register Musics
                    3- List Musics
                    4- Search Musics By Artists
                    5- Search About Artists
                                    
                    9 - Exit
                    """;

            System.out.println(menu);
            option = reading.nextInt();
            reading.nextLine();

            switch (option) {
                case 1:
                    registerArtists();
                    break;
                case 2:
                    registerMusics();
                    break;
                case 3:
                    listMusics();
                    break;
                case 4:
                    searchMusicsByArtists();
                    break;
                case 5:
                    searchAboutArtists();
                    break;
                case 9:
                    System.out.println("Exiting...!");
                    break;
                default:
                    System.out.println("Invalid Entry!");
            }
        }
    }

    private void registerArtists() {
        var registerNew = "Y";

        while(registerNew.equalsIgnoreCase("Y")) {
            System.out.println("Enter a artist(s) name(s): ");
            var artistsName = reading.nextLine();
            System.out.println("Enter a type of this artist(s): (SOLO, PAIR or BAND)");
            var type = reading.nextLine();
            TypeArtist typeArtist = TypeArtist.valueOf(type.toUpperCase());
            Artists artists = new Artists(artistsName, typeArtist);
            repository.save(artists);
            System.out.println("Register other(s) artist(s)? (Y/N)");
            registerNew = reading.nextLine();
        }
    }

    private void registerMusics() {
        System.out.println("Register music(s) which artist(s)? ");
        var name = reading.nextLine();
        Optional<Artists> artists = repository.findByNameContainingIgnoreCase(name);
        if (artists.isPresent()) {
            System.out.println("Enter a music name: ");
            var musicName = reading.nextLine();
            Musics musics = new Musics(musicName);
            musics.setArtists(artists.get());
            artists.get().getMusics().add(musics);
            repository.save(artists.get());
        } else {
            System.out.println("Artist(s) not found!");
        }
    }

    private void listMusics() {
        List<Artists> artists = repository.findAll();
        artists.forEach(a -> a.getMusics().forEach(System.out::println));
    }

    private void searchMusicsByArtists() {
        System.out.println("Enter a Artist(s) Name: ");
        var artistsName = reading.nextLine();
        List<Musics> musics = repository.searchMusicsByArtists(artistsName);
        musics.forEach(System.out::println);
    }

    private void searchAboutArtists() {
        System.out.println("Search about which Artist(s)?");
        var artistsName = reading.nextLine();
        var response = SearchByChatGPT.getInfo(artistsName);
        System.out.println(response.trim());
    }
}
