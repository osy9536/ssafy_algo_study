import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1722 {
	public static void main(String[] args) throws IOException {
		int N, Q;
		long F[] = new long[21];
		int S[] = new int[21];
		boolean visit[] = new boolean[21];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Q = Integer.parseInt(st.nextToken());
		F[0] = 1; //팩토리얼 초기화
		for(int i = 1; i <= N; i++) {
			F[i] = F[i-1]*i;
		}
		//몇번째 순열인지?
		if(Q==1) {
			long K = Long.parseLong(st.nextToken());
			for(int i = 1; i <= N; i++) { //자리수
				for(int j = 1; j <= N; j++) {
					if(visit[j]) continue; //이미 선택한 숫자라면 
					if(F[N-i] < K) K -= F[N-i];
					else {
						S[i] = j;
						visit[j] = true;
						break;
					}
				}
			}
			for(int i = 1; i <= N; i++) {
				System.out.print(S[i]+" ");
			}
		}else {	//해당되는 순열 맞추기
			long K = 1;
			for(int i = 1; i <= N; i++) {
				S[i] = Integer.parseInt(st.nextToken());
				long cnt = 0;
				for(int j = 1; j < S[i]; j++) {
 					if(!visit[j]) cnt++;
				}
				K += cnt * F[N-i];
				visit[S[i]] = true;
			}
			System.out.println(K);
		}                                                                                                                                      
	}
}
