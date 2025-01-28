import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Collections.sort(list, (a,b) -> {
            if(a > b){
                return -1;
            }else{
                return 1;
            }
        });

    }
}





