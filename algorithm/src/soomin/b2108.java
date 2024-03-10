package algorithm.src.soomin;
import java.util.*;
import java.io.*;
public class b2108 {

    /*
     * 통계학
     * [2108번] 실버 3
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            list.add(temp);

            if(map.get(temp) != null) {
                map.put(temp, map.get(temp)+1);
            }
            map.putIfAbsent(temp, 1);
        }

        int MaxKey = 0;
        int MaxValue = 0;

        // 이걸 거치면 최빈값 중 최소값이 저장됨.
        for(int key : map.keySet()){
            if(map.get(key) > MaxValue){
                MaxKey = key;
                MaxValue = map.get(key);
            }
        }

        for(int key : map.keySet()){
            if(map.get(key) == MaxValue && key != MaxKey){
                MaxKey = key;
                break;
            }
        }


        Collections.sort(list);

        int sum = list.stream().reduce((x,y) -> x+y).orElse(0);


        StringBuilder sb = new StringBuilder();
        sb.append((int)Math.round((double) sum /list.size())).append("\n");
        sb.append(list.get(N / 2)).append("\n");
        sb.append(MaxKey).append("\n");
        sb.append(Math.abs(list.get(0) - list.get(list.size()-1)));
        System.out.println(sb);

    }
}
