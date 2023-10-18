package algorithm.src.minho;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b18352 {
	static ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
	static int n,m,k,x;
	static int[] d=new int[300001]; 
	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		k=sc.nextInt();
		x=sc.nextInt();
		
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<Integer>());
			d[i]=-1; 
			}
		
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			graph.get(a).add(b);
		}
		
		d[x]=0; 
		Queue<Integer> q=new LinkedList<>();
		q.offer(x);
		while(!q.isEmpty()) {
			int now=q.poll();
			
			for(int i=0;i<graph.get(now).size();i++) {
				int next=graph.get(now).get(i);
				if(d[next]==-1) {
					d[next]=d[now]+1;
					q.offer(next);
				}
			}
		}
		
		boolean check=false;
		for(int i=1;i<=n;i++) {
			if(d[i]==k) {
				System.out.println(i);
				check=true;
			}
		}
		
		if(check==false)
			System.out.println(-1);
	}

}