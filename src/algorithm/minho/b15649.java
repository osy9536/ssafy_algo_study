package algorithm.minho;

import java.io.*;
import java.util.*;

public class b15649 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Stack <String> stack = new Stack<>();
	static boolean[] check;
	static String[] ans;
	static int cnt=0;
	public static void backTracking(int a,int b) throws IOException{
		if(b==0) {
			for(String s : ans) {
				bw.write(s);
				if(s==ans[cnt-1]) bw.write('\n');
				else bw.write(' ');
			}
			return;
		}
		for(int i=0;i<a;i++) {
			if(!check[i]) {
				ans[cnt++]=Integer.toString(i+1);
				check[i]=true;
				backTracking(a,b-1);
				cnt--;
				check[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		StringTokenizer st= new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		check =new boolean[a];
		ans = new String[b];
		backTracking(a,b);
		bw.flush();
		bw.close();
	}
}
