package algorithm.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동전 0
public class b11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            int money = Integer.parseInt(br.readLine());
            A[i] = money;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            if(A[i]>k) continue;
            result += k / A[i];
            k %= A[i];
        }
        System.out.println(result);
    }
}
