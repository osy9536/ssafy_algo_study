package algorithm.src.jisu;

import java.io.*;
import java.util.*;
 
public class b1064 {
   public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   st = new StringTokenizer(br.readLine());
	   
	   int[] arr = new int[6];
	   for (int i = 0; i < arr.length; i++) {
		   arr[i] = Integer.parseInt(st.nextToken());
	   }
	   
	   if ((arr[2]-arr[0]) * (arr[5]-arr[1]) == (arr[4]-arr[0]) * (arr[3]-arr[1])) {
		   System.out.println(-1);
		   return;
	   }
	   
	   double ab = Math.sqrt(Math.pow(arr[0]-arr[2],2)+Math.pow(arr[1]-arr[3],2));
	   double bc = Math.sqrt(Math.pow(arr[2]-arr[4],2)+Math.pow(arr[3]-arr[5],2));
	   double ca = Math.sqrt(Math.pow(arr[4]-arr[0],2)+Math.pow(arr[5]-arr[1],2));

	   double max = Math.max(ab,Math.max(bc,ca));
	   double min = Math.min(ab,Math.min(bc,ca));
	   
	   System.out.println(2*(max-min));
   }
}