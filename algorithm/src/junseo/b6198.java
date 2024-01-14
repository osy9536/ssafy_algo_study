package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class b6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        long res = 0;
        stack.push(Integer.parseInt(br.readLine()));
        long cnt = 1;
        for (int i = 1; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (!stack.isEmpty() && stack.peek() <= a ){
                while(!stack.isEmpty() && stack.peek()<=a) {
                    stack.pop();
                    cnt--;
                }
            }
            stack.push(a);
            res+=cnt;
            cnt++;
            //System.out.println(cnt+" "+res + stack.toString());
        }
        System.out.println(res);

    }
}


