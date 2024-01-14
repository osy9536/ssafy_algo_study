import java.util.*;
import java.io.*;

public class b1219 {
	static int N, M, sCity, eCity;
	static long[] dist, cityMoney;
	static Edge edges[];
	static class Edge{
		int start, end, price;
		public Edge(int start, int end, int price) {
			this.start = start;
			this.end = end;
			this.price = price;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sCity = Integer.parseInt(st.nextToken());
		eCity = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edges = new Edge[M];
		dist = new long[N];
		Arrays.fill(dist, Long.MIN_VALUE);
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(start, end, price);
		}
		cityMoney = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cityMoney[i] = Long.parseLong(st.nextToken());
		}
		dist[sCity] = cityMoney[sCity]; 
		for(int i = 0; i <= N+100; i++) {
			for(int j = 0; j < M; j++) {
				int start = edges[j].start;
				int end = edges[j].end;
				int price = edges[j].price;
				if(dist[start] == Long.MIN_VALUE) continue;
				else if(dist[start] == Long.MAX_VALUE) {
					dist[end] = Long.MAX_VALUE;
				}
				else if(dist[end] < dist[start] + cityMoney[end] - price) {
					dist[end] = dist[start] + cityMoney[end] - price;
					if(i >= N-1) dist[end] = Long.MAX_VALUE;
				}
			}
		}
		if(dist[eCity] == Long.MIN_VALUE) System.out.println("gg");
		else if(dist[eCity] == Long.MAX_VALUE) System.out.println("Gee");
		else System.out.println(dist[eCity]);
	}
}
