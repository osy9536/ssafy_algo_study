package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class b7576 { 
	static int n;
	static int m;
    static int[][] tomato;
    static int result;
    
    static int[][] dr = {{0,1,0,-1}, {1,0,-1,0}};
    
    static boolean isOut(int y, int x) {
    	return y < 0 || y >= m || x < 0 || x >= n;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		tomato = new int[m][n];
		Set<int[]> igtomato = new HashSet<>();
		int alltomato = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 0) alltomato++;
				if (tomato[i][j] == 1) igtomato.add(new int[] {i,j});
			}
		}
		
		int day = 0;
		boolean con = true;
		if (alltomato == 0) con = false;
		Set<int[]> next = new HashSet<>();
		
		while (con) {
			day++;
			int lastcnt = alltomato;
			next.clear();
			for (int[] i : igtomato) {
				
				for (int j = 0; j < 4; j++) {
					int y = i[0] + dr[0][j];
					int x = i[1] + dr[1][j];
					if (isOut(y,x) || tomato[y][x] != 0) continue;
					tomato[y][x] = 1;
					alltomato--;
					next.add(new int[] {y,x});
				}
			}
			
			igtomato.clear();
			igtomato.addAll(next);
			
			if (alltomato == 0) {
				result = day;
				con = false;
				break;
			}
			if (lastcnt == alltomato) {
				result = -1;
				con = false;
				break;
			}
		}
        
        
        System.out.println(result);
	}
}
