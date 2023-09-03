package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//왕이동
//같은열 상어잡기 크기count
//상어이동
class Shark {
    int r, c, s, d, z; //위치rc, 속력s, 이동방향d, 크기z
    public Shark(int r, int c, int s, int d, int z) {
        super();
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}
public class b17143 {

    static int R,C,M,count=0,where=-1; //낚시왕이 잡은 상어크기 합, 상어왕위치 
    static Shark[][] map;
    static int[] dx= {-1,1,0,0};
    static int[] dy= {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R][C];
        
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(r,c,s,d,z);
        } //입력
        Queue<Shark> q = new LinkedList<>();
        while(where<C-1) {
            where++; //왕이동
            for(int i = 0; i < R ; i++) {
                if(map[i][where] != null) {
                    count+=map[i][where].z;
                    map[i][where]=null;
                    break;
                }
            } //상어잡기
            for(int i = 0; i < R ; i++) {
            	for(int j = 0; j < C ; j++) {
            		if(map[i][j]!=null) {
            			q.add(new Shark(map[i][j].r,map[i][j].c,map[i][j].s,map[i][j].d,map[i][j].z));
            		}
            	}
            }
            map= new Shark[R][C];
            while(!q.isEmpty()) {
            	Shark sk = q.poll();
            	 int speed = sk.s; 
                 if(sk.d == 0 || sk.d == 1)
                     speed %= ((R -1) * 2); 
                 else if(sk.d == 2 || sk.d == 3)
                     speed %= ((C -1) * 2);
                 for(int s = 0; s < speed; s++) {
                     int newR = sk.r + dx[sk.d]; 
                     int newC = sk.c + dy[sk.d];
                     if(newR < 0 || newR >= R || newC < 0 || newC >= C) { 
                         sk.r -= dx[sk.d]; // 다시 값 돌려주고 
                         sk.c -= dy[sk.d];
                         if(sk.d == 0) sk.d=1;
                         else if(sk.d==1)sk.d = 0;
                         else if(sk.d==2)sk.d = 3;
                         else if(sk.d==3)sk.d = 2;
                         continue;
                     }
                     sk.r = newR; 
                     sk.c = newC;
                 }
                 if(map[sk.r][sk.c] != null) {
                     if(map[sk.r][sk.c].z < sk.z) {
                         map[sk.r][sk.c] = new Shark(sk.r, sk.c, sk.s, sk.d, sk.z); // 현재 상어 넣어줌 
                     } 
                 } else {
                     map[sk.r][sk.c] = new Shark(sk.r, sk.c, sk.s, sk.d, sk.z);
                 }
                 
            }
        }
        System.out.println(count);
    }
}

