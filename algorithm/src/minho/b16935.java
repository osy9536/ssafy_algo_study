package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16935{
	static int N,M,R;
	static int[][] MAP,copyMAP;
	public static void save() {
		int x = copyMAP.length, y = copyMAP[0].length;
		for(int i = 0 ; i < x ; i++) {
			MAP[i] = copyMAP[i].clone();
		}
	}
	public static void one(int x, int y){
		for(int i = 0 ; i < x ; i++) {
			copyMAP[i]=MAP[x-i-1].clone();
		}
		save();
	}
	public static void two(int x, int y){
		for(int i = 0 ; i < x ; i++) {
			for(int j = 0 ; j < y ; j++) {
				copyMAP[i][j]=MAP[i][y-j-1];
			}
		}
		save();
	}
	public static void tre(int x, int y){ //
		for(int i = 0 ; i < y ; i++) {
			for(int j = 0 ; j < x ; j++) {
				copyMAP[j][y-i-1]=MAP[i][j];
			}
		}
		save();
	}
	public static void four(int x, int y){ //
		for(int i = 0 ; i < y ; i++) {
			for(int j = 0 ; j < x ; j++) {
				copyMAP[x-j-1][i]=MAP[i][j];
			}
		}
		save();
	}
	public static void five(int x, int y){
		for(int i = 0 ; i < x/2 ; i++) {
			for(int j = 0 ; j < y/2 ; j ++) {
				copyMAP[i][j+(y/2)]=MAP[i][j];
				copyMAP[i+(x/2)][j+(y/2)]=MAP[i][j+(y/2)];
				copyMAP[i+(x/2)][j]=MAP[i+(x/2)][j+(y/2)];
				copyMAP[i][j]=MAP[i+(x/2)][j];
			}
		}
		save();
	}
	public static void six(int x, int y){
		for(int i = 0 ; i < x/2 ; i++) {
			for(int j = 0 ; j < y/2 ; j ++) {
				copyMAP[i+(x/2)][j]=MAP[i][j];
				copyMAP[i+(x/2)][j+(y/2)]=MAP[i+(x/2)][j];
				copyMAP[i][j+(y/2)]=MAP[i+(x/2)][j+(y/2)];
				copyMAP[i][j]=MAP[i][j+(y/2)];
			}
		}
		save();
	}
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int Max = Math.max(N, M);
        int x=N , y=M;
        int[] how = new int[R];
        MAP = new int[Max][Max];
        copyMAP = new int[Max][Max];
        for(int i = 0 ; i < N ; i++) {
        	StringTokenizer str = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M; j++) {
        		MAP[i][j] = Integer.parseInt(str.nextToken());
        	}
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < R ; i++) {
        	how[i] = Integer.parseInt(st.nextToken());
        	if(how[i]==1) one(x,y);
        	else if(how[i]==2) two(x,y);
        	else if(how[i]==3) {
        		int temp=x;
        		x=y; 
        		y=temp; 
        		tre(x,y);
        	}
        	else if(how[i]==4) {
        		int temp=x; 
        		x=y;
        		y=temp; 
        		four(x,y);
        	}
        	else if(how[i]==5) five(x,y);
        	else if(how[i]==6) six(x,y);
        }
        for(int i = 0 ; i < x ; i++) {
        	for(int j = 0 ; j < y; j++) {
        		System.out.print(copyMAP[i][j]+" ");
        	}
        	System.out.println();
        }
    }
}