package algorithm.src.jisu;

import java.util.*;

public class b6986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        Arrays.sort(arr);
        
        double sum = 0.0;
        for (int i = k; i < n-k; i++) {
            sum += arr[i];
        }
        
        System.out.println(String.format("%.2f", sum/(n-k*2) + 1e-8));

        for (int i = 0; i < k; i++) {
            sum += arr[k];
            sum += arr[n-k-1];
        }
        
        System.out.println(String.format("%.2f", sum/n + 1e-8));
    }
}