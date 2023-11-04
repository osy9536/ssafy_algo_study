package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N,K;
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        long end,start;
        start = 1;
        //end = (int) Math.min(N*N, Math.pow(10, 9));
        end = K;
        long ans = 0;
        while(end>=start) {

            long mid = (end+start)/2;

            long res;
            res = cal(mid);

            if(res < K) {
                start = mid+1;
            }
            else  {
                ans = mid;
                end = mid-1;
            }
        }
        System.out.println(ans);
    }
    private static long cal(long mid) {
        long cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(mid/i == 0) break;
            cnt += Math.min(N,mid/i);
        }
        return cnt;
    }
}



