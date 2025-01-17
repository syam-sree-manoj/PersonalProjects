package Java;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class Maps {

    public static void main(String[] args) {
        ArrayList<String> lis = new ArrayList<>(List.of("Alice", "Bob"));
        List<String> ans = lis.stream().filter((String s) -> s.startsWith("A")).collect(Collectors.toList());
        System.out.println(ans);
    }
}
/*

Summary Table
Feature	        HashMap	            LinkedHashMap	            TreeMap
Ordering	    No guarantee	    Insertion order	            Sorted order (natural or custom)
Performance	    O(1) average	    O(1) average	            O(log n)
Null Keys	    1 allowed	        1 allowed	                Not allowed
Null Values	    Allowed	            Allowed	                    Allowed
Implementation	Hash table	        Hash table + Linked list	Red-black tree
Use Case	    Fast lookup	        Maintain ordr of insertion	Maintain sorted order of keys

computeIfAbsent()
    V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
    If the key is not present or value associated with given key is null, the mappingFunction is applied to compute a value, which is then added to the map.

    Map<String, String> map = new HashMap<>();
    map.put("A", null);  // Key "A" is present, but value is null

    // Apply computeIfAbsent
    map.computeIfAbsent("A", key -> "newValue");

    System.out.println(map); // {A=newValue}


computeIfPresent()
    V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
    If the key is present and its value is non-null, the remappingFunction is applied to compute a new value, which is then updated in the map.
    If the computed value is null, the entry is removed from the map.


compute()  ==== Best function =======
    V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
    If the key is not present, the remapping function will be applied, and the key-value pair will be inserted.
    If the key is present and the value is not null, the remapping function will compute a new value based on the current value.
    If the key is present and the value is null, the remapping function will be applied to null.
    If computed value is null then it removes entry from the Map



 */