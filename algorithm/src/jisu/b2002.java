package algorithm.src.jisu;

import java.util.*;

public class b2002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		Map<String,Integer> map = new HashMap<>();
		int result = 0;
		for (int i = 0; i < n; i++) {
			map.put(sc.next(), i);
		}
		for (int i = 0; i < n; i++) {
			arr[i] = map.get(sc.next());
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					result++;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
