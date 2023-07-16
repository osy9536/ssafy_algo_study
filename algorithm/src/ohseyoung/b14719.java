package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b14719 {
	static int[] arr;
	static int x,y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[x];
		
		for(int i = 0; i <x; i++) {
			arr[i] =Integer.parseInt(st.nextToken()); 
		}
		
		int sum = 0;
		
		for(int i = 1; i < x-1;i++) {
			int left = 0;
			int right = 0;
			
			for(int j = 0; j<i; j++) {
				left = Math.max(arr[j],left);
			}
			
			for(int j = i+1; j<x; j++) {
				right = Math.max(arr[j],right);
			}
			
			if(arr[i]<left&&arr[i]<right)sum+=Math.min(right,left)-arr[i];
		}
		
		System.out.println(sum);
	}
}
