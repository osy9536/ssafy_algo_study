package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// [S/W 문제해결 기본] 10일차 - Contact
public class s1238 {
	static int N;
	static ArrayList<Integer>[] lists;
	static StringBuilder sb;
	static List<Answer> answer;
	static boolean[] visited;
	static class BFS{
		List<Integer> list;
		int depth;
		BFS(List<Integer> list, int depth){
			this.list= list;
			this.depth =depth;
		}
	}
	
	static class Answer implements Comparable<Answer>{
		int num;
		int depth;
		Answer(int  num, int depth){
			this.num = num;
			this.depth = depth;
		}
		@Override
		public int compareTo(Answer o) {
			if(this.depth==o.depth) {
				return o.num-this.num;
			}
			return o.depth-this.depth;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			lists = new ArrayList[101];
			sb= new StringBuilder();
			answer = new ArrayList<>();
			visited = new boolean[101];
			
			for(int i=0; i<101;i++) {
				lists[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				lists[a].add(b);
			}
			sb.append("#"+tc+" ");
			bfs(start);
			Collections.sort(answer);
			System.out.println("#"+tc+" "+answer.get(0).num);
		}
	}

	static void bfs(int idx) {
		Queue<BFS> q = new LinkedList<>();
		q.add(new BFS(lists[idx],0));
		while (!q.isEmpty()) {
			BFS now = q.poll();
			for(int i = 0; i<now.list.size(); i++) {
				if(!visited[now.list.get(i)]) {
					visited[now.list.get(i)] = true;
					answer.add(new Answer(now.list.get(i),now.depth));
					q.add(new BFS(lists[now.list.get(i)],now.depth+1));
				}
			}
		}
	}
}
