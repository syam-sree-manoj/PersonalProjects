import java.util.*;

public class Main {


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, "A"); // Key "A" is present, but its value is null

        map.compute(null, (key,value) -> (value == null) ? "newValue" : "oldValue");

        System.out.println(map);

    }
}





