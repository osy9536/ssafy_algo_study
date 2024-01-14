package Boj;
import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayDeque;
        import java.util.Queue;
        import java.util.StringTokenizer;

public class Main {

    static int N, M, answer = 0,time=0;
    static boolean[] isVisited = new boolean[200005];
    public static void BFS() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0 ; i < size ; i++) {
                int recent = q.poll();
                isVisited[recent] = true;
                if(recent == M){
                    flag=true;
                    answer++;
                }
                if (recent-1>=0 && !isVisited[recent - 1])
                    q.offer(recent - 1);
                if (recent+1<=100000 && !isVisited[recent + 1])
                    q.offer(recent + 1);
                if (recent <= 100000 && !isVisited[recent * 2] )
                    q.offer(recent * 2);
            }
            if(flag)
                break;
            time++;
        }
        System.out.println(time);
        System.out.println(answer);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        BFS();

    }
}
