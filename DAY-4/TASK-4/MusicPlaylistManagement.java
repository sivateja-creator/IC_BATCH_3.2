import java.util.LinkedList;

public class MusicPlaylistManagement {
    public static void main(String[] args) {

        LinkedList<String> playlist = new LinkedList<>();

        playlist.add("Naa Ready");
        playlist.add("Fear Song");
        playlist.add("Samajavaragamana");
        playlist.add("Butta Bomma");
        playlist.add("Oo Antava");

        System.out.println("Current Playlist: " + playlist);

        playlist.addFirst("Arjun Reddy Theme");
        playlist.addLast("Kesariya");

        System.out.println("After Adding Songs: " + playlist);

        playlist.removeFirst();
        playlist.removeLast();

        System.out.println("After Removing First and Last Songs: " + playlist);

        System.out.println("First Song: " + playlist.getFirst());
        System.out.println("Last Song: " + playlist.getLast());

        System.out.println("Is Fear Song Available? " + playlist.contains("Fear Song"));

        System.out.println("Now Playing: " + playlist.removeFirst());

        System.out.println("Playlist After Playing Next Song: " + playlist);
    }
}