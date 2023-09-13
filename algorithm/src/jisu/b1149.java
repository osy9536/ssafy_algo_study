package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1149 {
	static int n;
    static int[] dp;
    static int result = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        dp = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}
        
        int[] now = new int[3];
        for (int i = 1; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 3; j++) {
				now[j] = Integer.parseInt(st.nextToken());
				
				List<Integer> list = new ArrayList<>();
				for (int k = 0; k < 3; k++) {
					if (j!=k) list.add(now[j]+dp[k]);
				}
				now[j] = Math.min(list.get(0), list.get(1));
			}
        	
        	dp[0] = now[0];
        	dp[1] = now[1];
        	dp[2] = now[2];
		}
        
        System.out.println(Math.min(dp[0], Math.min(dp[1], dp[2])));
        
        
    }
}
