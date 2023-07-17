package algorithm.src.junseo;

import java.util.Scanner;

public class b1644 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        boolean[] checkPrime = new boolean[M + 100];
        int i, j;
        //////////////////////////////////////////
        for (i = 2; i <= M; i++) {
            if (checkPrime[i] != true) {
                for (j = i + i; j <= M; j += i) {
                    checkPrime[j] = true;
                }
            }
        }
        int idx = 0;
        int[] arr = new int[M];
        for (i = 2; i <= M; i++) {
            if (checkPrime[i] != true) {
                arr[idx] = i;
                idx++;
            }
        }
        ////////////////////////////////////////////
        int sum = 0;
        int start = 0;
        int end = 0;
        int result = 0;
        while (start < idx) {
            if (sum > M || end == idx) {
                sum -= arr[start];
                start++;
            } else {
                sum += arr[end];
                end++;
            }
            if (sum == M)
                result++;
        }
        System.out.println(result);
    }
}

