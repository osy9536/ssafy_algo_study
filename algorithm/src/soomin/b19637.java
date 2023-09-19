package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b19637 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, String> map = new HashMap<>();


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr =new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());
            map.putIfAbsent(amount, name);

            arr[i] = amount;
        }
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < M; i++) {
            int combatPower = Integer.parseInt(br.readLine());
            int start = 0;
            int end = N-1;
            int mid = 0;
            int target =0;
            while (start<=end){
                mid = (start+end)/2;

                if(arr[mid] < combatPower){
                    start = mid+1;
                }else if(arr[mid] >= combatPower){
                    end = mid-1;

                    // 해당 반복문이 계속되면, 최소 상한선이 자연스레 target에 들어간다.
                    target = arr[mid];
                }
            }
            sb.append(map.get(target)).append("\n");
        }
        System.out.println(sb);
    }
}
