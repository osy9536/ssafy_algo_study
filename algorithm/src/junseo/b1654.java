package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
이분탐색 랜선자르기
 */
public class b1654 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int i;
        int [] arr = new int[K];
        long mx = 0;
        for(i= 0;i<K;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            mx = Math.max(mx,arr[i]);
        }
        //////////////////////////////////////////////////////////////
        mx++;
        //mx를 찾을 때 upper bound는 mx의 idx+1이됨 즉 배열의 범위를 벗어남
        //그러므로 mx대신 mx+1을 찾게 하여(배열에 없으므로 못찾음)
        //mid를 갱신하여 배열이 범위를 벗어나지 못하게함
        long mid;
        long min = 0;
        long count = 0;
        while(min<mx) {
            mid = (min+mx)/2;
            count = 0;
            for(i = 0;i<K;i++) {
                count += (arr[i]/mid);
            }
            if(count<N) mx = mid;
            else min = mid+1;
            //+1을 안하면 계속 같은 mid값
        }
        System.out.println(min -1);
    }
}


