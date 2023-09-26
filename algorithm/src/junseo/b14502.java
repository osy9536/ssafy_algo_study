package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b14502 {
	
	static int N,M;
	static int[][] arr;
	static List<int [] > list;
	static int[] dx = {-1,1,0,0}; //상하좌우
	static int[] dy = {0,0,-1,1};
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					list.add(new int[] {i,j});
				}
			}
		}
		res = 0;
		creatW(0);	
		System.out.println(res);
	}

	private static void creatW(int cnt) {
		if(cnt >= 3) {
			bfs();	
			cal();
			back();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					creatW(cnt+1);
					arr[i][j] = 0;
				}
			}
		}
		
	}

	private static void back() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 2) {
					for (int k = 0; k < list.size(); k++) {
						if(list.get(k)[0]==i && list.get(k)[1] == j) {
							arr[i][j] = 2;
							break;
						}
						arr[i][j] = 0;
					}
				}
			}
		}
	}

	private static void cal() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					sum++;
				}
			}
		}
		res = Math.max(res, sum);
	}

	private static void bfs() {
		for (int i = 0; i < list.size(); i++) {
			Queue<int []> queue = new ArrayDeque<>();
			queue.add(new int[] {list.get(i)[0],list.get(i)[1]});
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				int x = cur[0];
				int y = cur[1];
				
				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(nx>=0 && nx<N && ny>=0 && ny<M && arr[nx][ny] ==0) {
						arr[nx][ny] = 2;
						queue.add(new int[] {nx,ny});
						//System.out.println(";;;;;");
					}
				}
			}
		}	
		
	}
}


