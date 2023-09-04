import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][][] visit;
    static ArrayList<Integer> ans;
    static int A, B, C;
    static int[] capa;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ans = new ArrayList<>();
        visit = new boolean[201][201][201];
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        capa = new int[3];
        capa[0] = A; 
        capa[1] = B;
        capa[2] = C;
        BFS();
        Collections.sort(ans);
        for(int i : ans) {
        	System.out.print(i+" ");
        }
    }
    public static class Bottles{
        int a, b, c;
        public Bottles(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static void BFS() {
        Queue<Bottles> q = new LinkedList<>();
        q.add(new Bottles(0, 0, C));
        visit[0][0][C] = true;
        ans.add(C);
        while(!q.isEmpty()) {
        	Bottles now = q.poll();
        	visit[now.a][now.b][now.c] = true;
        	int A = now.a;
            int B = now.b;
            int C = now.c;
            for(int i = 0; i < 6; i++) {
                int next[] = {A, B, C};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;
                if(next[receiver[i]] > capa[receiver[i]]) { //물이 넘쳤을 때
                	next[sender[i]] += next[receiver[i]] - capa[receiver[i]];
                	next[receiver[i]] = capa[receiver[i]];
                }
                if(!visit[next[0]][next[1]][next[2]]) {
                	visit[next[0]][next[1]][next[2]] = true;
                	q.add(new Bottles(next[0], next[1], next[2]));
                	if(next[0] == 0) {
                		ans.add(next[2]);
                	}
                }
            }
        }
    }
}
