package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location{
	int x,y;
	Location(int i, int j){
		super();
		this.x = i;
		this.y = j;
	}
}
public class b7562 {
	static boolean[][] Map;
	static int N,count=1;
	static Location Start,Desti;
	static Queue<Location> q = new LinkedList<>();
	static int[][] d = {{-2,-1},{-2,1},{-1,2},{+1,2},{2,-1},{2,1},{-1,-2},{1,-2}};
	public static void BFS() {
		count =0;
		here : while(true) {
			int qsize = q.size(); 
			for(int i = 0 ; i < qsize ; i++) {
				if(q.peek().x==Desti.x && q.peek().y == Desti.y)
					break here;
				for(int j = 0; j < 8 ; j ++) {
					if(q.peek().x+d[j][0] < N && q.peek().x+d[j][0]>=0 && q.peek().y+d[j][1] < N && q.peek().y+d[j][1]>=0 ) {
						if(!Map[q.peek().x+d[j][0]][q.peek().y+d[j][1]]) {
							Map[q.peek().x+d[j][0]][q.peek().y+d[j][1]]=true;
							q.add(new Location(q.peek().x+d[j][0],q.peek().y+d[j][1]));
						}
					}
				}
				q.poll();
			}
			count ++;
		}
		q.clear();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0 ; t < tc ; t++) {
			N = Integer.parseInt(br.readLine());
			Map = new boolean[N][N];
			StringTokenizer start = new StringTokenizer(br.readLine());
			Start = new Location(Integer.parseInt(start.nextToken()), Integer.parseInt(start.nextToken()));
			StringTokenizer desti = new StringTokenizer(br.readLine());
			Desti = new Location(Integer.parseInt(desti.nextToken()), Integer.parseInt(desti.nextToken()));
			q.add(Start);
			BFS();
			System.out.println(count);
		}
	}
}


