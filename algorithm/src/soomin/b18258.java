package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        ArrayDeque<Integer> q1 = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int input =0;

            if(order.equals("push")){
                input = Integer.parseInt(st.nextToken());
            }

            switch (order){
                case "push":
                    q1.add(input);
                    break;
                case "front":
                    sb.append(q1.isEmpty()? -1 : q1.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(q1.isEmpty()? -1 : q1.peekLast()).append("\n");
                    break;
                case "pop":
                    sb.append(q1.isEmpty()? -1 : q1.poll()).append("\n");
                    break;
                case "size":
                    sb.append(q1.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q1.isEmpty()? 1 : 0).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
