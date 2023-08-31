import java.util.ArrayList;
import java.util.Scanner;

public class b1240 {
    static int N, M;
    static ArrayList<Integer>[] tree; 
    static int dist[][];
    static boolean visit[];
    static int ans; static int max_v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //노드의 개수
        M = sc.nextInt(); //노드 쌍의 개수
        tree = new ArrayList[N+1];
        dist = new int[N+1][N+1];
        visit = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
            dist[a][b] = d;
            dist[b][a] = d;
        }
        for(int j = 0; j < M; j++) {
            visit = new boolean[N+1];
            ans = 0;
            max_v = 0;
            int from = sc.nextInt();
            int to = sc.nextInt();
            howFar(from, to);
            System.out.println(max_v);
        }
    }
    static void howFar(int from, int to) {
        visit[from] = true;
        ArrayList<Integer> now = tree[from];
        for(int i = 0; i < now.size(); i++) {
            if(!visit[now.get(i)]) {
                visit[now.get(i)] = true;
                ans += dist[from][now.get(i)];
                if(now.get(i) == to) {
                	max_v = max_v < ans? ans : max_v;
                    return;
                }
                else {
                    howFar(now.get(i), to);
                    visit[now.get(i)] = false;
                    ans -= dist[from][now.get(i)];
                }
            }
        }
    }
}
