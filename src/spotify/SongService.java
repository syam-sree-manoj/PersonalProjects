package spotify;
/*
import java.util.HashMap;
import java.util.*;
import javafx.util.Pair;

public class SongService {
    Map<String, Song> title_song_map = new HashMap<>();
    Map<Integer, Song> id_song_map = new HashMap<>();

    Map<Song, Set<Integer>> songUserIdMap = new HashMap<>();


    public void playSong(Integer song_id, Integer user_id){
        // perform db operation
        Song song = id_song_map.get(song_id);
        if(song == null){
            System.out.println("song not present");
        }


        Set<Integer> userIdSet = songUserIdMap.getOrDefault(song, new HashSet<>());
        userIdSet.add(user_id);
        songUserIdMap.put(song, userIdSet);

        System.out.println("Playing song");
    }

    public Song addSong(String songTitle){
        if(title_song_map.containsKey(songTitle)){
            return title_song_map.get(songTitle);
        }
        Song song = new Song(songTitle);
        title_song_map.put(songTitle, song);
        return song;
    }


    public void analytics_summary(){
//        Collection<Set<Integer>> values = songUserIdMap.values();

        PriorityQueue< Pair<Song,Integer> > pq = new PriorityQueue<> ((a,b) -> {
            if(a.getValue() > b.getValue()){
                return 1;
            }else{
                return -1;
            }
        });
        for(Map.Entry<Song,Set<Integer>> entry: songUserIdMap.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue().size()));
        }

        for(int i=0; i<pq.size(); i++){
            Pair<Song,Integer> pair = pq.poll();
            System.out.println(pair.ge1tKey().title + " " + pq.getValue());
        }
    }
}
*/