import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int W,H;

    // 육지(L) == 0, 바다(W) == -1, 나머지 값 == 시작점으로부터 걸린 횟수
    static int [][] land;

    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {


        // 0. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> HourList = new ArrayList<>();

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        land = new int[W][H];

        for (int i = 0; i < W; i++) {
            String s = br.readLine();
            for (int j = 0; j < H; j++) {
                if(s.charAt(j) == 'W'){
                    land[i][j] = -1; // 바다
                } else if (s.charAt(j) == 'L') {
                    land[i][j] = 0; // 육지
                }
            }
        }

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if(land[i][j] == 0){
                    HourList.add(BFS(i,j));
                }
            }
        }

        Collections.sort(HourList);
        System.out.println(HourList.get(HourList.size()-1));

    }

    // 육지인 경우에만 값이 들어온다.
    static int BFS(int x, int y) {

        int moveCnt = 0;
        land[x][y] = -999;
        ArrayDeque<Coordinate1> aq1 = new ArrayDeque<>();
        aq1.add(new Coordinate1(x,y));


        while(!aq1.isEmpty()){
            // 한 턴에 +1씩 moveCnt를 올린다.
            moveCnt ++;
            int Qsize = aq1.size();
            for (int k = 0; k < Qsize; k++) {
                Coordinate1 now = aq1.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + idx[i];
                    int ny = now.y + idy[i];

                    // (1) 그래프 안에 포함되고
                    if(nx >=0 && ny >= 0 && nx < W && ny < H){
                        // (2) 바다가 아니라면
                        if(land[nx][ny] == 0){
                            land[nx][ny] = moveCnt;
                            aq1.add(new Coordinate1(nx,ny));
                        }
                    }
                }
            }

        }
        // BFS 검사로 더럽혀진 배열을 깨끗하게 돌려놓는다.
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if(land[i][j] != 0 && land[i][j] !=-1){
                    land[i][j] = 0;
                }
            }
        }


        // 이 BFS가 끝나고 나면 moveCnt에는 최장 moveCnt가 남는다.
        return moveCnt-1;
    }

}

class Coordinate1 {
    int x;
    int y;

    public Coordinate1 (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

