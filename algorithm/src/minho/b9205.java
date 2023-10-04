package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Locate{
	int x , y;

	public Locate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class Main {
	
	static int TC;
	static Locate[] locate;
	static boolean[] check;
	static Locate start,goal;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	
	public static void BFS() {
		Queue<Locate> q = new ArrayDeque<>();
		q.add(start);
		while(!q.isEmpty()) {
			
			int qsize = q.size();
			Locate l = q.poll();
			
			if(Math.abs(goal.x - l.x)+Math.abs(goal.y - l.y)<=1000) {
				System.out.println("happy");
				return;
			}
				
			for(int i = 0 ; i < qsize ; i++) {
			
				for(int j = 0 ; j < locate.length; j++) {
					
					int lx = Math.abs(locate[j].x - l.x);
					int ly = Math.abs(locate[j].y - l.y);
					
					if(lx+ly<=1000 && !check[j]) {
						
						q.add(locate[j]);
						check[j]=true;
						
					}
				}
			}
		}
		System.out.println("sad");
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		
		for(int t = 0 ; t < TC ; t++) {
					
			int N = Integer.parseInt(br.readLine());
			
			locate = new Locate[N];
			check = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = new Locate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				locate[i] = new Locate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			goal = new Locate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			BFS();
		}
	}
}
/*
1
2
0 0
1000 5
2000 10
3000 15
 */
