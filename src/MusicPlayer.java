import java.util.ArrayList;
import java.util.Scanner;

public class MusicPlayer {

    ArrayList<Song> library = new ArrayList<>();
    ArrayList<Song> playlist = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Stats
    int songsPlayed = 0;
    int quizPlayed = 0;
    int currentIndex = -1;
    int quizScore = 0;

    // ---------------- ADD SONG ----------------
    void addSong(Song s) {
        library.add(s);
    }

    // ---------------- PLAY SONG MENU ----------------
    void playSong() {
        int choice;
        do {
            System.out.println("\n--- Play Song ---");
            System.out.println("1. Show all songs");
            System.out.println("2. Show songs by mood");
            System.out.println("3. Show songs by language");
            System.out.println("4. Search a song");
            System.out.println("5. Back");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    showAndPlay();
                    break;

                case 2:
                    showByMood();
                    break;

                case 3:
                    showByLanguage();
                    break;

                case 4:
                    searchSong();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    void showAllSongsOnly() {
        System.out.println("\n--- All Songs ---");
        for (int i = 0; i < library.size(); i++) {
            System.out.print((i + 1) + ". ");
            library.get(i).display();
        }
    }

    // ---------------- SHOW ALL SONGS ----------------
    void showAndPlay() {
        System.out.println("\n--- All Songs ---");
        for (int i = 0; i < library.size(); i++) {
            System.out.print((i + 1) + ". ");
            library.get(i).display();
        }

        System.out.print("\nEnter song number to play (0 to cancel): ");
        int num = sc.nextInt();

        if (num == 0) return;

        playSongAtIndex(num - 1);
    }

    // ---------------- SELECT & PLAY ----------------
    void playSongAtIndex(int index) {

        if (index < 0 || index >= library.size()) {
            System.out.println("Invalid song.");
            return;
        }

        currentIndex = index;
        Song s = library.get(currentIndex);

        System.out.println("\nNow Playing:");
        s.displayFull();
        s.playCount++;
        songsPlayed++;
        postPlayMenu();
    }

    // ---------------- SEARCH SONG ----------------
    void searchSong() {
        sc.nextLine(); // clear buffer

        System.out.print("Enter song name to search: ");
        String key = sc.nextLine().toLowerCase();

        boolean found = false;

        System.out.println("\n--- Search Results ---");
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).title.toLowerCase().contains(key)) {
                System.out.print((i + 1) + ". ");
                library.get(i).display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching songs found.");
            return;
        }

        System.out.print("\nEnter song number to play (0 to cancel): ");
        int num = sc.nextInt();

        if (num == 0) return;

        playSongAtIndex(num - 1);
    }

    // ---------------- SHOW BY MOOD ----------------
    void showByMood() {
        System.out.print("Enter mood (happy/sad/chill/energy): ");
        String mood = sc.nextLine().toLowerCase();
        boolean found = false;

        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).mood.equalsIgnoreCase(mood)) {
                System.out.print((i + 1) + ". ");
                library.get(i).display();
                found = true;
            }
        }

        if (found) {
            System.out.print("Enter song number : ");
            int num = sc.nextInt();
            playSongAtIndex(num - 1);
        }
        else{
            System.out.println("No songs found for this mood!");
        }
    }

    // ---------------- SHOW BY LANGUAGE ----------------
    void showByLanguage() {
        System.out.print("Enter language (English/Hindi/Gujarati): ");
        String lang = sc.nextLine().toLowerCase();
        boolean found = false;

        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).language.equalsIgnoreCase(lang)) {
                System.out.print((i + 1) + ". ");
                library.get(i).display();
                found = true;
            }
        }

        if (found) {
            System.out.print("Enter song number : ");
            int num = sc.nextInt();
            playSongAtIndex(num - 1);
        }
        else{
            System.out.println("No songs found!");
        }
    }

    // ---------------- SHOW STATS ----------------
    void showStats() {

        int happy = 0, sad = 0, chill = 0, energy = 0;

        Song favSong = null;
        int maxPlay = 0;

        // Count moods & favourite song
        for (Song s : library) {
            if (s.mood.equalsIgnoreCase("happy")) happy++;
            else if (s.mood.equalsIgnoreCase("sad")) sad++;
            else if (s.mood.equalsIgnoreCase("chill")) chill++;
            else if (s.mood.equalsIgnoreCase("energy")) energy++;

            if (s.playCount > maxPlay) {
                maxPlay = s.playCount;
                favSong = s;
            }
        }

        // Favourite mood
        String favMood = "happy";
        int maxMood = happy;

        if (sad > maxMood) { maxMood = sad; favMood = "sad"; }
        if (chill > maxMood) { maxMood = chill; favMood = "chill"; }
        if (energy > maxMood) { maxMood = energy; favMood = "energy"; }

        // Favourite artist
        String favArtist = (favSong != null) ? favSong.artist : "None";

        // Favourite language (simple logic)
        int eng = 0, hin = 0, guj = 0;

        for (Song s : library) {
            if (s.language.equalsIgnoreCase("English")) eng++;
            else if (s.language.equalsIgnoreCase("Hindi")) hin++;
            else if (s.language.equalsIgnoreCase("Gujarati")) guj++;
        }

        String favLang = "English";
        if (hin > eng && hin > guj) favLang = "Hindi";
        else if (guj > eng && guj > hin) favLang = "Gujarati";

        System.out.println("\n--- Your Stats ---");
        System.out.println("Total Songs               : " + library.size());
        System.out.println("Songs Played              : " + songsPlayed);
        System.out.println("Quiz Played               : " + quizPlayed);
        System.out.println("Quiz Score                : " + quizScore);
        System.out.println("Favourite Song            : " + (favSong != null ? favSong.title : "None"));
        System.out.println("Artist of Favourite Song  : " + favArtist);
        System.out.println("Favourite Mood            : " + favMood);
        System.out.println("Favourite Language        : " + favLang);
        System.out.println("Player Title              : " + getPlayerTitle());
    }

    //POST PLAY MENU
    void postPlayMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Play next");
        System.out.println("2. Play previous");
        System.out.println("3. Play another song");
        System.out.println("4. Return to main menu");
        System.out.print("Choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                if (currentIndex + 1 < library.size()) {
                    playSongAtIndex(currentIndex + 1);
                } else {
                    System.out.println("No next song.");
                    postPlayMenu();
                }
                break;
            case 2:
                if (currentIndex - 1 >= 0) {
                    playSongAtIndex(currentIndex - 1);
                } else {
                    System.out.println("No previous song.");
                    postPlayMenu();
                }
                break;

            case 3:
                playSong();   // back to Play Song menu
                break;

            case 4:
                return;       // back to Main menu

            default:
                System.out.println("Invalid choice.");
                postPlayMenu();
        }
    }

    //SHOW PLAYLIST
    void showPlaylist() {
        int choice;

        do {
            System.out.println("\n--- Playlist ---");
            System.out.println("1. Add song to playlist");
            System.out.println("2. Show playlist");
            System.out.println("3. Play from playlist");
            System.out.println("4. Back");
            System.out.print("Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addToPlaylist();
                    break;

                case 2:
                    displayPlaylist();
                    break;

                case 3:
                    playFromPlaylist();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    //ADD PLAYLIST
    void addToPlaylist() {
        showAllSongsOnly();
        System.out.print("Enter song number to add: ");
        int num = sc.nextInt();

        if (num < 1 || num > library.size()) {
            System.out.println("Invalid song number!");
            return;
        }

        playlist.add(library.get(num - 1));
        System.out.println("Song added to playlist.");
    }

    //DISPLAY PLAYLIST
    void displayPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("\n--- Your Playlist ---");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.print((i + 1) + ". ");
            playlist.get(i).display();
        }
    }

    //PLAY PLAYLIST
    void playFromPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        displayPlaylist();
        System.out.print("Enter song number to play: ");
        int num = sc.nextInt();

        if (num < 1 || num > playlist.size()) {
            System.out.println("Invalid choice!");
            return;
        }

        Song s = playlist.get(num - 1);
        int index = library.indexOf(s);
        playSongAtIndex(index);
    }

    //PLAY QUIZ
    void playQuiz() {
        int choice;

        do {
            System.out.println("\n--- Quiz Menu ---");
            System.out.println("1. Lyrics Quiz");
            System.out.println("2. Artist Quiz");
            System.out.println("3. Back");
            System.out.print("Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    lyricsQuiz();
                    break;

                case 2:
                    artistQuiz();
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);
    }

    //LYRICS QUIZ
    void lyricsQuiz() {
        quizPlayed++;

        int correctIndex = (int) (Math.random() * library.size());
        Song correct = library.get(correctIndex);

        System.out.println("\n--- Lyrics Quiz ---");
        System.out.println("Guess the song from lyrics:");
        System.out.println(correct.lyrics);
        System.out.println();

        int optionPos = (int) (Math.random() * 4);
        int[] options = new int[4];
        options[optionPos] = correctIndex;

        for (int i = 0; i < 4; i++) {
            if (i == optionPos) continue;

            int rand;
            do {
                rand = (int) (Math.random() * library.size());
            } while (rand == correctIndex);

            options[i] = rand;
        }

        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + ". " + library.get(options[i]).title);
        }

        System.out.print("Your answer (1-4): ");
        int ans = sc.nextInt();

        if (ans - 1 == optionPos) {
            System.out.println("Correct! 🎉");
            quizScore += 10;
        } else {
            System.out.println("Wrong 😅");
            System.out.println("Correct answer: " + correct.title);
        }
    }

    //ARTIST QUIZ
    void artistQuiz() {
        quizPlayed++;

        int correctIndex = (int) (Math.random() * library.size());
        Song correct = library.get(correctIndex);

        System.out.println("\n--- Artist Quiz ---");
        System.out.println("Guess the artist of this song:");
        System.out.println(correct.title);
        System.out.println();

        int optionPos = (int) (Math.random() * 4);
        int[] options = new int[4];
        options[optionPos] = correctIndex;

        for (int i = 0; i < 4; i++) {
            if (i == optionPos) continue;

            int rand;
            do {
                rand = (int) (Math.random() * library.size());
            } while (rand == correctIndex);

            options[i] = rand;
        }

        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + ". " + library.get(options[i]).artist);
        }

        System.out.print("Your answer (1-4): ");
        int ans = sc.nextInt();

        if (ans - 1 == optionPos) {
            System.out.println("Correct! 🎉");
            quizScore += 10;
        } else {
            System.out.println("Wrong 😅");
            System.out.println("Correct answer: " + correct.artist);
        }
    }

    //WRITE SONG
    void writeYourOwnSong() {

        sc.nextLine(); // clear buffer

        System.out.println("\n--- Write Your Own Song ---");

        System.out.print("Enter song name: ");
        String title = sc.nextLine();

        System.out.print("Enter artist name: ");
        String artist = sc.nextLine();

        System.out.println("Select mood:");
        System.out.println("1. Happy");
        System.out.println("2. Sad");
        System.out.println("3. Chill");
        System.out.println("4. Energy");
        System.out.print("Choice: ");
        int moodChoice = sc.nextInt();
        sc.nextLine();

        String mood = "happy";
        if (moodChoice == 2) mood = "sad";
        else if (moodChoice == 3) mood = "chill";
        else if (moodChoice == 4) mood = "energy";

        System.out.println("Select language:");
        System.out.println("1. English");
        System.out.println("2. Hindi");
        System.out.println("3. Gujarati");
        System.out.print("Choice: ");
        int langChoice = sc.nextInt();
        sc.nextLine();

        String language = "English";
        if (langChoice == 2) language = "Hindi";
        else if (langChoice == 3) language = "Gujarati";

        System.out.print("Enter estimated duration (in seconds): ");
        int duration = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter lyrics (type END_EDIT on a new line to finish):");

        String lyrics = "";
        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("END_EDIT")) break;
            lyrics += line + "\n";
        }

        Song s = new Song(title, artist, duration, mood, lyrics, language);
        library.add(s);

        System.out.println("Your song has been added successfully!");
    }

    //PLAYER TITLE
    String getPlayerTitle() {

        if (songsPlayed >= 10 && quizScore >= 20) {
            return "Ultimate DJ 🔥";
        }
        else if (quizScore >= 20) {
            return "Music Brain 🧠";
        }
        else if (songsPlayed >= 10) {
            return "Music Lover ❤️";
        }
        else if (songsPlayed >= 5) {
            return "Music Explorer 🎶";
        }
        else {
            return "New Listener 🎧";
        }
    }
}
