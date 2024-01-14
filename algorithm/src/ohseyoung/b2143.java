package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 두 배열의 합
// gold 3
public class b2143 {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 A의 부분 합 저장
        HashMap<Long, Long> mapA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += arrA[j];
                mapA.put(sum, mapA.getOrDefault(sum, 0L) + 1);
            }
        }

        // 배열 B의 부분 합으로 T와의 차이가 나오는 경우를 계산
        long answer = 0;
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += arrB[j];
                long diff = T - sum;
                if (mapA.containsKey(diff)) {
                    answer += mapA.get(diff);
                }
            }
        }

        System.out.println(answer);
    }
}
