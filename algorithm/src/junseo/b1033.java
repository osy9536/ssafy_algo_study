package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Node>[] list;
	static Long[] res;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		res = new Long[N];
		list  = new List[N]; 
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		long lcm = 1;
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a,b,p,q;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,p,q));
			list[b].add(new Node(a,q,p));
			
			lcm *= p*q/gcd(p,q); // 최소공배수를 구해서 모두 곱한 값을 구함 
			/* 최소공배수를 모두 곱한 값은 주어진 p,q를 모두 소인수로 가짐
			 * 해당 값을 기준으로 비율에 따른 모든 값을 구할 수 있음
			 */
		}
		//System.out.println(lcm);
		
		res[0] = lcm;
		BFS(0);
		long mgcd = res[0];
		for (int i = 1; i < N; i++) {
			mgcd = gcd(mgcd,res[i]);
		}
		//System.out.println(mgcd);
		for (int i = 0; i < N; i++) {
			System.out.print(res[i] / mgcd +" ");
		}
		
	}

	private static void BFS(int i) {
		boolean[] vis = new boolean[N];
		ArrayDeque<Integer> queue = new ArrayDeque();
		queue.add(i);
		vis[i] = true;
		while(!queue.isEmpty()) {	
			int cur = queue.poll();
			
			for (Node node : list[cur]) {
				if(!vis[node.getN()]) {
					int n,p,q;
					n = node.getN();
					queue.add(n);
					vis[n] = true;
					p = node.getP();
					q = node.getQ();
					res[n] = res[cur]*q/p;
				}				
			}		
		}
	}

	private static long gcd(long p, long q) {
		if(q == 0) return p;
		else {
			return gcd(q,p%q);
		}
	}
}
class Node{
	int n;
	int p;
	int q;
	public Node(int n, int p, int q) {
		this.n = n;
		this.p = p;
		this.q = q;
	}
	
	public int getN() {
		return n;
	}
	public int getP() {
		return p;
	}
	public int getQ() {
		return q;
	}
}

