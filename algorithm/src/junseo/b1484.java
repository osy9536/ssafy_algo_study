package algorithm.src.junseo;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b1484 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		
		long []arr = new long[50001];
		for (int i = 1; i < 50001; i++) {
			arr[i] = (long) Math.pow(i, 2);
		}
		
		int start = 1;
		int end = 2;
		List<Integer> list = new ArrayList<>();
		while(end<50001) {
			long a = arr[end] -arr[start];
			if(a == G) {
				list.add(end);
				start++;
			}
		    if(a > G) {
				start++;
			}
			else {
				end++;
			}
		}
		if(list.isEmpty()) System.out.println(-1);
		else{
			for (Integer integer : list) {
				System.out.println(integer);
			}
		}
		
	}
}



