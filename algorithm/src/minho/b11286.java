package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
	

public class b11286{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((o1,o2)-> (Math.abs(o1)==Math.abs(o2))?(o1-o2):(Math.abs(o1)-Math.abs(o2)));
		int n = Integer.parseInt(st.nextToken());
		for(int i =0 ; i < n ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st2.nextToken());
			if(input ==0) {
				if(heap.isEmpty()) {
					System.out.println(0);
				}
				else {
					System.out.println(heap.remove());	
				}
			}
			else {
				heap.add(input);
				
			}
		}
	}
}
