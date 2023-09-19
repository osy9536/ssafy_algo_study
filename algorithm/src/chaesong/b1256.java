import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1256 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		int comb[][] = new int[202][202];
		for(int i = 0; i <= 200; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					comb[i][j] = 1;
				}else {
					comb[i][j] = comb[i-1][j] + comb[i-1][j-1];
					if(comb[i][j] > 1000_000_000) comb[i][j] = 1000_000_001;
				}
			}
		}
		if(comb[N+M][N] < K) {
			System.out.println(-1);
			return;
		}
		String ans[] = new String[N+M+1];
		for(int i = 1; i < ans.length; i++) {
			if(0 < N && K <= comb[N-1+M][N-1]) { 
				ans[i] = "a";
				N--;
				continue;
			}else{
				ans[i] = "z";
				K -= comb[N-1+M][M];
				M--;
				continue;						
			}				
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < ans.length; i++) {
			sb.append(ans[i]);
		}
		System.out.println(sb);
	}
}
