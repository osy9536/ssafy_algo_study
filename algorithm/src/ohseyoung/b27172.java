package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수 나누기 게임
// gold 5
public class b27172 {
	
	public static void main(String[] args) throws IOException {
        // init
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // input
        int N = Integer.parseInt(bfr.readLine());
        int SIZE = 1000001;
        int[] player = new int[N];
        boolean[] card = new boolean[SIZE];
        int[] score = new int[SIZE];
        st = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < N; ++i) {
            player[i] = Integer.parseInt(st.nextToken());
            card[player[i]] = true;
        }

        // solution
        for (int i : player) {
            for (int j = i * 2; j < SIZE; j += i) {
                if (card[j]) {
                    ++score[i];
                    --score[j];
                }
            }
        }
        for (int num : player)
            sb.append(score[num]).append(' ');

        // output
        System.out.println(sb.toString());
    }
}
