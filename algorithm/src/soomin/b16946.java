package algorithm.src.soomin;

import java.util.*;
import java.io.*;

public class b16946{

    // 그래프의 가로 세로
    static int N;
    static int M;

    // 군집한 것 숫자 세는 용
    static int uniNum = 2;

    static int [][] graph;
    static int [][] union;


    // <0군집의 번호, 0군집 내의 개수>
    static HashMap<Integer, Integer> map = new HashMap<>();

    // 쓴 유니온 집합 확인 용
    static BitSet bit;


    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 값 넣기 ---------------------------------------------------
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        union = new int[N][M];


        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        // 유니온 군집 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 원 그래프에서 해당 부분이 0이고, 0군집 세는 곳에서도 아직 체크가 안되었다면
                if(graph[i][j] == 0 && union[i][j] == 0){
                    zeroBfs(i,j);
                }
            }
        }

//        System.out.println(map);
//

        StringBuilder sb = new StringBuilder();

        // 이제 1인 지점에서 사방 탐색해서 유니온 몇 개인지만 세면 된다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 1){
                    sb.append(check4(i,j));
                }
                else{
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

    // BFS 0 군집용 -> 원 그래프에서 0이 아닌 지점 확인 -> 거기서 군집부분을 전부 숫자로 바꿈.
    static void zeroBfs (int x, int y) {
        ArrayDeque<Coordinate127> aq1 = new ArrayDeque<>();
        aq1.add(new Coordinate127(x,y));
        union[x][y] = uniNum;
        int cnt = 0;
        while(!aq1.isEmpty()){
            int Qsize = aq1.size();

            for (int i = 0; i < Qsize; i++) {

                Coordinate127 now = aq1.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = now.x + idx[j];
                    int ny = now.y + idy[j];

                    if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                        if(union[nx][ny] == 0 && graph[nx][ny] == 0){
                            union[nx][ny] = uniNum;
                            aq1.add(new Coordinate127(nx,ny));
                        }
                    }
                }

                cnt++;
            }
        }
        map.put(uniNum, cnt);
        uniNum++;
    }

    static int check4 (int x, int y) {
        int ans = 1;
        bit = new BitSet(uniNum);

        for (int i = 0; i < 4; i++) {
            int nx = x + idx[i];
            int ny = y + idy[i];

            if(nx >= 0 && ny >=0 && nx < N && ny < M){
                int nowUnion = union[nx][ny];
                if(nowUnion == 0) continue;
                // 만약 현재 조회중인 0 군집을 아직 확인하지 않은 상태라면,
                if(!bit.get(nowUnion)){
                    bit.set(nowUnion, true);
                    ans += map.get(nowUnion);
                }
            }
        }

        return ans%10;
    }

}

class Coordinate127 {
    int x;
    int y;

    public Coordinate127(int x, int y){
        this.x = x;
        this.y = y;
    }
}