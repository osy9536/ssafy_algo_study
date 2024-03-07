import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c이차원배열의오름차순정리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n,k;
        n = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());
        long MAX_VALUE = n * n;

        long left,right;
        left = 1;
        right = MAX_VALUE;
        long ans = MAX_VALUE;
        while(left <= right){
            long mid = (left + right)/ 2;
            if(countNum(n,mid) >= k){
                right = mid - 1;
                ans = Math.min(ans,mid);
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static long countNum(long n, long mid) {
        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += Math.min(n,mid/i);
        }
        return cnt;
    }

}
