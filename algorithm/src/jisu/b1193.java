package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int pre = 0;
		int now = 1;
		
		while (true) {
			if (n <= pre + now) {
				if (now % 2 == 1) {
					System.out.println(now - (n-pre-1) + "/" + (n-pre));
					break;
				} else {
					System.out.println((n - pre) + "/" + (now - (n-pre-1)));
					break;
				}
			} else {
				pre += now;
				now++;
			}
		}
		
	}
}
