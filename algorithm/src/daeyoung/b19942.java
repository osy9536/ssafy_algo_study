package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 19942
 * 다이어트
 * 골드 4
 * https://www.acmicpc.net/problem/19942
 */
public class b19942 {
	
	static class Nutrient {
		int mp;
		int mf;
		int ms;
		int mv;
		int price;
		
		public Nutrient(int mp, int mf, int ms, int mv, int price) {
			this.mp = mp;
			this.mf = mf;
			this.ms = ms;
			this.mv = mv;
			this.price = price;
		}
	}

	static int n; //식재료 수
	static Nutrient[] foods;
	static int mp; //최소 단백질
	static int mf; //최소 지방
	static int ms; //최소 탄수화물
	static int mv; //최소 비타민
	
	static int min = Integer.MAX_VALUE;
	static StringBuilder num = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());
		
		foods = new Nutrient[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			foods[i] = new Nutrient(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
		}

		boolean[] selected = new boolean[n];
		combi(0 ,0 ,0, 0, 0, selected, 0);
		
		if(min == Integer.MAX_VALUE)
			min = -1;
		
		System.out.println(min);
		System.out.println(num);
		
		
	}
	
	public static void combi(int p, int f, int s, int v, int price, boolean[] selected, int cur) {
		if(isPossible(p, f, s, v)) {
			
			if(price < min) {
				min = price;
				
				num.setLength(0);
				
				for(int i = 0; i < n; i++)
					if(selected[i]) {
						num.append(i + 1).append(" ");
					}
			}
			
			return;
		}
		
		for(int i = cur; i < n; i++) {
			if(selected[i])
				continue;
			
			selected[i] = true;
			combi(p + foods[i].mp, f + foods[i].mf, 
					s + foods[i].ms, v + foods[i].mv, price + foods[i].price, selected, i + 1);
			selected[i] = false;
		}
	}
	
	public static boolean isPossible(int p, int f, int s, int v) {
		if(p < mp || f < mf || s < ms || v < mv)
			return false;
		return true;
	}
}
