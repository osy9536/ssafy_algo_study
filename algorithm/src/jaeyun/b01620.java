package algorithm.src.jaeyun;

import java.util.ArrayList;
import java.util.Scanner;

public class b01620 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<String> pokemons = new ArrayList<>();
		for (int i=0; i<N; i++) {
			pokemons.add(sc.next());
		}
		for (int i=0; i<M; i++) {
			String input = sc.next();
			char firstEle = input.toCharArray()[0];
			if (firstEle >= '0' && firstEle <= '9') {
				System.out.println(pokemons.get(Integer.valueOf(input) - 1));
			}
			else {
				for (int j=0; j<pokemons.size(); j++) {
					if (input.equals(pokemons.get(j))) {
						System.out.println(j+1);
						break;
					}
				}
			}
		}
		sc.close();
	}
}
