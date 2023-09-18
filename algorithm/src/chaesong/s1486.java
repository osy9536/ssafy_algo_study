import java.util.*;
import java.io.*;
 
public class Solution {
    static int N, B;
    static int arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int total = 0;
            int ans = Integer.MAX_VALUE;
            for(int i = 0; i < 1<<N; i++) {
                total = 0;
                for(int j = 0; j < N; j++) {
                    if((i & 1 << j) != 0) {
                        total += arr[j];
                    }
                }
                if(total >= B) {
                    ans = Math.min(ans, total - B);
                }
            }
            bw.write("#"+t+" "+ans+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
 
}
