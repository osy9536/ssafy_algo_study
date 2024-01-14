package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2512 {
    public static int[] arr;
    public static int N,M,sum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num=0;
        while(st.hasMoreTokens()){
            arr[num] = Integer.parseInt(st.nextToken());
            sum+=arr[num];
            num++;
        }
        M = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        System.out.println(binarySearch(arr[N-1]));
    }
    public static int binarySearch(int ans){
        if(sum <= M)
            return ans;
        int left = 0;
        int right = M;
        while(left<=right) {
            int current = 0;
            int mid = (left + right) / 2;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid)
                    current += mid;
                else
                    current += arr[i];
            }
            if(current>M){
                right = mid - 1 ;
            }else if(current<M){
                left = mid + 1;
            }
            else
                return mid;

        }
        return right;
    }
}