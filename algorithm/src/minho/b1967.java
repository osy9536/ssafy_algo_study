package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int end;
    int val;

    public Node(int end, int val) {
        this.end = end;
        this.val = val;
    }

}

public class b1967 {

    static ArrayList<Node>[] list;
    static int N, ans;
    static boolean[] isVisited;

    static void DFS(int i, int sum) {
        for (Node n : list[i]) {
            if (!isVisited[n.end]) {
                isVisited[n.end] = true;
                DFS(n.end, sum+n.val);
            }
        }
        ans = (ans < sum) ? sum : ans;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];

        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        ans = 0;

        for (int i = 1; i <= N; i++) {
            if (list[i].size() == 1) {
                isVisited = new boolean[N + 1];
                isVisited[i] = true;
                DFS(i, 0);
            }
        }
        System.out.println(ans);

    }
}