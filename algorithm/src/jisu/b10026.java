package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class b10026 {
	
	public static boolean isin(int[] japyo, int n) {
		for (int i = 0; i < 2; i++) {
			if (japyo[i]<0 || japyo[i] >= n) return false;
		} 
		
		return true;
	}
	
	public static boolean isSame(String[] picture, int[] origin, int[] cpfor, boolean rgPerson) {
		Set<Character> rgrg = new HashSet<Character>(Arrays.asList(new Character[] {'R', 'G'}));
		Character o = picture[origin[0]].charAt(origin[1]);

		Character c = picture[cpfor[0]].charAt(cpfor[1]);
		rgrg.add(o);
		rgrg.add(c);
		
		if (o == c) {
			return true;
		} else if (rgPerson && rgrg.size()==2){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] picture = new String[n];
		
		for (int i = 0; i < picture.length; i++) {
			picture[i] = br.readLine();
		}
		
		int[][] acvisit = new int[n][n];
		int[][] rgvisit = new int[n][n];
		
		
		Queue<int[]> acque = new LinkedList<int[]>();
		Queue<int[]> rgque = new LinkedList<int[]>();
		
		int[][] dr = {{0,1,0,-1},{1,0,-1,0}};
		int ac = 0;
		int rg = 0;
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!(acvisit[i][j] == 1)) {
					acque.add(new int[] {i, j});
					ac++;
					while(!acque.isEmpty()) {
						int[] now = acque.poll();
						for (int k = 0; k < 4; k++) {
							int y = now[0] + dr[0][k];
							int x = now[1] + dr[1][k];
							int[] cpfor = new int[] {y,x};
							if (!isin(cpfor, n) || acvisit[y][x] == 1 || !isSame(picture, now, cpfor, false)) continue;
							acque.add(cpfor);
							acvisit[y][x] = 1;
							
						}
					}
				}
				
				if (!(rgvisit[i][j]==1)) {
					rgque.add(new int[] {i, j});
					rg++;
					while(!rgque.isEmpty()) {
						int[] now = rgque.poll();
						for (int k = 0; k < 4; k++) {
							int y = now[0] + dr[0][k];
							int x = now[1] + dr[1][k];
							int[] cpfor = new int[] {y,x};
							if (!isin(cpfor, n) || rgvisit[y][x] == 1 || !isSame(picture, now, cpfor, true)) continue;
							rgque.add(cpfor);
							rgvisit[y][x] = 1;
							
							
						}
					}
				}
				
			}
		}
		
		
		System.out.println(ac+" "+rg);
	}
}
