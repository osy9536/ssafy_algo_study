package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b6064 {
	
	static int tc;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N,M,x,y;
		tc = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < tc ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N= Integer.parseInt(st.nextToken());
			M= Integer.parseInt(st.nextToken());
			x= Integer.parseInt(st.nextToken())-1;
			y= Integer.parseInt(st.nextToken())-1;
			
			boolean check =false;
			for (int i = x ; i < (N*M) ; i += N)
			{
				if(i%M==y) {
					System.out.println(i+1);
					check=true;
					break;
				}
			}
			if(!check)
				System.out.println(-1);
		}
	}
}
