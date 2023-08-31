package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b13460 { // 구슬 탈출 2, 풀지 마세요................
	static int n;
	static int m;
	static String[] pan;
	
	static int[][] dr = new int[][] {{0,1,0,-1}, {1,0,-1,0}};
	
	public static boolean isOut(int y, int x) {
		if (y <= 0 || y >= n-1 || x <= 0 || x >= m-1) return true;
		return false;
	}
	
	public static int[][] rollMarble(int[] red, int[] blue, int direc) {
		int rGoal = -1;
		int bGoal = -1;
		
		int ry = red[0];
		int rx = red[1];
		
		int by = blue[0];
		int bx = blue[1];
		
		if (direc == 0) {
			for (int i = red[1]+1; i < m; i++) {
				if (pan[red[0]].charAt(i) == '#') {
					rx = i-1;
					break;
				} else if (pan[red[0]].charAt(i) == 'O') {
					rGoal = 1;
					rx = i;
					break;
				}
			}
			for (int i = blue[1]+1; i < m; i++) {
				if (pan[blue[0]].charAt(i) == '#') {
					bx = i-1;
					break;
				} else if (pan[blue[0]].charAt(i) == 'O') {
					bGoal = 1;
					bx = i;
					break;
				}
			}
			if (red[0] == blue[0] && rx == bx) {
				if (red[1] > blue[1]) bx--;
				else rx--;
			}
			
		} else if (direc == 1) { ///////////////////////////////////////////
			for (int i = red[0]+1; i < n; i++) {
				if (pan[i].charAt(red[1]) == '#') {
					ry = i-1;
					break;
				} else if (pan[i].charAt(red[1]) == 'O') {
					rGoal = 1;
					ry = i;
					break;
				}
			}
			for (int i = blue[0]+1; i < n; i++) {
				if (pan[i].charAt(blue[1]) == '#') {
					by = i-1;
					break;
				} else if (pan[i].charAt(blue[1]) == 'O') {
					bGoal = 1;
					by = i;
					break;
				}
			}
			if (red[1] == blue[1] && ry == by) {
				if (red[0] > blue[0]) by--;
				else ry--;
			}
		} else if (direc == 2) { ////////////////////////////////////////////
			for (int i = red[1]-1; i >= 0; i--) {
				if (pan[red[0]].charAt(i) == '#') {
					rx = i+1;
					break;
				} else if (pan[red[0]].charAt(i) == 'O') {
					rGoal = 1;
					rx = i;
					break;
				}
			}
			for (int i = blue[1]-1; i >= 0; i--) {
				if (pan[blue[0]].charAt(i) == '#') {
					bx = i+1;
					break;
				} else if (pan[blue[0]].charAt(i) == 'O') {
					bGoal = 1;
					bx = i;
					break;
				}
			}
			if (red[0] == blue[0] && rx == bx) {
				if (red[1] > blue[1]) rx++;
				else bx++;
			}
			
		} else if (direc == 3) { ////////////////////fuck you///////////////////////
			for (int i = red[0]-1; i >= 0; i--) {
				if (pan[i].charAt(red[1]) == '#') {
					ry = i+1;
					break;
				} else if (pan[i].charAt(red[1]) == 'O') {
					rGoal = 1;
					ry = i;
					break;
				}
			}
			for (int i = blue[0]-1; i >= 0; i--) {
				if (pan[i].charAt(blue[1]) == '#') {
					by = i+1;
					break;
				} else if (pan[i].charAt(blue[1]) == 'O') {
					bGoal = 1;
					by = i;
					break;
				}
			}
			if (red[1] == blue[1] && ry == by) {
				if (red[0] > blue[0]) ry++;
				else by++;
			}
		}
		
		return new int[][] {new int[] {ry,rx}, new int[] {by,bx}, new int[] {rGoal, bGoal}};
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int result = -1;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		pan = new String[n];
		int[] red = new int[2];
		int[] blue = new int[2];
		
		for (int i = 0; i < n; i++) {
			pan[i] = br.readLine();
			for (int j = 0; j < m; j++) {
				if (pan[i].charAt(j) == 'R') {
					red[0] = i;
					red[1] = j;
				} else if (pan[i].charAt(j) == 'B') {
					blue[0] = i;
					blue[1] = j;
				}
			}
		}
		
		Queue<int[][]> que = new LinkedList<int[][]>();
		Queue<Integer> cntque = new LinkedList<>();
		
		que.add(new int[][] {red, blue});
		cntque.add(0);
		
		while (!que.isEmpty()) {
			int[][] nnow = que.poll();
			int[] r = nnow[0];
			int[] b = nnow[1];
			int cnt = cntque.poll();
			if (cnt >= 10) continue;
			
			for (int i = 0; i < 4; i++) {
				int[][] rollResult = rollMarble(r, b, i);
				int[] rollr = rollResult[0];
				int[] rollb = rollResult[1];
				int[] rollg = rollResult[2];
				
				if (rollr[0] == r[0] && rollr[1] == r[1] && rollb[0] == b[0] && rollb[1] == b[1]) continue;
				if (rollg[1] == 1) continue;
				if (rollg[0] == 1) {
					result = cnt+1;
					que.clear();
					break;
				} else {
					que.add(new int[][] {rollr, rollb});
					cntque.add(cnt+1);
				}
				
			}
		}
		
		System.out.println(result);
	}
}
