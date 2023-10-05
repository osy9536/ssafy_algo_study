package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class b1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> PQ = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int order = Integer.parseInt(br.readLine());

            if(PQ.isEmpty() && order == 0){
                sb.append("0").append("\n");
            }
            if(!PQ.isEmpty() && order == 0){
                sb.append(PQ.poll()).append("\n");
            }
            if(order != 0){
                PQ.add(order);
            }
        }
        System.out.println(sb);
    }
}
