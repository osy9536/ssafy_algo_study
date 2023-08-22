package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1759{
	static int L, C,ga=0,co=0;
	static char[] alpha,ans;
	static String gather = "aeiou";
	static ArrayList<char[]> list = new ArrayList<>();
	static boolean[] isVisited;
	public static void combination(int start,int cnt) {
		if(cnt == L) { //조합완성되면   == 기저조건
			ga=0;co=0;
			for(int j = 0; j < L ; j++) {
				if(gather.contains(String.valueOf(ans[j])))
					ga++;
				else
					co++;
			}
			if(ga>0 && co>1) {    //조건 만족시 arraylist add
				char[] copy = ans.clone();
				Arrays.sort(copy);
				list.add(copy); //저장
			}
			return;
		}
		for(int i = start; i < C ; i++) { //조합짜기
			if(!isVisited[i]) {
				ans[cnt] = alpha[i];
				isVisited[i]=true;
				combination(i+1,cnt+1);
				isVisited[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		StringTokenizer str = new StringTokenizer(br.readLine());
		alpha = new char[C];
		ans = new char[L];
		isVisited = new boolean[C];
		for(int i = 0 ; i < C ; i++) {
			String s = str.nextToken();
			alpha[i]=s.charAt(0);
		}
		Arrays.sort(alpha);
		// 배열집어넣기 
		// 할수있는 모든 조합 구하고 조건확인후 정렬후 출력 사전식이니까 다른데 모아서 출력도 가능
		combination(0,0);
		
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}