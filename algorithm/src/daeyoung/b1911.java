package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 백준 1911
 * 흙길 보수하기
 * 골드 5
 * https://www.acmicpc.net/problem/1911
 */
public class b1911 {

	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        int n = Integer.parseInt(st.nextToken()); //물 웅덩이 수
	        int l = Integer.parseInt(st.nextToken()); //널판지 길이
	        
	        List<long[]> water = new ArrayList<>();
	        for(int i = 0; i < n; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	water.add(new long[] {Long.parseLong(st.nextToken()),
	        			Long.parseLong(st.nextToken())});
	        }

	        Collections.sort(water, (w1, w2) -> (Long.compare(w1[0], w2[0])));
	        int answer = 0;
	        long cur = 0;
	        for(int i = 0; i < n; i++) {
	        	if(water.get(i)[0] >= cur)
	        		cur = water.get(i)[0];
	        	
	        	while(cur < water.get(i)[1]) {
	        		cur += l;
	        		answer += 1;
	        	}
	        
	        }
	        System.out.println(answer);
	    }
}
