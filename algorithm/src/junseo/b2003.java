package algorithm.src.junseo;

import java.util.Scanner;

public class b2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N,M,i;
        N = sc.nextInt();
        M = sc.nextInt();
        int [] arr = new int[N];
        for(i = 0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        long sum = 0;
        int start;
        int end = 0;
        long result = 0;
        for(start = 0;start<N;){
            if(sum>M || end ==N){
                sum -=arr[start];
                start++;
            }
            else{
                sum += arr[end];
                end++;
            }
            if(sum == M) result++;
        }
        System.out.println(result);
    }
}

