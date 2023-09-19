package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr= new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        loopout:
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N-1;
            int mid = 0;
            while (start <= end){
                mid = (start+end)/2;

                if(arr[mid] == target){
                    sb.append(1).append("\n");
                    continue loopout;
                }
                else if (arr[mid] > target){
                    end = mid-1;
                } else if (arr[mid] < target) {
                    start = mid+1;
                }
            }
            sb.append(0).append("\n");

        }

        System.out.println(sb);

    }
}
