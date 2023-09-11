package algorithm.src.minho;
/*
import java.io.*;
import java.util.*;

class Lo {
    int x,y;
    public Lo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N,M,ans=0;
    static int[][] map;
    static boolean[][] check;
    static int[] dx= {-1,0,1,0};
    static int[] dy= {0,1,0,-1};
    public static void BFS() {
        Queue<Lo> q = new LinkedList<>();
        q.add(new Lo(0,0));
        while(!q.isEmpty()){
            int qsize = q.size();
            for(int i = 0 ; i < qsize; i++){
                Lo l = q.poll();
                int sum=map[l.x][l.y];
                for(int d = 0 ; d < 4 ; d++){
                    if(l.x+dx[d]>=0 && l.x+dx[d] < N && l.y+dy[d]>=0 && l.y+dy[d]<M) {
                        q.add(new Lo(l.x+dx[d],l.y+dy[d]));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new boolean[N][M];
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

    }
}
// DFS로풀었을 때 십자가 탐색이 안되서
// BFS로 풀어봤는데
// BFS에서는 순차 누적 합 구하기가 힘들어서 결국
// 다시 DFS로 돌아와서 각칸돌때마다 양사이드 십자가 다 더해주고 for 4 까지 돌리면서
// dx dy 하나씩 빼보면서 맥스값과 큰가 작은가를 대소비교
// 중간중간에 종료조건 추가로 시간 단축해봄
*/
import java.io.*;
import java.util.*;

public class b14500{
    static int N,M,ans=0;
    static int[][] map;
    static boolean[][] check;
    static int[] bx= {-1,0,1,0};
    static int[] by= {0,1,0,-1};
    public static void DFS(int x,int y,int cnt,int sum) {
        if(cnt==5) {
            if(ans<sum) ans=sum;
            return;
        }
        for(int d=0; d<4; d++) {
            if(x+bx[d]>=0 && x+bx[d]<N && y+by[d]>=0 && y+by[d]<M) {
                if(!check[x+bx[d]][y+by[d]]) {
                    check[x+bx[d]][y+by[d]]=true;
                    sum+=map[x+bx[d]][y+by[d]];
                    DFS(x+bx[d],y+by[d],cnt+1,sum);
                    sum-=map[x+bx[d]][y+by[d]];
                    check[x+bx[d]][y+by[d]]=false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new boolean[N][M];
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        boolean flag = false;
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                flag=false;
                DFS(i,j,1,0);
                int sum1=map[i][j], cnt=0;
                for(int k = 0 ; k < 4 ; k++) {
                    if(cnt>=2) {
                        flag=true;
                        break;}
                    if(i+bx[k]>=0 && i+bx[k]<N && j+by[k]>=0 && j+by[k]<M) {
                        sum1+=map[i+bx[k]][j+by[k]];
                        continue;
                    }
                    cnt++;
                }
                if(flag) continue;
                if(sum1>ans && cnt==0) {
                    for(int k = 0 ; k < 4 ; k++) {
                        if(i+bx[k]>=0 && i+bx[k]<N && j+by[k]>=0 && j+by[k]<M) {
                            if(ans<sum1-map[i+bx[k]][j+by[k]])
                                ans=sum1-map[i+bx[k]][j+by[k]];
                        }
                    }
                }
                else if(sum1>ans && cnt==1)
                    ans=sum1;
            }
        }
        System.out.println(ans);
    }
}