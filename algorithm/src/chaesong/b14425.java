import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> S = new HashMap<>();
		String T[] = new String[M];
		for(int i = 0; i < N; i++) {
			S.put(br.readLine(), i);
		}
		for(int j = 0; j < M; j++) {
			T[j] = br.readLine();
		}
		int ans = 0;
		for(int j = 0; j < M; j++) {
			if(S.containsKey(T[j])) ans++;
		}
		System.out.println(ans);
	}

}
