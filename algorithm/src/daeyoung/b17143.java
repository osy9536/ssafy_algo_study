package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 17143
 * 낚시왕
 * 골드 1
 * https://www.acmicpc.net/problem/17143
 */
public class b17143 {
	
	static int r;
	static int c;
	static int[][] map;
	static int[][] shark; // 속력, 이동방향, 크기
	static int m; //상어 수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		for(int i = 0 ; i < r; i++) {
			for(int j = 0; j < c; j++)
				map[i][j] = -1;
		}
		
		shark = new int[m][3];
		//상어 위치, 속력, 이동방향, 크기
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = i;
			shark[i][0] = Integer.parseInt(st.nextToken()); // 속력
			shark[i][1] = Integer.parseInt(st.nextToken()); // 이동방향 - 1 위 2 아래 3 오른쪽 4 왼쪽
			shark[i][2] = Integer.parseInt(st.nextToken()); // 크기
		}
		
		System.out.println(hunting());
	}
	
	public static int hunting() {
		int sum = 0;
		int cur = -1;
		
		while(cur < c - 1) {
			cur += 1; //사냥꾼 오른쪽 한칸 이동
			
			//땅에서 제일 가까운 상어 사냥
			for(int i = 0; i < r; i++) {
				if(map[i][cur] != -1) {
					sum += shark[map[i][cur]][2]; //상어 크키 더하기
					map[i][cur] = -1; //상어 격자판에서 out
					break;
				}
			}
			
			int[][] temp = new int[r][c];
			for(int i = 0 ; i < r; i++) {
				for(int j = 0; j < c; j++)
					temp[i][j] = -1;
			}
			
			//상어 이동
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(map[i][j] != -1) {
						int v = shark[map[i][j]][0]; //상어 속력
						int d = shark[map[i][j]][1]; //상어 이동방향
						
						if(d == 1) {
							int index = Math.abs(i - v);
							int share = index / (r - 1); //몫
							int remain = index % (r - 1); //나머지
							
							
							
							
							if(share % 2 == 1) {
								index = r - 1 - remain;
								
							} else {
								index = remain;
								if(i - v < 0)
									shark[map[i][j]][1] = 2;
							}
							
							//상어가 이미 있다면
							if(temp[index][j] != - 1 && shark[map[i][j]][2] < shark[temp[index][j]][2]) {
								continue;
							}
							
							temp[index][j] = map[i][j];
							
						} else if(d == 2) {
							int index = i + v;
							
							int share = index / (r - 1); //몫
							int remain = index % (r - 1); //나머지
							
							if(share % 2 == 1) {
								index = r - 1 - remain;
								shark[map[i][j]][1] = 1;
							} else {
								index = remain;
							}
							
							//있는 상어가 크기가 더 크다면 
							if(temp[index][j] != - 1 && shark[map[i][j]][2] < shark[temp[index][j]][2]) {
								continue;
							}
							
							//상어가 없거나, 지금 상어가 더 큰 경우 업데이트
							temp[index][j] = map[i][j];
							
						} else if(d == 3) {
							int index = j + v;
							
							int share = index / (c - 1); //몫
							int remain = index % (c - 1); //나머지
							
							if(share % 2 == 1) {
								index = c - 1 - remain;
								shark[map[i][j]][1] = 4;
							} else {
								index = remain;
							}
							
							//상어가 이미 있다면
							if(temp[i][index] != - 1 && shark[map[i][j]][2] < shark[temp[i][index]][2]) {
								continue;
							}
							
							temp[i][index] = map[i][j];
							
						} else if(d == 4) {
							int index = Math.abs(j - v);
							
							int share = index / (c - 1); //몫
							int remain = index % (c - 1); //나머지
							
							
							
							if(share % 2 == 1) {
								index = c - 1 - remain;
								
							} else {
								index = remain;
								if(j - v < 0)
									shark[map[i][j]][1] = 3;
							}
							
							//상어가 이미 있다면
							if(temp[i][index] != - 1 && shark[map[i][j]][2] < shark[temp[i][index]][2]) {
								continue;
							}
							
							temp[i][index] = map[i][j];
						}
					}
				}
			}
			
			//이동된 상어 map에 반영하기
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					map[i][j] = temp[i][j];
//					System.out.print(map[i][j] + " ");
				}
//				System.out.println();
			}
//			for(int i = 0; i < m; i++)
//				System.out.println(shark[i][0] + " " + shark[i][1] + " " +
//			shark[i][2]);
//			
//			System.out.println();
		}
		
		return sum;
	}
}
