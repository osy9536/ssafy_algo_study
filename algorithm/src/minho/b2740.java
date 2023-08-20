package algorithm.src.minho;

//행렬 곱셈 2740번
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2740{
	static int N,M,K;
	static int[][] A,B,C;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		A=new int[N][M];
		for(int i = 0;i<N;i++) {
			StringTokenizer sta = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<M;j++ ) {
				A[i][j]=Integer.parseInt(sta.nextToken());
			}
		}
		StringTokenizer stb = new StringTokenizer(br.readLine());
		M= Integer.parseInt(stb.nextToken());
		K= Integer.parseInt(stb.nextToken());
		B=new int[M][K];
		for(int i = 0;i<M;i++) {
			StringTokenizer sta = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<K;j++ ) {
				B[i][j]=Integer.parseInt(sta.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j = 0 ; j <K;j++) {
				int sum=0;
				for(int k = 0 ; k <M;k++) {
					sum+=A[i][k]*B[k][j];
				}
				System.out.print(sum+" ");
			}
			System.out.println();
		}
	}	
}
