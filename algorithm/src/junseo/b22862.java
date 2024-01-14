package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        int start = 0;
        int res = 0;
        int max = 0;
        while(end<N){
            int a = arr[end];

//            System.out.println(end +"  " +start + " "+K);
            if(a % 2 == 1){
                K--;
            }
            else{
                res++;
            }
            end++;
            while(K<0){
                int b = arr[start];
                if(b%2 == 1){
                    K++;
                }
                else{
                    res--;
                }
                start++;
            }
            max = Math.max(res,max);
        }
        System.out.println(max);

    }
}

