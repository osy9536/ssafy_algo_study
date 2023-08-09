package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
	

public class b18111{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =  Integer.parseInt(st.nextToken());
		int M =  Integer.parseInt(st.nextToken());
		int B =  Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int min=256, max=0;
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				arr[i][j]=Integer.parseInt(str.nextToken());
				min=(arr[i][j]<min)?arr[i][j]:min;
				max=(arr[i][j]>max)?arr[i][j]:max;
			}
		}
		int high=0, ansTime=Integer.MAX_VALUE;
		for(int i = min; i<=max;i++) { //층
			
			
			int Time=0,block=B; 
			
			
			for(int j = 0 ; j<N; j++) { 		//x축
				for(int k = 0 ; k<M; k++) {    	//y축
					
					
					if(arr[j][k]>i) {  		//목표치가 낮아서 땅을 파야할때 시간 2
						Time   +=  2*(arr[j][k]-i);
						block  +=  arr[j][k]-i;
					}
			
					else {						//목표치가 높아서 땅을 기워야할때 시간 1
 						Time  += (i-arr[j][k]);
 						block -= (i-arr[j][k]);
					}
					
				}
			}
			if(block<0) break;
			//높이마다의 블록,시간을 재고 최솟값만 저장
			if(block>=0 && Time<=ansTime) {
				ansTime = Time ;
				high = i;
			}
		}
		System.out.println(ansTime+" "+high);
		//입력
	}
}