package algorithm.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 카드 정렬하기
public class b1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        int a, b;
        while (pq.size() > 1) {
            a = pq.remove();
            b = pq.remove();
            int mergeSum = a + b;
            sum += mergeSum;
            pq.offer(mergeSum);
        }

        System.out.println(sum);
    }
}
