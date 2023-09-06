package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class answer{
	int num;
	String str;
	
	public answer(int num, String str) {
		super();
		this.num = num;
		this.str = str;
	}
}
public class b9019 {
	static int T ,a ,b;
	static boolean[] isVisited;
	static Queue<answer> q = new LinkedList<>();
	
	public static void f(String s) {
		q.clear();
		isVisited = new boolean[10000];
		q.add(new answer(a,s));
		while(!q.isEmpty()) {
			int qsize = q.size();
			for(int p = 0 ; p < qsize ; p++) {
				int x = q.peek().num;
				String ex = q.poll().str;
				if(x==b) {
					System.out.println(ex);
					return;
				}
				for(int i = 0 ; i < 4 ; i++) {
					switch(i) {
					case 0 :
						if(!isVisited[(2*x)%10000]) {
							if(2*x>9999) {
								isVisited[(2*x)%10000]=true;
								q.add(new answer((2*x)%10000,ex+"D"));
							}else {
								isVisited[2*x]=true;
								q.add(new answer(2*x,ex+"D"));
							}
							break;
						}
					case 1:
						if(x-1>=0 && !isVisited[(x-1)%10000]) {
							isVisited[(x-1)%10000]=true;
							q.add(new answer(x-1,ex+"S"));
							break;
						}
						else if(x==0) {
							x=10000;
							isVisited[9999]=true;
							q.add(new answer(x-1,ex+"S"));
							break;
						}
					case 2:
						if(x<10000 && !isVisited[(x%1000)*10+(x/1000)]) {
							isVisited[(x%1000)*10+(x/1000)]=true;
							q.add(new answer((x%1000)*10+(x/1000),ex+"L"));
						}
						/*
						if(x/1000>0 && !isVisited[(x%1000)*10+(x/1000)]) {
							isVisited[(x%1000)*10+(x/1000)]=true;
							q.add(new answer((x%1000)*10+(x/1000),ex+"L"));
						}
						else if(x/100>0 && !isVisited[(x%100)*10+(x/100)]) {
							isVisited[(x%100)*10+(x/100)]=true;
							q.add(new answer((x%100)*10+(x/100),ex+"L"));
						}
						else if(x/10>0 && !isVisited[(x%10)*10+(x/10)]) {
							isVisited[(x%10)*10+(x/10)]=true;
							q.add(new answer((x%10)*10+(x/10),ex+"L"));
						}
						else if(x*10<10000 && !isVisited[x*10])
							isVisited[x*10]=true;
							q.add(new answer(x*10,ex+"L"));
						*/
						break;
					case 3:
						if(x<10000 && !isVisited[((x%10)*1000)+(x/10)]) {
							isVisited[((x%10)*1000)+(x/10)]=true;
							q.add(new answer(((x%10)*1000)+(x/10),ex+"R"));
						}
						/*
						else if(x<100 && !isVisited[((x%10)*1000)+(x/10)]) {
							isVisited[((x%10)*1000)+(x/10)]=true;
							q.add(new answer(((x%10)*1000)+(x/10),ex+"R"));
						}
						else if(x<1000 && !isVisited[((x%10)*1000)+(x/10)]) {
							isVisited[((x%10)*1000)+(x/10)]=true;
							q.add(new answer(((x%10)*1000)+(x/10),ex+"R"));
						}
						else if(x<10000 && !isVisited[((x%10)*1000)+(x/10)]) {
							isVisited[((x%10)*1000)+(x/10)]=true;
							q.add(new answer(((x%10)*1000)+(x/10),ex+"R"));
						}
						*/
						break;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < T ; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			String s="";
			f(s);
		}
	}
}
