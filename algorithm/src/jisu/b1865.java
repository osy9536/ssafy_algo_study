package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1865 {
	static class Node {
		int end;
		int weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Node>[] nodeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); 
			int M = Integer.parseInt(st.nextToken()); 
			int W = Integer.parseInt(st.nextToken()); 


			nodeList = new ArrayList[N + 1];

			for (int j = 1; j < N + 1; j++) {
				nodeList[j] = new ArrayList<>();
			}

			for (int j = 0; j < M + W; j++) {
				st = new StringTokenizer(br.readLine());

				int S = Integer.parseInt(st.nextToken()); 
				int E = Integer.parseInt(st.nextToken()); 

				int time = Integer.parseInt(st.nextToken());

				if (j < M) {

					nodeList[S].add(new Node(E, time));
					nodeList[E].add(new Node(S, time));
				} else {

					nodeList[S].add(new Node(E, -time));
				}
			}


			System.out.println(bellman(N) ? "YES" : "NO");
		}

	}

	public static boolean bellman(int n) {
		boolean isUpdate = false;
		int[] dist = new int[n + 1];

		Arrays.fill(dist, INF);
		dist[1] = 0;

		for (int i = 1; i < n; i++) {
			isUpdate = false;

			for (int j = 1; j <= n; j++) {
				for (Node node : nodeList[j]) {
					if (dist[j] != INF && dist[node.end] > dist[j] + node.weight) {
						dist[node.end] = dist[j] + node.weight;
						isUpdate = true;
					}
				}
			}

			if (!isUpdate) {
				break;
			}
		}


		if (isUpdate) {
			return true;
		}

		return false;
	}

}
