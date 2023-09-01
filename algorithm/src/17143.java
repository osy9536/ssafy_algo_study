package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 낚시왕
// gold 1
public class b17143 {
	
	static class Shark implements Comparable<Shark>{
		int r,c,s,d,z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Shark o) {
			if(this.c==o.c)return this.r-o.r;
			return this.c-o.c;
		}
	}
	
	static int[][] map;
	static int[][] shark;
	static int R,C,M;
	static List<Shark> list;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 맵 크기 x
		C = Integer.parseInt(st.nextToken()); // 맵 크기 y
		M = Integer.parseInt(st.nextToken()); // 상어의 수
		map = new int[R][C];
		answer = 0;
		for(int i = 0; i<R; i++) {
			Arrays.fill(map[i], -1);
		}
		shark = new int[M][5];
		list = new ArrayList<>();
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1; // 위치 x
			int c = Integer.parseInt(st.nextToken())-1; // 위치 y
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()); // 이동 방향 (1:위,2:아래,3:오른,4:왼)
			int z = Integer.parseInt(st.nextToken()); // 크기
			map[r][c] = i;
			shark[i][0]= r;
			shark[i][1]= c;
			shark[i][2]= s;
			shark[i][3]= d;
			shark[i][4]= z;
			
			list.add(new Shark(r, c, s, d, z));
		}
		Collections.sort(list);
		
		for(int i = 0; i<C; i++) {
			fishing(i);
			move();
			check();
		}
		System.out.println(answer);
	}
	static void fishing(int idx) {
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).c==idx) {
				answer+=list.get(i).z;
				list.remove(i);
				i--;
				break;
			}
		}
	}
	static void move() {
		for(int i = 0; i<list.size(); i++) {
			int s = list.get(i).s;
			while(s>0) {
				if(list.get(i).d==1) {
					if(list.get(i).r==0) {
						list.get(i).d=2;
						list.get(i).r+=1;	
					}else {
						list.get(i).r-=1;
					}
				}else if(list.get(i).d==2) {
					if(list.get(i).r==R-1) {
						list.get(i).d=1;
						list.get(i).r-=1;	
					}else {
						list.get(i).r+=1;
					}
				}else if(list.get(i).d==3) {
					if(list.get(i).c==C-1){
						list.get(i).d=4;
						list.get(i).c-=1;
					}else {
						list.get(i).c+=1;
					}
				}else if(list.get(i).d==4) {
					if(list.get(i).c==0){
						list.get(i).d=3;
						list.get(i).c+=1;
					}else {
						list.get(i).c-=1;
					}
				}
				s--;
			}
		}
		Collections.sort(list);
	}
	static void check() {
		int cnt = 0;
		while(cnt<list.size()-1) {
			if(list.size()>1) {
				if(list.get(cnt).c==list.get(cnt+1).c&&list.get(cnt).r==list.get(cnt+1).r) {
					if(list.get(cnt).z>list.get(cnt+1).z){
						list.remove(cnt+1);
					}else {
						list.remove(cnt);
					}
				}else {
					cnt++;
				}
			}
		}
	}
}
