package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Computer{
	int number;
	LinkedList<Integer> list;
	public Computer(int n) {
		list = new LinkedList<>();
		this.number = n;
	}
}
public class b2606{
	static boolean[] visited;
	static int answer = 0;
	public static void main(String[] args) throws IOException{
		ArrayList<Computer> arr = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com = Integer.parseInt(br.readLine()); //총컴퓨터 댓수
		int num;
		for(int i = 0 ; i <= com ; i++) arr.add(new Computer(i)); //컴퓨터 생성 0번컴은 안씀 고립
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[com+1];
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).list.add(b);
			arr.get(b).list.add(a);
		}
		Queue<Integer> q = new LinkedList<>();
		visited[1]=true;
		q.add(arr.get(1).number);
		while(!q.isEmpty()) {
			for(int i = 0 ; i < arr.get(q.peek()).list.size(); i++) {
				num=arr.get(q.peek()).list.get(i);
				if(!visited[num]) {
					visited[num]=true;
					q.add(num);
					answer++;
				}
			}
			q.poll();
		}
		System.out.println(answer);
	}
}