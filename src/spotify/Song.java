package spotify;

import java.util.HashMap;
import java.util.Map;

public class Song {
    Integer id;
    static Integer counter = 0;
    String title;

    Song(String title){
        this.title = title;
        this.id  = counter++;
    }
}
