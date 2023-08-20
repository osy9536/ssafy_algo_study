package algorithm.src.minho;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//빵집 3109번
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//빵집 3109번
public class b3109{
	static char[][] map;
	static int answer=0;
	static int R,C;
	static boolean ck = false;
	static Stack<int[]> stack = new Stack<>();
	public static void find(int x, int y) {
		if(y == C-1) { //탐색완료시
			answer++;
			ck=true;
			return ;
		}
		else if(x>=0 && y<C && x<R && y>=0 ){
			if(!ck && (x-1)>=0 && (y+1)<C && map[x-1][y+1]=='.') {
				map[x-1][y+1]='x';
				find(x-1,y+1);
			}
			if(!ck && (y+1)<C && map[x][y+1]=='.') {
				map[x][y+1]='x';
				find(x,y+1);
			}
			if(!ck && (y+1)<C && (x+1)<R && map[x+1][y+1]=='.') {
				map[x+1][y+1]='x';
				find(x+1,y+1);
			}
		}
		return;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0 ; i < R; i++) {
			String s = br.readLine();
			map[i]=s.toCharArray();
		}
		for(int i=0;i<R;i++) {
			ck=false;
			find(i,0);
		}
		System.out.println(answer);
	}	
}