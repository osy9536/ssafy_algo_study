import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n,m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        long[] kernel = new long[m];
        for(int i = 0; i<m; i++){
            kernel[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(kernel);
        long left,right;
        left = 1;
        right = (long)1e14;
        long mn = (long)1e14;
        while(left <= right){
            long mid = (left + right) / 2;

            if(isPossible(kernel,m,mid)>=n){
                right = mid-1;
                mn = Math.min(mn,mid);
            }
            else{
                left = mid + 1;
            }

        }
        System.out.println(mn);
    }
    public static long isPossible(long[] kernel, long m, long mid){

        long cnt = 0;
        for(int i = 0; i<m; i++){
            if(kernel[i]>mid) break;
            cnt += mid/kernel[i];
        }
        return cnt;
    }
}
