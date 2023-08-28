package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b9461 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		List<Long> pado = new ArrayList<>();
		for(int i=0; i<3; i++) pado.add((long) 1);
		List<Integer> input = new ArrayList<>();
		int maxi = 0;
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			input.add(n);
			if (maxi < n) maxi = n;
		}
		
		for (int i = 3; i < maxi; i++) pado.add(pado.get(i-3) + pado.get(i-2));
		
		for (int i = 0; i < T; i++) System.out.println(pado.get(input.get(i)-1));
	}
}
