package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 트리의 부모 찾기
// silver 2
public class b11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] list = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        int[] answer = new int[n+1];
        for(int i = 1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()){
            int now = q.poll();
            if(visited[now]) continue;
            visited[now]=true;
            for (int i = 0; i < list[now].size(); i++) {
                int e = list[now].get(i);
                if(!visited[e]){
                    q.add(e);
                    answer[e]=now;
                }
            }
        }

        for(int i = 2; i<=n; i++){
            System.out.println(answer[i]);
        }
    }
}
