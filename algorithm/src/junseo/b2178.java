package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2178_미로탐색 {
	
	static int N;
	static int M;
	static int[][] arr;
	static int[] dx = {-1,1,0,0}; //상하좌우 
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int[][] res;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st =  new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		res = new int[N][M];
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		////////////////////////////////////////////
		queue.offer(new int[] {0,0});
		visited[0][0] = true;
		res[0][0] = 1;
		while(!queue.isEmpty()) {
			int [] ar = queue.poll();
			if(ar[0] == N-1 && ar[1] ==M-1) {
				break;
			}
			//System.out.println(res[ar[0]][ar[1]]);
			//System.out.println(ar[0] +"ddvd" +ar[1]);
			for (int i = 0; i < 4; i++) {
				int nx = ar[0] + dx[i];
				int ny = ar[1] + dy[i];
				if(nx>=0 && ny>=0 && nx <N && ny < M && arr[nx][ny] != 0 && !visited[nx][ny]) {
					res[nx][ny] = res[ar[0]][ar[1]]+1;
					queue.offer(new int[] {nx,ny});
					visited[nx][ny] = true;
				}
				
			}
		}
		System.out.println(res[N-1][M-1]);
	}
}


