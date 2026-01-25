import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MusicPlayer player = new MusicPlayer();

        // Add default songs (20 songs)
        player.addSong(new Song("Believer", "Imagine Dragons", 204, "energy",
                "First things first I'ma say all the words inside my head"));
        player.addSong(new Song("Demons", "Imagine Dragons", 180, "sad",
                "When the days are cold and the cards all fold"));
        player.addSong(new Song("Radioactive", "Imagine Dragons", 210, "energy",
                "I'm waking up to ash and dust"));
        player.addSong(new Song("Faded", "Alan Walker", 210, "sad",
                "Where are you now"));
        player.addSong(new Song("Alone", "Alan Walker", 190, "sad",
                "Lost in your mind I wanna know"));
        player.addSong(new Song("Shape of You", "Ed Sheeran", 240, "happy",
                "I'm in love with the shape of you"));
        player.addSong(new Song("Perfect", "Ed Sheeran", 230, "happy",
                "I found a love for me"));
        player.addSong(new Song("Photograph", "Ed Sheeran", 215, "chill",
                "We keep this love in a photograph"));
        player.addSong(new Song("Closer", "Chainsmokers", 220, "chill",
                "So baby pull me closer"));
        player.addSong(new Song("Something Just Like This", "Chainsmokers", 215, "energy",
                "I want something just like this"));
        player.addSong(new Song("Let Me Love You", "DJ Snake", 200, "happy",
                "I used to believe"));
        player.addSong(new Song("Hymn For The Weekend", "Coldplay", 250, "happy",
                "Oh angel sent from up above"));
        player.addSong(new Song("Yellow", "Coldplay", 260, "chill",
                "Look at the stars"));
        player.addSong(new Song("See You Again", "Wiz Khalifa", 230, "sad",
                "It's been a long day"));
        player.addSong(new Song("Counting Stars", "OneRepublic", 250, "energy",
                "Lately I've been, I've been losing sleep"));
        player.addSong(new Song("Lose Yourself", "Eminem", 240, "energy",
                "Look, if you had one shot"));
        player.addSong(new Song("Mockingbird", "Eminem", 220, "sad",
                "I know sometimes things may not always make sense to you"));
        player.addSong(new Song("Lovely", "Billie Eilish", 200, "sad",
                "Isn't it lovely"));
        player.addSong(new Song("Bad Guy", "Billie Eilish", 190, "energy",
                "So you're a tough guy"));
        player.addSong(new Song("Levitating", "Dua Lipa", 210, "happy",
                "If you wanna run away with me"));

        while (true) {
            System.out.println();
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║             Beats & Bytes            ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1. Show All Songs                   ║");
            System.out.println("║  2. Play Song                        ║");
            System.out.println("║  3. Next Song                        ║");
            System.out.println("║  4. Previous Song                    ║");
            System.out.println("║  5. Search Song                      ║");
            System.out.println("║  6. Add to Playlist                  ║");
            System.out.println("║  7. Show Playlist                    ║");
            System.out.println("║  8. Show Favourite Song              ║");
            System.out.println("║  9. Rename a Song                    ║");
            System.out.println("║ 10. Create Your Own Song             ║");
            System.out.println("║ 11. Show Lyrics                      ║");
            System.out.println("║ 12. Show Songs by Mood               ║");
            System.out.println("║ 13. Show Listening Stats             ║");
            System.out.println("║ 14. Lyrics Quiz                      ║");
            System.out.println("║ 15. Artist Quiz                      ║");
            System.out.println("║ 16. Show Game Stats                  ║");
            System.out.println("║ 17. Show Player Title                ║");
            System.out.println("║ 18. Exit                             ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("👉 Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    player.showAllSongs();
                    pause();
                    break;

                case 2:
                    System.out.print("Enter song number: ");
                    player.playSong(sc.nextInt() - 1);
                    pause();
                    break;

                case 3:
                    player.next();
                    pause();
                    break;

                case 4:
                    player.previous();
                    pause();
                    break;

                case 5:
                    System.out.print("Enter song name: ");
                    String name = sc.nextLine();
                    player.searchBySongName(name);
                    pause();
                    break;

                case 6:
                    System.out.print("Enter song number: ");
                    player.addToPlaylist(sc.nextInt() - 1);
                    pause();
                    break;

                case 7:
                    player.showPlaylist();
                    pause();
                    break;

                case 8:
                    player.showFavourite();
                    pause();
                    break;

                case 9:
                    System.out.print("Enter song number: ");
                    player.renameSong(sc.nextInt() - 1);
                    pause();
                    break;

                case 10:
                    player.createSong();
                    pause();
                    break;

                case 11:
                    System.out.print("Enter song number: ");
                    player.showLyrics(sc.nextInt() - 1);
                    pause();
                    break;

                case 12:
                    System.out.print("Enter mood (happy, sad, chill, energy): ");
                    player.showByMood(sc.nextLine());
                    pause();
                    break;

                case 13:
                    player.showStats();
                    pause();
                    break;

                case 14:
                    player.lyricsQuiz();
                    pause();
                    break;

                case 15:
                    player.artistQuiz();
                    pause();
                    break;

                case 16:
                    player.showLeaderboard();
                    pause();
                    break;

                case 17:
                    System.out.println("\nYour Music Title: " + player.getPlayerTitle());
                    pause();
                    break;

                case 18:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }

        }
    }
    static void pause() {
        try {
            System.out.println("\nReturning to menu...");
            Thread.sleep(5000);   // 5.0 seconds delay
        } catch (Exception e) {
        }
    }
}
