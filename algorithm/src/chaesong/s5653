import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class s_jul {
	static int N, M, K;
	static PriorityQueue<Cell> pq; //일단 세포 다 담고 봐
	static List<Cell> cells;
	static boolean visit[][];
	static final int DEAD = 0, ACTIVE = 1, INACTIVE = 2;
	static int dir[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //세로크기
			M = Integer.parseInt(st.nextToken()); //가로크기
			K = Integer.parseInt(st.nextToken()); //시간
			pq = new PriorityQueue<>((p1, p2)-> p2.live-p1.live); //내림차순 정렬
			cells = new ArrayList<>();
			visit = new boolean[N+2*K][M+2*K];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					int now = Integer.parseInt(st.nextToken());
					if(now != 0) {
						cells.add(new Cell(i+K, j+K, now, now)); //세포라면 넣어주기  
						visit[i+K][j+K] = true; //방문처리
					}
				}
			}
			bfs();
			System.out.println("#"+t+" "+count());
		}
	}
	//세포정보 저장
	static class Cell{
		int y, x, time, status, live;
		//status 1: able, -1: disable
		public Cell(int y, int x, int time, int live) {
			this.y = y;
			this.x = x;
			this.time = time;
			this.live = live;
			this.status = INACTIVE;
		}
	}
	//활성화+비활성화 세포 개수 세기
	static int count() {
		int cnt = 0;
		for(int i = 0; i < cells.size(); i++) {
			if(cells.get(i).status == ACTIVE || cells.get(i).status == INACTIVE) cnt++;
		}
		return cnt;
	}
	//배양하기
	static void bfs() {
		for(int t = 1; t <= K; t++) {
			while(!pq.isEmpty()) {
				Cell c = pq.poll();
				int y = c.y;
				int x = c.x;
				if(!visit[y][x]) { 
					//높은 생명력을 가진 애가 먼저 들어와서 방문 처리 했을 거니까
					//뒤에 애는 방문하면 안됨
					visit[y][x] = true;  
					cells.add(c); //새로 생긴 세포 더해주기
				}
			}
			for(int i = 0; i < cells.size(); i++) {
				if(cells.get(i).status == DEAD) continue; //죽은 세포라면 패스
				//이제 활성화 되어야 하는 애들
				else if(cells.get(i).status == INACTIVE && cells.get(i).time == t) {
					cells.get(i).status = ACTIVE;
					cells.get(i).time = t + cells.get(i).live; //활성화 되고 나면 생명력 시간 뒤엔 죽을 것
					for(int k = 0; k < 4; k++) {
						int ny = cells.get(i).y + dir[k][0]; //세포 만들고 넣어주기
						int nx = cells.get(i).x + dir[k][1]; 
						//새로 만든 세포는 pq에 넣어주기
						//현재 시간+1(세포 증식하는 시간)+자기 생명력 만큼 살아있다 죽을 것 
						pq.add(new Cell(ny, nx, t+1+cells.get(i).live, cells.get(i).live));
					}
				}
				else if(cells.get(i).status == ACTIVE && cells.get(i).time == t) {
					cells.get(i).status = DEAD;
					cells.get(i).time = 0;
					cells.get(i).live = 0;
				}
			}
		}
	}
}
