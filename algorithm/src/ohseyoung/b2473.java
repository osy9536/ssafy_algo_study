package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 세 용액
// gold 3
public class b2473 {
    static long[] arr;
    static long[] answer = new long[3];
    static int N;
    static long max = Long.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        // -97 -6 -2 6 98
        // -24 -6 -3 -2 61 98 100
        for(int i = 0; i<N-2; i++){
            twoPointer(i);
        }
        Arrays.sort(answer);
        System.out.println(answer[0]+" "+answer[1]+ " "+answer[2]);
    }
    static void twoPointer(int idx){
        int left = idx+1;
        int right = N-1;
        while (left < right) {
            long sum = arr[idx] + arr[left] + arr[right];
            long absSum = Math.abs(sum);
            if(absSum<max){
                answer[0] = arr[idx];
                answer[1] = arr[left];
                answer[2] = arr[right];
                max = absSum;
            }
            if(sum>0){
                right--;
            }else if(sum<0) left++;
            else {
                Arrays.sort(answer);
                System.out.println(answer[0]+" "+answer[1]+ " "+answer[2]);
                System.exit(0);
            }
        }
    }
}
