package algorithm.src.minho;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b16940 {

	static int N;
	static ArrayList<Integer>[] list;
	static int[] answer;
	static boolean[] isVisited;

	public static boolean BFS() {
		boolean ck = true;
		int count = 1;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		isVisited[1] = true;
		while (!q.isEmpty()) {
			int end = count;
			int cnt = q.poll();
			int lsize = list[cnt].size();
			for (int i = 0; i < lsize; i++) {
				if (!isVisited[list[cnt].get(i)] && answer[count] == list[cnt].get(i)) {
					isVisited[list[cnt].get(i)] = true;
					q.add(answer[count]);
					count++;
					i = -1;
				}
			}
			if (end = count)
				break;
		}
		if (count == N)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		answer = new int[N];
		isVisited = new boolean[N + 1];
		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}

		if (BFS())
			System.out.println(1);
		else
			System.out.println(0);

	}
}
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b16940 {
	static int n; 
	static int index;
	static ArrayList<HashSet<Integer>> list; 
	static int[] visit; 
	static int[] answer; 
	static Queue<Integer> queue; 
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		visit = new int[n + 1];
		answer = new int[n + 1];
		queue = new LinkedList<Integer>();
		
		
		for(int i = 0; i <= n; i++) {
			list.add(new HashSet<>());
		}
		
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			list.get(index).add(value);		
			list.get(value).add(index);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		
		if(answer[1] != 1) {
			System.out.println("0");
			return;
		}

		bfsCheck(1);
	
 	}
	
	public static void bfsCheck(int x) {
		queue.offer(x);
		visit[x] = 1;
		index = 2;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
		
			int count = 0;
			for(int next : list.get(cur)) {
				if(visit[next] == 0) {
					visit[next] = 1;
					count++;
				}
			}
			
			for(int i = index; i < index + count; i++) {	
				
				if(visit[answer[i]] == 0) {
					System.out.println("0");
					return;
				}
				
				else {
					queue.offer(answer[i]);
				}		
			}
			index += count;
		}
		System.out.println("1");
	}
}
/*
11
2 1
2 5
4 3
4 7
1 4
5 6
8 10
8 9
9 11
6 8
2 5 1 6 4 8 3 7 9 10 11
 */
