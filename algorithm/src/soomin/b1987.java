package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1987 {

    static int R, C;
    static char [][] alphabet;
    static ArrayList<Integer> results = new ArrayList<>();
    static ArrayList<Character> visited = new ArrayList<>();
    static int [] idx = {-1,1,0,0};
    static int [] idy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                alphabet[i][j] = s.charAt(j);
            }
        }
        visited.add(alphabet[0][0]);
        move(0,0,0);
        System.out.println(results.stream().mapToInt(x->x).max().orElse(-1)+1);
    }

    // 재귀 함수 -> 좌표를 주면 상하좌우로 이동, 만약 현재까지 지나온 문자 중 하나면 다시 뒤로 back, 아니면 재귀를 이어가며 나아감

    public static void move(int x, int y, int cnt) {

        if(x <0 || y < 0 || x == R || y == C) {
            results.add(cnt);
            return;
        }

        for(int i = 0; i<4; i++) {
            int nx = x + idx[i];
            int ny = y + idy[i];

            if(nx >=0 && ny >=0 && nx<R && ny<C) {
                if(!visited.contains(alphabet[nx][ny])) {
                    visited.add(alphabet[nx][ny]);
                    move(nx,ny,cnt+1);
                }
            }
        }
        results.add(cnt);
        visited.remove(visited.size()-1);
    }
}
