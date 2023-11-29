package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b2853 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		List<Integer> list = new ArrayList<>();
		list.add(arr[1]-1);
		for (int i = 2; i < arr.length; i++) {
			for (int j : list) {
				if ((arr[i]-1) % j == 0) {
					break;
				} else if (j == list.get(list.size()-1)) {
					list.add(arr[i]-1);
					break;
				}
			}
		}
		
		System.out.println(list.size());
		
	}
}
