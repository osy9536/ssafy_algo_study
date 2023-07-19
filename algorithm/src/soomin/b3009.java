package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = (new BufferedReader(new InputStreamReader(System.in)));
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        int i = 0;
        while(i <3){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(map.containsKey(a)) {
                int temp = map.get(a);
                map.put(a, ++temp);
            } else{
                map.put(a, 1);
            }
            if (map2.containsKey(b)) {
                int temp = map2.get(b);
                map2.put(b, ++temp);
            } else {
                map2.put(b,1);
            }
            i++;

        }



        int a = map.keySet().stream().filter(x->map.get(x)%2 !=0).mapToInt(x->x).max().orElse(0);
        int b = map2.keySet().stream().filter(x->map2.get(x)%2 !=0).mapToInt(x->x).max().orElse(0);

        System.out.println(a + " " + b);
    }
}
