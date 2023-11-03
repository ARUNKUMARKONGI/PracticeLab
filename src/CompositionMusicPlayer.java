import java.util.*;

// Class representing a Song
class Song {
    private String title;
    private String artist;
    private double duration;

    public Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }
}

// Class representing a Playlist
class Playlist {
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void listSongs() {
        StringBuilder builder = new StringBuilder();
        builder.append("Playlist: ").append(name).append("\n");
        for (Song song : songs) {
            builder.append("Title: ").append(song.getTitle()).append(" - Artist: ").append(song.getArtist())
                    .append(" - Duration: ").append(song.getDuration()).append(" seconds\n");
        }
        System.out.print(builder.toString());
    }

    /*public void searchByArtist(String artist) {
        StringBuilder builder = new StringBuilder();
        builder.append("Songs by artist ").append(artist).append(" in playlist ").append(name).append(":\n");
        for (Song song : songs) {
            if (song.getArtist().equalsIgnoreCase(artist)) {
                builder.append("Title: ").append(song.getTitle()).append(" - Duration: ")
                        .append(song.getDuration()).append(" seconds\n");
            }
        }
        System.out.print(builder.toString());
    }*/
}

// Class representing a MusicPlayer
class MusicPlayer {
    private Map<String, Playlist> playlists;
    private Set<String> artistNames;

    public MusicPlayer() {
        // Use a regular HashMap for playlist names (case-insensitive comparison handled separately)
        playlists = new HashMap<>();
        artistNames = new HashSet<>();
    }

    public void createPlaylist(String name) {
        Playlist playlist = new Playlist(name);
        playlists.put(name.toLowerCase(), playlist); // Store the name in lowercase
    }

    public Playlist getPlaylistByName(String name) {
        return playlists.get(name.toLowerCase()); // Retrieve using lowercase name
    }

    public void addSongToPlaylist(String playlistName, Song song) {
        // Use the case-insensitive playlist name
        Playlist targetPlaylist = playlists.get(playlistName.toLowerCase());
        if (targetPlaylist != null) {
            targetPlaylist.addSong(song);
            artistNames.add(song.getArtist());
        } else {
            System.out.println("Invalid playlist name. Playlist not found.");
        }
    }

    public void searchForSongsByArtist(String partialArtist) {
        System.out.println("Songs by artist (complete or partial match) in all playlists:");
        for (Playlist playlist : playlists.values()) {
            for (Song song : playlist.getSongs()) {
                if (song.getArtist().toLowerCase().contains(partialArtist.toLowerCase())) {
                    System.out.println("Title: " + song.getTitle() + " - Artist: " + song.getArtist() +
                            " - Duration: " + song.getDuration() + " seconds");
                }
            }
        }
    }

    public Set<String> getAllArtists() {
        return artistNames;
    }
    public Map<String, Playlist> getPlaylists() {
        return playlists;
    }
}

public class CompositionMusicPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicPlayer musicPlayer = new MusicPlayer();

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Create Playlist");
            System.out.println("2. Add Song to Playlist");
            System.out.println("3. List All Songs in All Playlists");
            System.out.println("4. Search for Songs by Partial Artist");
            System.out.println("5. List All Artists");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter playlist name: ");
                    String playlistName = scanner.nextLine();
                    musicPlayer.createPlaylist(playlistName);
                    break;

                case 2:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter duration in seconds: ");
                    double durationInSeconds = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter playlist name: ");
                    String playlistToAdd = scanner.nextLine();
                    Playlist targetPlaylist = musicPlayer.getPlaylistByName(playlistToAdd);

                    if (targetPlaylist != null) {
                        Song song = new Song(title, artist, durationInSeconds);
                        musicPlayer.addSongToPlaylist(playlistToAdd, song);
                    } else {
                        System.out.println("Invalid playlist name. Playlist not found.");
                    }
                    break;

                case 3:
                    System.out.println("All Songs in All Playlists:");
                    for (Playlist playlist : musicPlayer.getPlaylists().values()) {
                        playlist.listSongs();
                    }
                    break;

                case 4:
                    System.out.print("Enter partial artist name to search for: ");
                    String partialArtistToSearch = scanner.nextLine();
                    musicPlayer.searchForSongsByArtist(partialArtistToSearch);
                    break;

                case 5:
                    System.out.println("List of all artists:");
                    Set<String> artists = musicPlayer.getAllArtists();
                    artists.forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Exiting the Music Player.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
