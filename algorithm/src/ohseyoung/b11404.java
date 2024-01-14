package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플로이드
// gold4
public class b11404 {

    private static final int INF=999999;

    static class Node{
        int e,w;

        Node(int e, int w){
            this.e=e;
            this.w=w;
        }


    }

    static int [][] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(adj[i],INF);
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s-1][e-1]=Math.min(adj[s-1][e-1],w);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if(i==k)continue;
                for (int j = 0; j < n; j++) {
                    if(j==k||j==i)continue;
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(adj[i][j]==INF) sb.append(0).append(" ");
                else sb.append(adj[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
