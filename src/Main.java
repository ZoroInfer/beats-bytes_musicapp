import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        Scanner sc = new Scanner(System.in);

        // English Songs
        player.addSong(new Song("Shape of You", "Ed Sheeran", 233, "happy", "I'm in love with the shape of you...", "English"));
        player.addSong(new Song("Blinding Lights", "The Weeknd", 200, "energy", "I'm blinded by the lights...", "English"));
        player.addSong(new Song("Perfect", "Ed Sheeran", 263, "chill", "I found a love for me...", "English"));
        player.addSong(new Song("Stay", "Justin Bieber", 141, "happy", "I get drunk, wake up, I'm wasted still...", "English"));
        player.addSong(new Song("Levitating", "Dua Lipa", 203, "happy", "I got you, moonlight, you're my starlight...", "English"));
        player.addSong(new Song("Flowers", "Miley Cyrus", 200, "energy", "I can buy myself flowers...", "English"));
        player.addSong(new Song("Believer", "Imagine Dragons", 204, "energy", "First things first, I'ma say all the words...", "English"));
        player.addSong(new Song("As It Was", "Harry Styles", 167, "chill", "In this world, it's just us...", "English"));
        player.addSong(new Song("Bohemian Rhapsody", "Queen", 354, "chill", "Is this the real life? Is this just fantasy?", "English"));
        player.addSong(new Song("Memories", "Maroon 5", 189, "sad", "Here's to the ones that we got...", "English"));
        player.addSong(new Song("Someone You Loved", "Lewis Capaldi", 182, "sad", "I'm going under and this time I fear...", "English"));
        player.addSong(new Song("Watermelon Sugar", "Harry Styles", 174, "happy", "Tastes like a summer evening...", "English"));
        player.addSong(new Song("Closer", "The Chainsmokers", 244, "energy", "So baby pull me closer in the backseat...", "English"));
        player.addSong(new Song("Bad Guy", "Billie Eilish", 194, "chill", "I'm that bad type, make your mama sad type...", "English"));
        player.addSong(new Song("Counting Stars", "OneRepublic", 257, "happy", "Lately I've been, I've been losing sleep...", "English"));

// Hindi Songs
        player.addSong(new Song("Tum Hi Ho", "Arijit Singh", 262, "sad", "Hum tere bin ab reh nahi sakte...", "Hindi"));
        player.addSong(new Song("Apna Bana Le", "Arijit Singh", 264, "chill", "Tu mera koi na hoke bhi kuch lage...", "Hindi"));
        player.addSong(new Song("Kesariya", "Arijit Singh", 268, "happy", "Kesariya tera ishq hai piya...", "Hindi"));
        player.addSong(new Song("Chaleya", "Anirudh Ravichander", 200, "happy", "Teri baaton mein aisa uljha jiya...", "Hindi"));
        player.addSong(new Song("Sajni", "Arijit Singh", 170, "chill", "Sajni re... tere bin jiya jaye na...", "Hindi"));
        player.addSong(new Song("Raataan Lambiyan", "Jubin Nautiyal", 230, "chill", "Kaatan kaise raataan o saawre...", "Hindi"));
        player.addSong(new Song("Pehle Bhi Main", "Vishal Mishra", 225, "sad", "Pehle bhi main... tumse mila hoon...", "Hindi"));
        player.addSong(new Song("Zindagi Ke Safar", "Kishore Kumar", 398, "chill", "Zindagi ke safar mein guzar jaate hain...", "Hindi"));
        player.addSong(new Song("Chura Liya Hai", "Asha Bhosle", 288, "chill", "Chura liya hai tumne jo dil ko...", "Hindi"));
        player.addSong(new Song("Agar Tum Saath Ho", "Alka Yagnik", 341, "sad", "Behti rehti... nehar nadiya si...", "Hindi"));
        player.addSong(new Song("Kabira", "Tochi Raina", 223, "chill", "Banno re banno meri chali sasural ko...", "Hindi"));
        player.addSong(new Song("Heeriye", "Jasleen Royal", 194, "happy", "Heeriye... sehra bandh ke aaunga...", "Hindi"));
        player.addSong(new Song("Jeene Laga Hoon", "Atif Aslam", 237, "happy", "Jeene laga hoon pehle se zyada...", "Hindi"));
        player.addSong(new Song("Chaiyya Chaiyya", "Sukhwinder Singh", 414, "energy", "Jinke sar ho ishq ki chaanv...", "Hindi"));
        player.addSong(new Song("Bekhayali", "Sachet Tandon", 371, "sad", "Bekhayali mein bhi tera hi khayal aaye...", "Hindi"));

// Gujarati Songs
        player.addSong(new Song("Khalasi", "Aditya Gadhvi", 208, "energy", "Gotu ne gotu hu to dariyo re...", "Gujarati"));
        player.addSong(new Song("Radha Ne Kaan", "Aditya Gadhvi", 245, "happy", "Radha ne kaan kare vaat...", "Gujarati"));
        player.addSong(new Song("Odhani", "Darshan Raval", 185, "happy", "Odhani odhu ne udi jaye...", "Gujarati"));
        player.addSong(new Song("Chandaliyo Ugyo", "Aishwarya Majmudar", 192, "chill", "Chandaliyo ugyo re dev na dware...", "Gujarati"));
        player.addSong(new Song("Meetha Khaara", "Aditya Gadhvi", 230, "chill", "Meetha khaara dariya nu pani...", "Gujarati"));
        player.addSong(new Song("Lai Ja Ne Lerida", "Gopal Bharwad", 311, "energy", "Lai ja ne lerida mare des re...", "Gujarati"));
        player.addSong(new Song("Dwarika No Naath", "Jaysinh Gadhavi", 255, "happy", "Maro dwarika no nath mara...", "Gujarati"));
        player.addSong(new Song("Mani Le Tu", "Mukesh", 190, "chill", "Mani le tu zindgani...", "Gujarati"));
        player.addSong(new Song("Nayan Ne Bandh", "Manhar Udhas", 220, "sad", "Nayan ne bandh rakhi ne tamne joya...", "Gujarati"));
        player.addSong(new Song("Ke Odhni Odhu", "Mahesh-Naresh", 210, "happy", "Ke odhni odhu odhu ne udi jaye...", "Gujarati"));
        player.addSong(new Song("Gori Radha Ne", "Kirtidan Gadhvi", 289, "energy", "Gori radha ne kalo kaan...", "Gujarati"));
        player.addSong(new Song("Manthari", "Traditional", 240, "chill", "Amare angane avsar aaj...", "Gujarati"));
        player.addSong(new Song("Jai Garvi Gujarat", "Manna Dey", 250, "happy", "Jai jai garvi gujarat...", "Gujarati"));
        player.addSong(new Song("Vagado Manjira", "Mahesh Vanzara", 320, "energy", "Vagado manjira... mara shamaliyo...", "Gujarati"));
        player.addSong(new Song("Sayari Mori Re", "Kedar & Bhargav", 215, "chill", "Sayari mori re... kaho ne...", "Gujarati"));

        while (true) {

            System.out.println();
            System.out.println("          ════════════════════════ BEATS & BYTES ════════════════════════          ");
            System.out.println();
            System.out.println("          ╔════════════════════════════╗   ╔════════════════════════════╗          ");
            System.out.println("          ║     1. Play Song           ║   ║     2. Make a Song         ║          ");
            System.out.println("          ╚════════════════════════════╝   ╚════════════════════════════╝          ");
            System.out.println("          ╔════════════════════════════╗   ╔════════════════════════════╗          ");
            System.out.println("          ║     3. Playlist            ║   ║     4. Play Quiz/Game      ║          ");
            System.out.println("          ╚════════════════════════════╝   ╚════════════════════════════╝          ");
            System.out.println("          ╔════════════════════════════╗   ╔════════════════════════════╗          ");
            System.out.println("          ║     5. Show Your Stats     ║   ║     6. Exit                ║          ");
            System.out.println("          ╚════════════════════════════╝   ╚════════════════════════════╝          ");
            System.out.println();
            System.out.println("          ═══════════════════════════════════════════════════════════════          ");

            System.out.print("👉 Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    // Play song
                    player.playSong();   // sub-menu: all / mood / language
                    break;

                case 2:
                    // Make song
                    player.writeYourOwnSong();
                    break;

                case 3:
                    // Playlist
                    player.showPlaylist();
                    break;

                case 4:
                    // Quiz / Game
                    player.playQuiz();
                    break;

                case 5:
                    // Show stats
                    player.showStats();
                    break;

                case 6:
                    // Exit
                    System.out.println("Thanks for using BEATS & BYTES 🎧");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
