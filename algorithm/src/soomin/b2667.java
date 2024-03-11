import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int [] idx = {-1,0,1,0};
    static int [] idy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> aptList = new ArrayList<>();

        // 1) 값 받기
        int N = Integer.parseInt(br.readLine());

        int [][] apart = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                apart[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        // 2) 2차원 배열을 순회
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                int apartCnt = 0;

                // 3) 순회하다가 1을 만나면 사방탐색을 통해 근처의 아파트 단지 모두 검색 (한 번 검색한 방은 -1로 값을 바꾸기)
                if(apart[i][j] == 1){
                    ArrayDeque<Coordinate> aq1 = new ArrayDeque<>();
                    aq1.add(new Coordinate(i,j));
                    apart[i][j] = -1;

                    apartCnt++;

                    // 3-2) 사방 탐색
                    while (!aq1.isEmpty()){
                        Coordinate now = aq1.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = now.x + idx[k];
                            int ny = now.y + idy[k];

                            // 만약 사방 검색 값이 2차원 배열안에 들어가고, 그 값이 1이면
                            if(nx>=0 && ny>=0 && nx < N && ny < N  && apart[nx][ny] == 1){
                                // 값 추가
                                aq1.add(new Coordinate(nx,ny));
                                apart[nx][ny] = -1;
                                apartCnt++;
                            }
                        }
                    }

                    // 3-3) 1을 조우 후 BFS를 다 돌았다면, 아파트 단지 하나가 끝난 것이다.
                    // 따라서 해당 단지의 아파트 개수를 aptList에 넣는다.
                    aptList.add(apartCnt);
                }
            }
        }

        // 4) 모든 아파트 단지의 아파트 수를 출력
        Collections.sort(aptList);
        System.out.println(aptList.size());

        for(int temp : aptList){
            System.out.println(temp);
        }

    }

}
// 좌표 Class
class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}