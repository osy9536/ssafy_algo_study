package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * 백준 15686
 * 치킨 배달
 * 골드5
 * https://www.acmicpc.net/problem/15686
 */
public class b15686 {
	
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//행렬 사이즈
		int n = Integer.parseInt(st.nextToken());
		
		//치킨집 최대 개수
		int m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		
		List<int[]> chickens = new ArrayList<>();
		for(int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					chickens.add(new int[] {i, j});
				}
			}
		}
		
		//치킨집 수 중에서 m개 선택하기 - 조합
		combi(chickens, new boolean[chickens.size()], m, 0, 0);
		
		System.out.println(min);
	}
	
	public static void combi(List<int[]> chickens, boolean[] visited, int m, int cur, int cnt) {
		if(cnt == m) {
			for(int i = 0 ; i < visited.length; i++) {
				if(visited[i])
					System.out.print(i + " ");
			}
			System.out.println();
			//치킨 거리 최솟값 구하기
			int tempMin = 0;
			int oneMin = 0;
			for(int i = 1; i < map.length; i++) {
				for(int j = 1; j < map.length; j++) {
					oneMin = Integer.MAX_VALUE;
					for(int k = 0; k < visited.length; k++) {
						if(!visited[k])
							continue;
						//한 집당 거리 최솟값 ㄱㅖ산
						if(map[i][j] == 1) {
							if(Math.abs(i - chickens.get(k)[0]) + Math.abs(j - chickens.get(k)[1]) < oneMin)
								oneMin = Math.abs(i - chickens.get(k)[0]) + Math.abs(j - chickens.get(k)[1]);
						}
					}
					if(oneMin != Integer.MAX_VALUE)
						tempMin += oneMin;
				}
				
			}
			
			if(tempMin < min)
				min = tempMin;
			
			return;
		}
		
		for(int i = cur; i < visited.length; i++) {
			visited[i] = true;
			combi(chickens, visited, m, i + 1, cnt + 1);
			visited[i] = false;
		}
	}

}
