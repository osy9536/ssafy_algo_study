package algorithm.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class b9095 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		List<Integer> num = new ArrayList<Integer>();
		for (int i = 0; i < t; i++) {
			num.add(Integer.parseInt(br.readLine()));
		}
		
		int[] recurr = new int[11];
		
		recurr[1] = 1;
		recurr[2] = 2;
		recurr[3] = 4;
		
		
		for (int i = 4; i < recurr.length; i++) {
			recurr[i] = recurr[i-1] + recurr[i-2] + recurr[i-3];
		}
		
		for (int i : num) {
			bw.write(recurr[i]+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}
