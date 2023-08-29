package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 17281
 * 야구
 * 골드 4
 * https://www.acmicpc.net/problem/17281
 */
public class b17281 {
	
	static int n;
	static int[][] result;
	static int max = Integer.MIN_VALUE; //최대 점수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //이닝 수
		
		result = new int[n][9];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] output = new int[9];
		boolean[] visited = new boolean[9];
		output[3] = 0;
		visited[0] = true;
		permutation(0, output, visited);
		
		System.out.println(max);
	}
	
	// 타순 정하기
	public static void permutation(int depth, int[] output, boolean[] visited) {
		if(depth == 3) {
			permutation(depth + 1, output, visited);
			return;
		}
			
		if(depth == 9) {
			// 득점 구하기
			int score = getScore(output);
			
			if(max < score) {
//				for(int i : output)
//					System.out.print(i + " ");
//				System.out.println();
				max = score;
//				System.out.println(max);
			}
				
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(visited[i])
				continue;
			
			visited[i]= true;
			output[depth] = i;
			permutation(depth + 1, output, visited);
			visited[i] = false;
		}
	}
	
	public static int getScore(int[] output) {
		int score = 0; // 득점
		int out = 0; // 아웃 수
		int next = 0; //다음 타자(output) 인덱스
		boolean[] roux = new boolean[3]; //각 루에 사람 존재 여부 판단
		
		//이닝 수에 따른 득점 계산
		for(int i = 0; i < n; i++) {
		
			//쓰리 아웃제
			while(out < 3) {
				if(next >= 9)
					next %= 9;
				
				int cur = result[i][output[next++]]; // 현재 이닝에서 뛰는 선수의 결과
				
				if(cur == 1) {
					if(roux[2])
						score++;
					for(int j = 2; j > 0; j--) {
						roux[j] = roux[j - 1];
					}
					roux[0] = true;
				} else if(cur == 2) {
					if(roux[2])
						score++;
					if(roux[1])
						score++;
					roux[2] = roux[0];
					roux[1] = true;
					roux[0] = false;
				} else if(cur == 3) {
					if(roux[2]) {
						roux[2]= false;
						score++;
					}
						
					if(roux[1]) {
						roux[1] = false;
						score++;
					}
						
					if(roux[0]) {
						roux[0] = false;
						score++;
					}
					
					roux[2] = true;
				} else if(cur == 4) {
					for(boolean b : roux)
						if(b)
							score++;
					roux[0] = false;
					roux[1] = false;
					roux[2] = false;
					score++;
				} else if(cur == 0) {
					out++;
				}
			}
			
			//out reset
			out = 0;
			
			//각 루 reset
			for(int j = 0; j < 3; j++)
				roux[j] = false;
			
		}
		
		return score;
	}
}
