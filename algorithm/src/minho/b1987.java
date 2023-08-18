package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 // 알파벳 1987
public class b1987{
	static boolean[] isVisited = new boolean[26];
	static int MAX = Integer.MIN_VALUE;
	static int R,C,cnt=0;
	static char[][] map;
	static int[] dirx = {0,-1,0,1};
	static int[] diry = {-1,0,1,0};
	public static void f(int x, int y) {
		if(isVisited[map[x][y]-'A']) 
			return;
		cnt++;
		MAX =(MAX < cnt)? cnt : MAX;
		if(!isVisited[map[x][y]-'A']) {
			isVisited[map[x][y]-'A']=true;
			for(int i = 0 ; i < 4 ; i++) {
				if(x+dirx[i]>=0 && x+dirx[i]<R && y+diry[i]>=0 && y+diry[i]<C)
					f(x+dirx[i],y+diry[i]);
			}
		}
		cnt--;
		isVisited[map[x][y]-'A']=false;
		return ;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		String s;
		map = new char[R][C];
		for(int i = 0 ; i < R ; i++) {
			s=br.readLine();
			map[i] = s.toCharArray();
		}
		f(0,0);
		System.out.println(MAX);
	}
}