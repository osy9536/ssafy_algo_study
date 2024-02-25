package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1004{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int start[] = new int[2];
		int end[] = new int[2];
		
		int circle[]=new int[3];
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			start[0]=Integer.parseInt(st.nextToken());
			start[1]=Integer.parseInt(st.nextToken());
			
			end[0]=Integer.parseInt(st.nextToken());
			end[1]=Integer.parseInt(st.nextToken());
			
			int n=Integer.parseInt(br.readLine());
			int cnt=0;
			
			for(int j=0; j<n; j++) {
				boolean startPoint=false;
				boolean endPoint=false;
				st=new StringTokenizer(br.readLine()," ");
				circle[0]=Integer.parseInt(st.nextToken());
				circle[1]=Integer.parseInt(st.nextToken());
				circle[2]=Integer.parseInt(st.nextToken());

				if(Math.pow(start[0]-circle[0], 2)+Math.pow(start[1]-circle[1], 2)<=Math.pow(circle[2], 2)) {
					startPoint=true;
					cnt++;
				}
				
				if(Math.pow(end[0]-circle[0], 2)+Math.pow(end[1]-circle[1], 2)<=Math.pow(circle[2], 2)) {
					endPoint=true;
					cnt++;
				}
                
				// 동시 도착하면 취소
				if(startPoint==true && endPoint==true)
					cnt-=2;
			}
			sb.append(cnt+"\n");
		}
		
		System.out.print(sb);
	}
}