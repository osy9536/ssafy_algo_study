import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class c최대거리의점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n,m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left,right;
        left = 1;
        right = 1_000_000_000;
        int mn = -1;
        while(left <= right){
            int mid = (left+right) / 2 ;

            if(isPossible(arr,n,mid)>=m){
                left = mid + 1;
                mn = Math.max(mn,mid);

            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(mn);


    }

    private static int isPossible(int[] arr, int n, int mid) {

        int cnt = 1;
        int lastIdx = 0;

        for (int i = 1; i < n ; i++) {

            if(arr[i] - arr[lastIdx] >= mid){
                cnt++;
                lastIdx = i;
            }

        }
        return cnt;
    }
}

