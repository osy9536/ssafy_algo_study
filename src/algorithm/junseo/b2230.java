package algorithm.junseo;

import java.util.Arrays;
import java.util.Scanner;

public class b2230 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int [] arr = new int[N];
        int i;
        for(i = 0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        /////////////////////////////////////////////////////////////////
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int result = 0;
        while(start<N){
            if(arr[start] - arr[end] < M){
                start++;
                continue;
            }
            if(arr[start] - arr[end] == M){
                min = M;
                break;
            }
            min = Math.min(min,arr[start] - arr[end]);
            end++;
        }
        System.out.println(min);
    }
}

