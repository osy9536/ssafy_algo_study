package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
class Node{
    int end;
    int val;

    public Node(int end, int val) {
        this.end = end;
        this.val = val;
    }
}
public class b1865 {

    static int N,M,W;
    static int[] dist;
    static final int INF = 999999999;
    static  ArrayList<Node>[] road;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < TC ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            road = new ArrayList[N+1];
            dist = new int[N+1];

            for(int j = 0 ; j <= N ; j++){
                road[j]=new ArrayList<Node>();
            }
            for(int j = 0 ; j < M;j++){
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                road[S].add(new Node(E,T));
                road[E].add(new Node(S,T));
            }
            for(int j = 0 ; j < W;j++){
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                road[S].add(new Node(E,-T));
            }
            boolean isMinus = false;
            for(int j = 1 ; j<=N ; j++){
                if(bellmanFord(j)){
                    isMinus = true;
                    sb.append("YES\n");
                    break;
                }
            }
            if(!isMinus){
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
    public static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0; // 시작점은 0으로 초기화.
        boolean update = false;

        // (정점의 개수 - 1)번 동안 최단거리 초기화 작업을 반복함.
        for (int i = 1; i < N; i++) {
            update = false;

            // 최단거리 초기화.
            for (int j = 1; j <= N; j++) {
                for (Node n : road[j]) {
                    if (dist[j] != INF && dist[n.end] > dist[j] + n.val) {
                        dist[n.end] = dist[j] + n.val;
                        update = true;
                    }
                }
            }

            // 더 이상 최단거리 초기화가 일어나지 않았을 경우 반복문을 종료.
            if (!update) {
                break;
            }
        }

        // (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우
        // (정점의 개수)번도 업데이트 발생하면 음수 사이클이 일어난 것을 의미함.
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Node n : road[i]) {
                    if (dist[i] != INF && dist[n.end] > dist[i] + n.val) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

