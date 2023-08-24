import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1220 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int mag[][] = new int[N][N];
			//자석 채우기
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					mag[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//로직
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				//1로 시작해서 2로 끝나면 -> cnt++
				int j = 0;
				while(j < N) {
					int temp = j;
					if(mag[j][i] == 1) {
						for(int k = j+1; k < N; k++) {
							if(mag[k][i] == 2) {
								cnt++;
								j = k+1;
								break;
							}
						}
						if(j == temp) break;
						else continue;
					}
					else j++;
				}	
				
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
