package algorithm.jaeyun;

import java.util.HashMap;
import java.util.Scanner;

public class b01620 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] pokemonsInArray = new String[N+1];
		HashMap<String, Integer> pokemonsInHashMap = new HashMap<>();
		for (int i=0; i<N; i++) {
			String tmp = sc.next();
			pokemonsInArray[i+1] = tmp;
			pokemonsInHashMap.put(tmp, i+1);
		}
		for (int i=0; i<M; i++) {
			String input = sc.next();
			char firstEle = input.toCharArray()[0];
			if (firstEle >= '1' && firstEle <= '9') {
				System.out.println(pokemonsInArray[Integer.parseInt(input)]);
			}
			else {
				System.out.println(pokemonsInHashMap.get(input));
			}
		}
		sc.close();
	}
}
