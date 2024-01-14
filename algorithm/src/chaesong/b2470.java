import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0; int right = N-1;
        int A = 0; int B = 0;
        int min = Integer.MAX_VALUE;
        while(left < right) {
            int now = Math.abs(arr[right] + arr[left]);
            if(now < min){
                min = now;
                A = left; B = right;
            }
            if(arr[left]+arr[right] > 0){
                right--;
            }else{
                left++;
            }
        }
        System.out.print(arr[A] + " " + arr[B]);
    }
}
