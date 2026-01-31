public class Song {

    String title;
    String artist;
    int duration;// in seconds
    int playCount = 0;
    String mood;// happy, sad, chill, energy
    String lyrics;
    String language;

    // Constructor
    Song(String title, String artist, int duration, String mood, String lyrics,String language) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.mood = mood;
        this.lyrics = lyrics;
        this.language = language;
    }

    // Display song basic info (for lists)
    void display() {
        System.out.println(title + " - " + artist + " (" + mood + ")");
    }

    // Display full song details
    void displayFull() {
        System.out.println("Title    : " + title);
        System.out.println("Artist   : " + artist);
        System.out.println("Duration : " + duration + " sec");
        System.out.println("Mood     : " + mood);
        System.out.println("Lyrics   : " + lyrics);
        System.out.println("Language : " + language);
        System.out.println("--------------------------------");
    }
}
