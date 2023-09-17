import java.util.*;
import java.io.*;

public class b11438 {
    static int N, M, dmax, k;
    static ArrayList<Integer> tree[];
    static int depth[];
    static boolean visit[];
    static int parent[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        depth = new int[N+1];
        visit = new boolean[N+1];
        for(int i = 0; i <= N; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b); tree[b].add(a);
        }

        int temp = 1;
        k = 0;
        while(temp <= N){
            temp <<= 1; //temp를 왼쪽으로 1칸 옮기기
            k++;
        }

        parent = new int[k+1][N+1];
        bfs(1); //첫번째 부모 배열 구하기
        for(int i = 1; i <= k; i++){
            for(int j = 1; j <= N; j++){
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = excuteLCA(a, b);
            bw.write(LCA+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int i){
        Queue<Integer> q = new LinkedList<>();

        //level은 깊이, now_size는 같은 깊이에 있는 노드의 개수
        int level = 1;
        int now_size = 1;
        int cnt = 0;

        visit[i] = true;
        q.add(i);
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int next : tree[temp]){
                if(!visit[next]){
                    visit[next] = true;
                    q.add(next);
                    parent[0][next] = temp; //next의 2^0번째 부모는 temp
                    depth[next] = level;
                }
            }
            cnt++;
            if(cnt == now_size){
                cnt = 0;
                now_size = q.size();
                level++;
            }
        }
    }

    static int excuteLCA(int a, int b){
        //무조건 b의 깊이가 더 깊게
        if(depth[a] > depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        //두 노드의 깊이를 같게 만든다
        for(int i = k; 0 <= i; i--){
            if(Math.pow(2, i) <= depth[b] - depth[a]){
                b = parent[i][b];
            }
        }
        //같은 높이가 되었는데도 노드값이 다르다면-> 빠른 탐색
        for(int i = k; 0 <= i; i--){
            if(parent[i][a] != parent[i][b]){
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        int LCA = a;
        if(a != b) LCA = parent[0][LCA];
        return LCA;
    }
}
