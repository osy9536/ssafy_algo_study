import java.util.*;
import java.io.*;

public class b11657 {
	static int N, M;
	static long dist[];
	static Edge edges[];
	static class Edge{
		int start, end, time;
		public Edge(int start, int end, int time) {
			this.start = start;
			this.end = end;
			this.time = time;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edges = new Edge[M];
		dist = new long[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(start, end, time);
		}
		//벨만-포드
		dist[1] = 0;
		for(int i = 1; i < N; i++) { // 엣지개수-1개 만큼 반복하기
			for(int j = 0; j < M; j++) { // 엣지 다 돌려보기
				Edge edge = edges[j];
				if(dist[edge.start] != Integer.MAX_VALUE && 
						dist[edge.end] > dist[edge.start] + edge.time) {
					dist[edge.end] = dist[edge.start] + edge.time;
				}
			}
		}
		boolean minusCycle = false;
		for(int i = 0; i < M; i++) { // 한번 더 돌려보기 
			Edge edge = edges[i];
			if(dist[edge.start] != Integer.MAX_VALUE &&
					dist[edge.end] > dist[edge.start] + edge.time) {
				minusCycle = true;
			}
		}
		if(!minusCycle) { // 음의 싸이클이 없다면
			for(int i = 2; i <= N; i++) {
				if(dist[i] == Integer.MAX_VALUE) {
					System.out.println("-1"); // 가는 경로가 없다면
				}else {
					System.out.println(dist[i]);
				}
			}
		}else { // 음의 싸이클이 존재한다면
			System.out.println("-1"); 
		}
	}
}
