package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b14651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int n = Integer.parseInt(br.readLine());
        
		if (n==1) {
            System.out.println(0);
        } else {
        	int answer = 2;
            for (int i = 2; i < n; i++) {
                answer = (int) ((long) 1 * answer * 3 % 1000000009);
            }
            System.out.println(answer);
        }
	}
}
