import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b9184 {
	static int dp[][][] = new int[21][21][21];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == -1 && b == -1 && c == -1) break;
			sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a ,b ,c)).append('\n');
		}
		System.out.println(sb); //출력은 한번만 해줘야 빠르고 메모리도 적게 차지함
	}
	
	static int w(int a, int b, int c) {
		//a, b, c가 범위 내에 있고 이미 계산되어 있으면 해당 값 바로 반환
		if(inRange(a, b, c) && dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		//계산을 해야 한다면 
		if (a > 20 | b > 20 | c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}
		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}
		else {
			return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1); 
		}
	}
	
	static boolean inRange(int a, int b, int c) {
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <=20; 
	}
}
