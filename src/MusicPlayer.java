import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Collections;

public class MusicPlayer {
    int quizScore = 0;
    int gamesPlayed = 0;
    int happyCount = 0;
    int sadCount = 0;
    int chillCount = 0;
    int energyCount = 0;

    ArrayList<Song> library = new ArrayList<>();
    ArrayList<Song> playlist = new ArrayList<>();
    int currentIndex = -1;

    Scanner sc = new Scanner(System.in);

    // Add song to library
    void addSong(Song s) {
        library.add(s);
    }

    // Show all songs
    void showAllSongs() {
        System.out.println("\n--- All Songs ---");
        for (int i = 0; i < library.size(); i++) {
            System.out.print((i + 1) + ". ");
            library.get(i).display();
        }
    }

    // Play song
    void playSong(int index) {
        if (index >= 0 && index < library.size()) {
            currentIndex = index;
            Song s = library.get(index);
            s.playCount++;
            System.out.println("\nNow Playing: " + s.getDisplayTitle() + " - " + s.artist);
        } else {
            System.out.println("Invalid song number.");
        }
    }

    void next() {
        if (currentIndex + 1 < library.size()) {
            playSong(currentIndex + 1);
        } else {
            System.out.println("No next song.");
        }
    }

    void previous() {
        if (currentIndex - 1 >= 0) {
            playSong(currentIndex - 1);
        } else {
            System.out.println("No previous song.");
        }
    }

    // Search
    void searchBySongName(String name) {
        boolean found = false;
        name = name.toLowerCase();

        System.out.println("\nSearch Results:");
        for (int i = 0; i < library.size(); i++) {
            Song s = library.get(i);

            if (s.title.toLowerCase().contains(name)) {
                System.out.print((i + 1) + ". ");
                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No song found with that name.");
        }
    }

    // Playlist
    void addToPlaylist(int index) {
        if (index >= 0 && index < library.size()) {
            playlist.add(library.get(index));
            System.out.println("Added to playlist.");
        } else {
            System.out.println("Invalid song.");
        }
    }

    void showPlaylist() {
        System.out.println("\n--- Playlist ---");
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        for (int i = 0; i < playlist.size(); i++) {
            System.out.print((i + 1) + ". ");
            playlist.get(i).display();
        }
    }

    // Favourite song
    void showFavourite() {
        if (library.isEmpty()) return;

        Song fav = library.getFirst();
        for (Song s : library) {
            if (s.playCount > fav.playCount) {
                fav = s;
            }
        }

        System.out.println("\nYour Favourite Song:");
        fav.displayFull();
    }

    // Rename a song
    void renameSong(int index) {
        if (index >= 0 && index < library.size()) {
            System.out.print("Enter new name: ");
            String newName = sc.nextLine();
            library.get(index).rename(newName);
            System.out.println("Song renamed.");
        }
    }

    // Create new song
    void createSong() {
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter artist: ");
        String artist = sc.nextLine();
        System.out.print("Enter duration: ");
        int dur = sc.nextInt();
        sc.nextLine();

        Song s = new Song(title, artist, dur);
        library.add(s);
        System.out.println("Song added to library.");
    }

    // Mood filter
    void showByMood(String mood) {
        System.out.println("\nSongs with mood: " + mood);
        for (Song s : library) {
            if (s.mood.equalsIgnoreCase(mood)) {
                s.display();
            }
        }
    }

    // Show lyrics
    void showLyrics(int index) {
        if (index >= 0 && index < library.size()) {
            library.get(index).showLyrics();
        }
    }

    // Listening stats
    void showStats() {
        int total = 0;
        for (Song s : library) {
            total += s.playCount;
            if (s.mood.equalsIgnoreCase("happy")) happyCount++;
            else if (s.mood.equalsIgnoreCase("sad")) sadCount++;
            else if (s.mood.equalsIgnoreCase("chill")) chillCount++;
            else if (s.mood.equalsIgnoreCase("energy")) energyCount++;
        }
        System.out.println("\nTotal songs played: " + total);
    }

    // Game 1: Guess the song from lyrics
    void lyricsQuiz() {
        if (library.size() < 4) return;

        int correctIndex = (int) (Math.random() * library.size());
        Song correct = library.get(correctIndex);

        String[] options = new String[4];
        int correctPos = (int) (Math.random() * 4);
        options[correctPos] = correct.title;

        int filled = 0;
        for (int i = 0; i < 4; i++) {
            if (i == correctPos) continue;

            while (true) {
                int r = (int) (Math.random() * library.size());
                String title = library.get(r).title;

                boolean duplicate = false;
                for (int j = 0; j < 4; j++) {
                    if (title.equals(options[j])) {
                        duplicate = true;
                        break;
                    }
                }

                if (!duplicate) {
                    options[i] = title;
                    break;
                }
            }
        }

        System.out.println("\nGuess the song from these lyrics:");
        System.out.println(correct.lyrics);

        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        System.out.print("Your answer (1-4): ");
        int ans = sc.nextInt();
        sc.nextLine();

        if (ans - 1 == correctPos) {
            System.out.println("Correct! 🎉");
            quizScore += 10;
        } else {
            System.out.println("Wrong 😅 Correct answer: " + correct.title);
        }

        gamesPlayed++;
    }

    // Game 2: Guess the artist
    void artistQuiz() {
        if (library.size() < 4) return;

        int correctIndex = (int) (Math.random() * library.size());
        Song correct = library.get(correctIndex);

        String[] options = new String[4];
        int correctPos = (int) (Math.random() * 4);
        options[correctPos] = correct.artist;

        for (int i = 0; i < 4; i++) {
            if (i == correctPos) continue;

            while (true) {
                int r = (int) (Math.random() * library.size());
                String artist = library.get(r).artist;

                boolean duplicate = false;
                for (int j = 0; j < 4; j++) {
                    if (artist.equals(options[j])) {
                        duplicate = true;
                        break;
                    }
                }

                if (!duplicate) {
                    options[i] = artist;
                    break;
                }
            }
        }

        System.out.println("\nGuess the artist of this song:");
        System.out.println(correct.title);

        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        System.out.print("Your answer (1-4): ");
        int ans = sc.nextInt();
        sc.nextLine();

        if (ans - 1 == correctPos) {
            System.out.println("Correct! 🎉");
            quizScore += 10;
        } else {
            System.out.println("Wrong 😅 Correct answer: " + correct.artist);
        }

        gamesPlayed++;
    }

    void showLeaderboard() {
        System.out.println("\n--- Game Stats ---");
        System.out.println("Games Played: " + gamesPlayed);
        System.out.println("Total Score: " + quizScore);
    }

    String getPlayerTitle() {
        if (energyCount >= 5) return "Power Player ⚡";
        if (happyCount >= 5) return "Sunshine Soul ☀️";
        if (sadCount >= 5) return "Heart Listener 💔";
        if (chillCount >= 5) return "Chill Master 🌙";

        int total = happyCount + sadCount + chillCount + energyCount;
        if (total >= 10) return "Music Explorer 🎧";

        return "New Listener";
    }
}