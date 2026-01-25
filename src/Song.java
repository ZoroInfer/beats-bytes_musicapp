public class Song {

    // Original data
    String title;
    String artist;
    int duration;

    // New power-up data
    String lyrics;
    String mood;        // happy, sad, chill, energy, etc.
    String userTitle;   // renamed title by user
    int playCount;     // how many times song is played

    // Constructor for default songs
    Song(String title, String artist, int duration, String mood, String lyrics) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.mood = mood;
        this.lyrics = lyrics;
        this.userTitle = "";   // empty means no custom name
        this.playCount = 0;
    }

    // Constructor for user-created songs
    Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.mood = "custom";
        this.lyrics = "No lyrics added.";
        this.userTitle = "";
        this.playCount = 0;
    }

    // Get display title (original or renamed)
    String getDisplayTitle() {
        if (userTitle.equals("")) {
            return title;
        } else {
            return userTitle;
        }
    }

    // Rename song
    void rename(String newName) {
        userTitle = newName;
    }

    // Display song
    void display() {
        System.out.println(getDisplayTitle() + " - " + artist + " (" + duration + " sec)");
    }

    // Display full info
    void displayFull() {
        System.out.println("Title: " + getDisplayTitle());
        System.out.println("Artist: " + artist);
        System.out.println("Mood: " + mood);
        System.out.println("Duration: " + duration + " sec");
        System.out.println("Played: " + playCount + " times");
    }

    // Display lyrics
    void showLyrics() {
        System.out.println("\nLyrics of " + getDisplayTitle() + ":");
        System.out.println(lyrics);
    }
}
