package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Default가 최소힙
        PriorityQueue<Integer> q1 = new PriorityQueue<>();


        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][N];

        // 배열에 값 집어넣기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 일단 배열의 마지막 행을 전부 담아 넣음
        // N번째 큰 수임으로, 우선순위 큐의 최상단이 항상 N번째 큰 수임.
        for (int i = 0; i < N; i++) {
            q1.add(arr[N-1][i]);
        }

        // 그 위의 행과 비교, 만약 우선순위 큐 최상단(큐 중 제일 최소값)보다
        // 큰 수가 있으면 교환. -> 큐의 다른 값보다 커도 상관 무 어짜피 다시 최소로 재배열
        for (int i = N-2; i >= 0 ; i--) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if(arr[i][j] > q1.peek()){
                    q1.poll();
                    q1.add(arr[i][j]);
                }else{
                    // 만약 큐의 최소값보다 배열의 값이 작을 경우 카운트
                    cnt++;
                }
            }
            // cnt == 행의 길이, 해당 행이 전부 큐의 값보다 작다는 뜻
            // 따라서 그 위로는 따져봤자 의미가 없음
            if(cnt == N) break;
        }

        System.out.println(q1.poll());
    }
}
