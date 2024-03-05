import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c삼오무 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int MAX_VAL = 2_000_000_000;
        long left,right;
        left = 1;
        right = MAX_VAL;
        long ans = MAX_VAL;
        while (left <= right){
            long mid = (left+right) / 2;
            long cnt = count(mid);
            if(cnt >= N){
                right = mid - 1;
                ans = Math.min(ans,mid);
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static long count(long mid) {
        return mid = mid - mid/3 - mid/5 + mid/15;
    }
}
