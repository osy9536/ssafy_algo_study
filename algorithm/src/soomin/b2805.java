package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*---------나무자르기----------*/
public class b2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M =Long.parseLong(st.nextToken());

        long  [] arr = new long [(int)N];

        long max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long  tree = Long.parseLong(st.nextToken());
            arr[i] = tree;
            max = Math.max(max, tree);
        }

        long high = max;
        long bottom = 0;
        long mid;


        while (bottom <= high){
            long cutting = 0;
            mid = (high+bottom)/2 ;

            for (int i = 0; i < N; i++) {
                if(arr[i] > mid){
                    cutting += arr[i]-mid;
                }
            }

            if(cutting == M){
                System.out.println(mid);
                return;
            } else if (cutting > M) {
                bottom = mid+1;
            } else {
                high = mid -1;
            }
        }

        System.out.println(high);
    }
}
