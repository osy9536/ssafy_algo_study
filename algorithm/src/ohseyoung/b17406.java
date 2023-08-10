package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 배열 돌리기 4
// gold 4
public class b17406 {
    static int N, M, K;
    static int min, answer = Integer.MAX_VALUE;
    static int[][] map, maps, point;
    static boolean[] visited;
    static ArrayList<Integer> order = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[K];
        maps = new int[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                maps[i][j] = a;
            }
        }
        point = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
            point[i][2] = Integer.parseInt(st.nextToken());
        }

        simulation( 0);

        System.out.println(answer);
        // 결과 출력
//        print();
    }

    // 1 2 3 4
    // 1 4 2 3
    // K 개의 조합으로 돌려보기
    static void simulation(int depth) {
        if (depth == K) {
            for (int j = 0; j < maps.length; j++) {
                map[j] = maps[j].clone();
            }
            // 순서대로 회전 연산을 수행하며 결과를 갱신
            for (int i : order) {
                rotate(i);
            }
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += map[i][j];
                }
                answer = Math.min(answer, sum);
            }
            return;
        }
        for(int i = 0; i<K; i++){
            if (!visited[i]) {
                visited[i] = true;
                order.add(i);
                simulation( depth + 1);
                order.remove(order.size()-1);
                visited[i] = false;
            }
        }
    }


    // 회전 시키는 메소드
    static void rotate(int k) {// 2,0 4,2
        int x1 = point[k][0] - point[k][2] - 1;
        int y1 = point[k][1] - point[k][2] - 1;
        int x2 = point[k][0] + point[k][2];
        int y2 = point[k][1] + point[k][2];

        min = point[k][2]; // 행, 열 중 더 작은 것 구함

        for (int t = 0; t < min ; t++) { // 회전 시킬 그룹의 갯수 구하기
            int x = t + x1;
            int y = t + y1;

            int temp = map[x][y]; // 마지막에 넣을 값 미리 빼놓음

            int idx = 0; // 우, 하, 좌, 상 방향으로 이동하며 반시계 방향으로 값 넣을 인덱스
            while (idx < 4) { // 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는 연산을 차례로 수행
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                // 범위 안이라면
                if (nx < x2 - t && ny < y2 - t && nx >= t + x1 && ny >= t + y1) {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                }
                // 범위를 벗어났다면 다음 방향으로 어감
                else {
                    idx++;
                }

            }

            map[t + x1][t + 1 + y1] = temp; // 빼 놓은 값 넣어 줌
        }

    }

    // 출력 함수
    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
