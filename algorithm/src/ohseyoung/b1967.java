package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 지름
// gold4
public class b1967 {

    static class Node {
        int val, node;

        Node(int node, int val) {
            this.node = node;
            this.val = val;
        }
    }
    

    static boolean[] leafs;
    static List<Node>[] list;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        leafs = new boolean[n + 1];
        list = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            if (leafs[a]) {
                leafs[a] = false;
            }
            leafs[b] = true;

            list[a].add(new Node(b, val));
            list[b].add(new Node(a, val));
        }

        for (int i = 0; i < n + 1; i++) {
            if (leafs[i]) {
                visited = new boolean[n + 1];
                visited[i] = true;
                DFS(i, 0);
            }
        }

        System.out.println(ans);
    }

    static void DFS(int node, int weight) {

        int cnt = 0;

        for (int i = 0; i < list[node].size(); i++) {
            int nextNode = list[node].get(i).node;
            int val = list[node].get(i).val;

            if (visited[nextNode]) continue;
            visited[nextNode] = true;
            cnt++;

            DFS(nextNode, weight + val);
        }
        if (cnt == 0) {
            ans = Math.max(ans, weight);
        }
    }
}
