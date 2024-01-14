package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 보석 도둑
// gold 2
public class b1202 {

    static int N, K;
    static long answer;
    static int[][] jewel;
    static int[] bag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewel = new int[N][2];
        bag = new int[K];
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewel[i][0] = M;
            jewel[i][1] = V;
        }

        Arrays.sort(jewel, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            bag[i] = C;
        }
        Arrays.sort(bag);
        inMyBag();

        System.out.println(answer);
    }

    static void inMyBag(){
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && jewel[j][0] <= bag[i]) {
                q.add(jewel[j++][1]);
            }

            if (!q.isEmpty()) {
                answer += q.poll();
            }
        }
    }
}
