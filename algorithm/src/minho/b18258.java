package ssafy_algo_study.algorithm.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int last=-1;
		Queue<Integer> q = new LinkedList<>();
		for(int i =0 ; i<a;i++) {
			int print=0;
			st =new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.contains("push")) {
				print =Integer.parseInt((st.nextToken()));
				q.add(print); 
				last=print;
			}else if(s.contains("front")) {
				bw.write(((!q.isEmpty())?(int)q.peek():-1) + "\n");
			}else if(s.contains("back")) {
				bw.write(((!q.isEmpty())?last:-1)+"\n");
			}else if(s.contains("pop")) {
				bw.write(((!q.isEmpty())?(int)q.poll():-1)+"\n");
			}else if(s.contains("size")) {
				bw.write(q.size()+"\n");
			}else if(s.contains("empty")) {
				bw.write(((q.isEmpty())?1:0)+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
