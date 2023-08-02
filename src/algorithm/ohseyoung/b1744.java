package algorithm.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b1744 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> minus = new ArrayList<>();
		List<Integer> plus = new ArrayList<>();
		int sum = 0;
		
		for(int i = 0; i<n; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a<0)minus.add(a);
			else plus.add(a);
		}
		
		Collections.sort(minus);
		Collections.sort(plus);
//		-8 -5 -1 0 1 1 2 3 6
		if(minus.size()%2!=0) {
			if(!plus.isEmpty()&&plus.get(0)==0) {
				minus.remove(minus.size()-1);
				plus.remove(0);
			}else {
				sum+=minus.get(minus.size()-1);
				minus.remove(minus.size()-1);
			}
		}
		for(int i = 0; i<minus.size()/2; i++) {
			sum+=minus.get(i*2)*minus.get(i*2+1);
		} // minus 끝
		
		while(!plus.isEmpty()) {
			int a = plus.get(0);
			if(a<=1) {
				sum+=a;
				plus.remove(0);
			}else break;
		}
		if(plus.size()%2!=0) {
			sum+=plus.get(0);
			plus.remove(0);
		}
		for(int i = 0; i<plus.size()/2; i++) {
			sum+=plus.get(i*2)*plus.get(i*2+1);
		}
		
		System.out.println(sum);
		
		
	}
}
