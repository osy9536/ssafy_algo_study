import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class b11047{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int coins[] = new int[N];
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        //동전 배열을 순회
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(K / coins[(N-1) - i] > 0){
                cnt += K / coins[(N-1) - i];
                K %= coins[(N-1) - i];
            }
            if(K == 0){
                break;
            }
        }
        System.out.println(cnt);
    }
}
