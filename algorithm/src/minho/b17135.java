package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x, y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class b17135{
	static int[][] Map, copyMap;
	static int[] where = new int[3];
	static int[][] delete = new int[3][2];
	static boolean[][] isVisited;
	static ArrayList<Integer> listx = new ArrayList<>();
	static ArrayList<Integer> listy = new ArrayList<>();
	static int answer = 0, ans , N, M ,D;
	static int[] dx = {0,-1,0}, dy = {-1,0,1};
	public static void findMax() {
		ans = (ans < answer) ? answer: ans;
	}
	public static void makeCopy(int N) {
		for(int i = 0 ; i < N ; i++) {
			copyMap[i] = Map[i].clone();
		}
	}
	public static void find(int x,int y) { 
		int dis=1;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		here : while(!q.isEmpty()) {
			int qsize= q.size();
			dis++;
			for(int i =0; i<qsize; i++) {
				Point cul = q.poll();
				if(dis>D) break here;
				for(int j = 0 ; j < 3 ; j++) { //방향
					if( (cul.x+dx[j]) >= 0 && cul.x+dx[j] < N && (cul.y+dy[j]) >= 0 && (cul.y+dy[j]) < M ) {
						if(copyMap[cul.x+dx[j]][cul.y+dy[j]]==1) {
							q.add(new Point(cul.x+dx[j],cul.y+dy[j]));
							listx.add(cul.x+dx[j]);
							listy.add(cul.y+dy[j]);
							break here;
						}
						else if(copyMap[cul.x+dx[j]][cul.y+dy[j]]==0 && !isVisited[cul.x+dx[j]][cul.y+dy[j]]) {
							isVisited[cul.x+dx[j]][cul.y+dy[j]]=true;
							q.add(new Point(cul.x+dx[j],cul.y+dy[j]));
						}
					}
				}
			}
		}
	}
	public static void deleteEnemy() {
		for(int i = 0 ; i < listx.size(); i++) {
			if(copyMap[listx.get(i)][listy.get(i)]==1) {
				answer++;
				copyMap[listx.get(i)][listy.get(i)]=0;
			}
		}
	}
	public static void lineDown() {
		for(int i=N-2; i>=0;i--) {
			copyMap[i+1]= copyMap[i].clone();
		}
		for(int i = 0 ; i < M ; i++) {
			copyMap[0][i]=0;
		}
	}
	public static void permutation(int cnt,int start, int line,boolean[] ck,int N) {
		if(cnt==3) {
			answer=0;
			makeCopy(N);
			for(int t = 0 ; t < N ; t++) { // N줄마다
				isVisited = new boolean[N][M];
				for(int i = 0 ; i < 3 ; i++) { // 궁수위치마다
					if(copyMap[N-1][where[i]]==1){
						listx.add(N-1);
						listy.add(where[i]);
					}else find(N-1,where[i]);
				}
				deleteEnemy();
				lineDown();
				listx.clear();
				listy.clear();
			}
			findMax();
			return;
		}
		for(int i = start ; i < line ; i++) {
			if(!ck[i]) {
				ck[i]=true;
				where[cnt] = i;
				permutation(cnt+1,i+1,line,ck,N);
				ck[i]=false;
			}
		}
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        Map = new int[N][M];
        copyMap = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
        	StringTokenizer str = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M ; j++) {
        		Map[i][j] = Integer.parseInt(str.nextToken());
        	}
        }
        //입력 끝
        boolean[] ck = new boolean[M];
        Arrays.fill(ck, false);
        permutation(0,0,M,ck,N);
        System.out.println(ans);
    }
}