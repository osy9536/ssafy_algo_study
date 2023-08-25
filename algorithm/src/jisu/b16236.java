package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b16236 {
	public static int n;
	public static int m;
	public static int[] fish = new int[7]; // 크기별 물고기 수
	public static int SIZE = 2;
	public static int[] shark; // 현재 상어 위치
	public static int[][] map;
	public static boolean[][] visit;
	public static int result;
	public static int eat = 0;
	
	public static int[][] dr = {{-1, 0, 0, 1}, {0, -1, 1, 0}}; // 상 왼 오 하
	
	public static boolean isout(int[] wv) {
		for (int i = 0; i < 2; i++) {
			if (wv[i] < 0 || wv[i] >= n) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean existFish() {
		for (int i = Math.min(6, SIZE-1); i > 0; i--) {
			if (fish[i] > 0) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		/*
		 * 큰 물고기 칸은 지나갈 수 없고, 작은 물고기만 취식 가능
		 * 먹을 수 있는 물고기가 더이상 없다면 엄마 상어 sos
		 * 가장 가까운 먹을 수 있는 물고기한테 감(최소 거리), 위왼 순서
		 * SIZE번 물고기를 먹으면 SIZE+=1
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					if (map[i][j] == 9) {
						shark = new int[] {i, j};
						map[i][j] = 0;
					}
					else {
						m++;
						fish[map[i][j]]++;
					}
				}
			}
		}
		
		PriorityQueue<int[]> que = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[2] == o2[2]) {
					if (o1[0] == o2[0]) {
						return o1[1]-o2[1]; // 3. 더 왼쪽
					}
					return o1[0]-o2[0]; // 2. 더 위쪽
				}
				return o1[2]-o2[2]; // 1. cnt가 빠른 거 먼저
			}
		});
		
		visit = new boolean[n][n];
		visit[shark[0]][shark[1]] = true;
		que.add(new int[] {shark[0], shark[1], 0});
		
		while (!que.isEmpty()) {
			int[] now = que.poll();
			int cnt = now[2];
			/*
			 * 물고기가 더이상 존재하지 않는다면(0이라면) result = cnt 넘기고 중지
			 * 먹을 수 있는 물고기가 더 이상 존재하지 않아도 똑같이 중지
			 * 같은 거리에 있으면 문제가 될 수 있다 => priorityque 사용하자
			 */
			if (0 < map[now[0]][now[1]] && map[now[0]][now[1]] < SIZE) {
				eat++;
				fish[map[now[0]][now[1]]]--;
				map[now[0]][now[1]] = 0;
				m--;
				que.clear();
				visit = new boolean[n][n];
				visit[now[0]][now[1]] = true;
				result=cnt; // 물고기가 존재하긴 하는데 갈 수 있는 길이 없는 경우 이것이 출력됨
				
				if (SIZE == eat) {
					SIZE++;
					eat = 0;
				}
			}
			if (m==0 || !existFish()) {
				result = cnt;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int y = now[0] + dr[0][i];
				int x = now[1] + dr[1][i];
				if (isout(new int[] {y,x}) || visit[y][x] || map[y][x] > SIZE) continue;
//				System.out.printf("%d now (%d %d) pre(%d %d) %d %d %b\n", cnt, now[0], now[1], y,x, m, SIZE, existFish());
				que.add(new int[] {y,x,cnt+1});
				visit[y][x] = true;
			}
		}
		
		System.out.println(result);
	}
}
