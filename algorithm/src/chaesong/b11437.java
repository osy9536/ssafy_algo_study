import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b11437 {
    static int N, M;
    static ArrayList<Integer> tree[];
    static int[] depth, parent;
    static boolean visit[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        //트리만들기
        for(int i = 1; i <= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b); tree[b].add(a);
        }

        depth = new int[N+1];
        parent = new int[N+1];
        visit = new boolean[N+1];

        BFS(1);
        //조상찾기
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ans = findParent(a, b);
            bw.write(ans+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int findParent(int a, int b) {
        if (depth[a] < depth[b]){ //b가 더 밑에 있다면
            while(depth[a] != depth[b]){  //계속 b의 부모 노드로 이동
                b = parent[b];
            } //빠져나올 땐 두 노드의 깊이가 같아짐
        }else if(depth[b] < depth[a]){ //a가 더 밑에 있다면
            while(depth[a] != depth[b]){  //계속 a의 부모 노드로 이동
                a = parent[a];
            } //빠져나올 땐 두 노드의 깊이가 같아짐
        }
        while(a != b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
    static void BFS(int node) {
        int height = 1;
        int now_size = 1;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visit[node] = true;
        while(!q.isEmpty()) {
            int now_node = q.poll();
            for(int next : tree[now_node]) {
                if(!visit[next]) {
                    q.add(next);
                    visit[next] = true;
                    parent[next] = now_node; //부모노드 저장
                    depth[next]= height; //깊이 저장
                }
            }
            count++;
            if(count == now_size){
                count = 0;
                now_size = q.size();
                height++;
            }
        }
    }
}
