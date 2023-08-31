package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b28278 {
    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb =new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if(order == 1){
                int data = Integer.parseInt(st.nextToken());
                stack.push(data);
            } else if (order == 2) {
                sb.append(stack.isEmpty()? -1 : stack.pop()).append("\n");
            } else if ( order == 3 ){
                sb.append(stack.size()).append("\n");
            } else if (order == 4) {
                sb.append(stack.isEmpty()? 1 : 0).append("\n");
            } else if (order == 5) {
                sb.append(stack.isEmpty()? -1 : stack.peek()).append("\n");
            }
        }
        System.out.println(sb);

    }
}
