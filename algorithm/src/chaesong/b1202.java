import java.util.*;
import java.io.*;

public class b1202 {
	public static class Jewel{
		int M, V;
		public Jewel(int M, int V) {
			this.M = M;
			this.V = V;
		}
		@Override
		public String toString() {
			return "Jewel [M=" + M + ", V=" + V + "]";
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Jewel> jewels = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewels.add(new Jewel(M, V));
		}
		Collections.sort(jewels, (o1, o2) -> o1.M - o2.M);
		int bags[] = new int[K];
		for(int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		// 가방은 오름차순 정렬
		Arrays.sort(bags);
		PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> o2.V - o1.V);
		long ans = 0;
		
		// 가방을 순회하면서
		int j = 0;
		for(int i = 0; i < K; i++) {
			// 가능한 보석을 다 넣는다
			// 그럼 pq엔 무게는 오름차순으로, 가격은 내림차순으로 담긴다
			while(j < N && jewels.get(j).M <= bags[i]) {
				Jewel now = jewels.get(j);
				pq.add(now);
				j++;
			}
			// 가장 앞에 있는 걸 뽑아내면
			if(!pq.isEmpty()) {
				int now = pq.poll().V;
				ans += now;
			}
		}
		System.out.println(ans);
	}
}
