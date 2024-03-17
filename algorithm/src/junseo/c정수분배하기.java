import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c정수분배하기 {
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
        /*
        n개의 정수를 분배해서 같은 크기의 정수 k를 m개 이상 만들어야 함
        이 때 k의 최댓값
        시작값은 가장 작은 값으로 시작
         */

        int left,right;
        left = 1;
        right = 200000;
        int mx = 0;
        while (left <= right){
            int mid = (left+right)/2;
            if(isPossible(arr,mid,m)){
                left = mid + 1;
                mx = Math.max(mx,mid);
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(mx);

    }

    private static boolean isPossible(int[] arr, int mid, int m) {

        int cnt = 0;
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            cnt += arr[i] / mid;
        }
        return cnt >= m;
    }
}
