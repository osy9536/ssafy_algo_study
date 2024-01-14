package algorithm.src.ohseyoung;

import java.io.*;
import java.util.StringTokenizer;

// 팰린드롬?
// gold 4
public class b10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            num[i] = a;
        }
        int M = Integer.parseInt(br.readLine());


        boolean[][] table = new boolean[N][N];

        // 홀수개
        for (int i = 0; i < N; i++) {
            int left = i;
            int right = i;

            while (left >= 0 && right < N) {
                if (num[left] == num[right]) {
                    table[left][right] = true;
                    left--;
                    right++;
                }else {
                    break;
                }
            }
        }

        // 짝수개
        for (int i = 0; i < N - 1; i++) {
            int left = i;
            int right = i+1;

            while (left >= 0 && right < N) {
                if (num[left] == num[right]) {
                    table[left][right] = true;
                    left--;
                    right++;
                }else {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken())-1;
            int E = Integer.parseInt(st.nextToken())-1;
            sb.append(table[S][E] ? 1 : 0).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
