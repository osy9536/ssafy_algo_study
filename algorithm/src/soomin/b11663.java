package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11663 {

    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int a = binarySearchforSTART(0,N-1,start);
            int b = binarySearchforEND(0,N-1,end);


            sb.append(b-a).append("\n");
        }
        System.out.println(sb);

    }

    private static int binarySearchforSTART(int t1, int t2, int target) {
        int mid;

        int left = t1;
        int right = t2;

        while(left <= right){
            mid = (left+right)/2;

            if(arr[mid] < target){
                left = mid+1;

            }else{

                right = mid-1;
            }
        }

        return left;

    }


    private static int binarySearchforEND(int t1, int t2, int target) {
        int mid;

        int left = t1;
        int right = t2;

        while(left <= right){
            mid = (left+right)/2;

            if(arr[mid] <= target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }


        return right + 1;
    }
}
