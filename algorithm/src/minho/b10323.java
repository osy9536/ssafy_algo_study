package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b10323 {
	static int N,M;
	static List<Integer>[] list ;
	static boolean[] isVisited;
	static boolean isTrue;
	public static void find(int start, int cnt) {
		if(cnt == 4) { //기저조건
			isTrue = true;
			return ;
		}
		isVisited[start]=true;
		for(int i :list[start]) {
			if(!isVisited[i]) {
				find(i,cnt+1);
			}
		}
		isVisited[start]=false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		for(int i = 0 ; i < N ; i++) {
			list[i] = new ArrayList<>();
		}
		isVisited = new boolean[N];
		for(int i = 0 ; i < M ; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i = 0 ; i < N ; i++) {
			if(!isTrue)	find(i,0);
		}
		if(isTrue)
			System.out.println(1);
		else
			System.out.println(0);
	}
}






