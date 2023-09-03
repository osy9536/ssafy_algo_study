package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class b11279{
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       	int n = Integer.parseInt(br.readLine());
       	StringBuilder sb = new StringBuilder();
       	PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());
       	
       	for(int i = 0 ; i < n ; i++) {
       		int a = Integer.parseInt(br.readLine());
       		if(a==0) {
       			if(pq.isEmpty()) sb.append(0).append("\n");
       			else sb.append(pq.poll()).append("\n");
       		}
       		else {
       			pq.add(a);
       		}
       	}
       	System.out.println(sb);
    }
}


