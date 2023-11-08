package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>((o1,o2) -> (o2-o1));
		PriorityQueue<Integer> nQ = new PriorityQueue<>();
		int zeroCnt = 0;
		long res = 0;
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a == 0) zeroCnt++;
			else if(a == 1) res++;
			else if(a<0) {
				nQ.add(a);
			}
			else {
				pQ.add(a);
			}	
		}

		while(pQ.size()>=2) {
			int a = pQ.poll();
			int b = pQ.poll();
			res+= a*b;
		}
		if(!pQ.isEmpty()) {
			res+=pQ.poll();
		}
		
		
		while(nQ.size()>=2) {
			int a = nQ.poll();
			int b = nQ.poll();
			res+= a*b;
		}
		if(!nQ.isEmpty()) {
			if(zeroCnt==0) {
				res+=nQ.poll();
			}
		}
		System.out.println(res);
	}
}

