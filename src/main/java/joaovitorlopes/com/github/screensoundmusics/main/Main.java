package joaovitorlopes.com.github.screensoundmusics.main;

import java.util.Scanner;

public class Main {

    private Scanner reading = new Scanner(System.in);

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

    }

    private void listMusics() {

    }

    private void searchMusicsByArtists() {

    }

    private void searchAboutArtists() {

    }

    private void registerMusics() {

    }
}
