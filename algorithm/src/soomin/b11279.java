package algorithm.src.soomin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;




public class b11279  {

        /* 최대힙 */
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // key 해당 수, value는 해당 수가 나온 횟수
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for(int i = 0; i < N; i++) {
            // 다음 수를 받는다.
            int cur = Integer.parseInt(br.readLine());

            // 해당 수가 0일시
            if(cur == 0) {
                // Heap이 비었다면 0출력
                if(tm.isEmpty()) {
                    System.out.println(0);
                    continue;
                }

                // Heap이 빈 것이 아니라면, Heap에서 제일 큰 값을 출력한다.
                System.out.println(tm.lastKey());
                // 그리고 제일 큰 값의 횟수를 하나 감소시킨다.
                tm.put(tm.lastKey(), tm.get(tm.lastKey())-1);

                // 만약 tm의 제일 큰값의 value(횟수)가 0이 된다면 해당 값을 제거 한다.
                if(tm.get(tm.lastKey()) == 0) {
                    tm.remove(tm.lastKey());
                }

            }else {
                if(!tm.containsKey(cur)) {
                    tm.put(cur, 1);
                }else {
                    tm.put(cur, tm.get(cur)+1);
                }
            }

        }
    }
}
