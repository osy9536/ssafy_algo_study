package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_3040_백설공주와일곱난쟁이 {
	static int[] arr;
	static int[] res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		res = new int[7];
		dfs(0,0);
	}
	static void dfs(int cnt,int start) {
		if(cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += res[i];
			}
			if(sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(res[i]);
				}
			}
		}
		else {
			for (int i = start; i < 9; i++) {
				res[cnt] = arr[i];
				dfs(cnt+1,i+1);
			}
		}
	}
}


