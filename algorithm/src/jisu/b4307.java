package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b4307 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int mini = Integer.MAX_VALUE;
			int maxi = -1;
			int midi = -1;
			for (int i = 0; i < n; i++) {
				int ant = Integer.parseInt(br.readLine());
				if (ant > maxi) maxi = ant;
				if (ant < mini) mini = ant;
				midi = Math.max(midi, Math.min(ant, len-ant));
			}
			System.out.println(midi + " " + Math.max(len-mini, maxi));
		}
	}

}
