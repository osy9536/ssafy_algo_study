package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b14888 {
	static int n, mini, maxi;
	static int[] nums;
	static int[] buho;
	
	static void pick(int depth, int ans) {
		if (depth >= n) {
			if (mini > ans) mini = ans;
			if (maxi < ans) maxi = ans;
			return;
		}
		
		for (int i = 0; i < buho.length; i++) {
			if (buho[i] <= 0) continue;
			buho[i]--;
			if (i==0) pick(depth+1, ans + nums[depth]);
			else if (i==1) pick(depth+1, ans - nums[depth]);
			else if (i==2) pick(depth+1, ans * nums[depth]);
			else pick(depth+1, ans / nums[depth]);
			buho[i]++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		buho = new int[4];
		for (int i = 0; i < buho.length; i++) {
			buho[i] = Integer.parseInt(st.nextToken());
		}
		maxi = Integer.MIN_VALUE;
		mini = Integer.MAX_VALUE;
		
		pick(1, nums[0]);
		
		System.out.println(maxi);
		System.out.println(mini);
	}
}
