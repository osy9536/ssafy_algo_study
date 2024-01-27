
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < tc ; t++){

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < m ; i++) {
                int num = Integer.parseInt(st.nextToken());
                int left = 0, right = n - 1;
                boolean find = false;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (num == arr[mid]) {
                        find = true;
                        break;
                    } else if (num < arr[mid]) right = mid - 1;
                    else left = mid + 1;
                }
                if (find) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            }
        }
        System.out.println(sb);
    }
}
