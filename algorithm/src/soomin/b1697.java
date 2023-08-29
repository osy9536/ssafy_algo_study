package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b1697 {


    static int N,K;
    static int [] street = new int [200001];


    // 입력 받은 그래프에서 갈 수 있는 최대 깊이를 계속 갱신
    static int valid = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N==K) {
            System.out.println(0);
            return;
        }

        bfs();

        System.out.println(street[K]);
    }

    public static void bfs() {
        ArrayDeque<Integer> q1 = new ArrayDeque<>();

        // 초기값 위치에 값 채우기
        int cnt = 0;
        // 초기값을 큐에 넣기
        q1.add(N);

        outLoop:
        while(!q1.isEmpty()) {

            int Qsize = q1.size();

            for(int i = 0; i < Qsize; i++) {
                int current = q1.poll();

                if(street[current] != 0) continue;


                street[current] = cnt;

                if(current > K) {
                    q1.add(current-1);
                    continue;
                }

                q1.add(current+1);
                if(current >0) {
                    q1.add(current-1);
                }
                q1.add(2*current);
            }
            cnt++;

            if(street[K] != 0) break;
        }
    }
}
