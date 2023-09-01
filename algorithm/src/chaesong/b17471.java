import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b17471_my {
	static int N;
	static int voters[];
	static int ans = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		//유권자
		voters = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			voters[i] = Integer.parseInt(st.nextToken());
		}
		
		//지역구
		for(int i = 0; i <= N; i++) {
			groups.add(new ArrayList<Integer>());
		}
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0; j < n; j++) {
				int b = Integer.parseInt(st.nextToken());
				groups.get(i).add(b);
			}
		}
		
		//첫번째 그룹
		ArrayList<Integer> A = new ArrayList<>();
		for(int i = 1; i <= (int)(N/2); i++) {
			boolean visit[] = new boolean[N+1];
			comb(A, 0, i, visit); 
		}
		
		if(ans == Integer.MAX_VALUE) ans = -1;
		
		bw.write(ans+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	//조합: 리스트 A에서 r개를 뽑는다(n은 내가 뽑은 개수)
	static void comb(ArrayList<Integer> A, int n, int r, boolean visit[]) {
		if(n==r) {
			ArrayList<Integer> B = new ArrayList<>();
			divide(A, B);
			if(isConnect(A, A.get(0)) && isConnect(B, B.get(0))) { //두 그룹이 잘 나누어졌다면
				gerrymandering(A, B);
			}
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				A.add(i);
				comb(A, n+1, r, visit);
				visit[i] = false;
				A.remove(A.size()-1);
			}
		}
	}
	
	//2개의 그룹으로 나누자
	static void divide(ArrayList A, ArrayList B) {
		boolean visit[] = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			if(A.contains(i)) continue;
			else B.add(i);
		}
	}
	
	//그룹들이 서로 이어져 있는지?
	static boolean isConnect(ArrayList<Integer> A, int start) {
		boolean visit[] = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>(); 
		visit[start] = true;
		q.offer(start);
		int cnt = 1;
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int a : groups.get(temp)) {
				if(!visit[a] && A.contains(a)) {
					visit[a] = true;
					q.offer(a);
					cnt++;
				}
			}
		}
		if(cnt == A.size()) return true;
		else return false;
	}
	
	//계산하기
	static void gerrymandering(ArrayList<Integer> A, ArrayList<Integer> B) {
		int resA = 0; int resB = 0;
		for(int a : A) {
			resA += voters[a];
		}
		for(int b : B) {
			resB += voters[b];
		}
		ans = Math.min(Math.abs(resA-resB), ans);
	}
}
