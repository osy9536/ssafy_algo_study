package algorithm.src.jisu;

import java.util.*;

public class b13908 {
 
    static int n, m;
    static int count;
    static boolean[] visited;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
        m = sc.nextInt();
 
        visited = new boolean[10];
        for(int i = 0; i < m; i++) {
            visited[sc.nextInt()] = true;
        }
 
        backtracking(0, 0);
        System.out.println(count);
    }
 
    public static void backtracking(int idx, int cnt) {
        if(idx == n) {
            if(cnt == m) count++; 
            return;
        }
 
        for(int i = 0; i <= 9; i++) {
            if(visited[i]) {
                visited[i] = false;
                backtracking(idx + 1, cnt + 1);
                visited[i] = true;
            } else {
                backtracking(idx + 1, cnt);
            }
        }
    }
}