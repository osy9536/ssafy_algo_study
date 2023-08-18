package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_최적경로 {
    static ArrayList<Integer> path = new ArrayList<>();
    static ArrayList<Integer> FINALRESULT = new ArrayList<>();
    static boolean [] flag;
    static ArrayList<Coordinate> list;
    static Coordinate Home;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());

        for (int T = 1; T <= test_case; T++) {

            //방문 해야할 고객의 갯수
            int N = Integer.parseInt(br.readLine());
            flag = new boolean[N];
            // 고객들 집의 좌표 저장
            list = new ArrayList<>();
            // 거리의 합
            int sum = 0;


            StringTokenizer st = new StringTokenizer(br.readLine());

            // 회사(== 현재 나의 위치) 집은 따로 빼서 저장.
            Coordinate myLocation = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Home    = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            // 방문해야할 고객들 넣기
            for(int i = 0; i < N; i++) {
                list.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            Permutation(myLocation, 0);

            // 현재 위치에서의 최단 거리 계산
            System.out.printf("#%d %d\n",T,FINALRESULT.stream().mapToInt(x->x).min().orElse(-1));
            FINALRESULT.clear();
            path.clear();

        }
    }

    public static int distanceCalcul(Coordinate c1, Coordinate c2) {
        return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
    }

    // true 방문, false 미방문
    public static void Permutation(Coordinate current, int deepth) {


        if(path.size() == flag.length) {
            path.add(distanceCalcul(Home, current));
            FINALRESULT.add(path.stream().reduce((x,y) -> x+y).orElse(-1));
            path.remove(path.size()-1);
            return;
        }


        if(deepth == list.size()) {
            return;
        }

        for(int i = 0; i < list.size(); i++) {
            if(flag[i]) continue;

            flag[i] = true;
            path.add(distanceCalcul(current, list.get(i)));
            Permutation(list.get(i), deepth+1);
            flag[i] = false;
            path.remove(path.size()-1);
        }
        return;
    }
}
class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}
