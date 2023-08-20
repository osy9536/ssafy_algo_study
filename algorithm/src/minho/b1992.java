package algorithm.src.minho;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//쿼드트리 1992번
public class b1992{
	static char[][] map;
	static boolean check=true;
	public static void partition(int n,int x, int y) {
		// 기저조건 if()
		if(check(x,y,n)) { 
			System.out.print(map[x][y]);
			return;
		}
		else {
			System.out.print("(");
			partition(n/2,x,y);
			partition(n/2,x,y+n/2);
			partition(n/2,x+n/2,y);
			partition(n/2,x+n/2,y+n/2);
			System.out.print(")");
		}
	}
	public static boolean check(int x, int y, int n) {
		char origin = map[x][y];
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(origin!=map[i][j]) {
					check=false;
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map= new char[n][n];
		for(int i = 0 ; i < n ; i++) {
			String s=br.readLine();
			map[i]=s.toCharArray();
			
		}
		//입력
		partition(n,0,0);
	}	
}