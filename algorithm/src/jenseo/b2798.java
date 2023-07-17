package algorithm.src.jenseo;

import java.util.Scanner;
public class b2798 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int i, j, k;

        int[] arr = new int[N];
        for (i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int length = arr.length;
        int max = 0;
        for (i = 0; i < length; i++) {
            for (j = i + 1; j < length; j++) {
                if (arr[i] + arr[j] > M)
                    continue;
                for (k = j + 1; k < length; k++) {
                    if (arr[i] + arr[j] + arr[k] > M)
                        continue;
                    else {
                        if (arr[i] + arr[j] + arr[k] > max) {
                            max = arr[i] + arr[j] + arr[k];
                        }
                    }
                }
            }
        }
        System.out.println(max);
        sc.close();
    }
}
