package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//회전초밥 15961번  
public class b15961{
	static HashMap<Integer,Integer> Map = new HashMap<>();
	static int Max = Integer.MIN_VALUE;
	static int[] n;
	public static void check() {
		int size = Map.size();
		Max = (Max < size ) ? size : Max; 
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //접시의 수
		int d = Integer.parseInt(st.nextToken()); //초밥가짓수
		int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); //쿠폰번호 c
		
		n = new int[N+k-1];

		Map.put(c, 1);
		
		for(int i = 0 ; i < N ; i++) {
			n[i] = Integer.parseInt(br.readLine());
			if(i<k) {
				if(!Map.containsKey(n[i])) {
					Map.put(n[i], 1);
				}else {
					Map.put(n[i],Map.get(n[i])+1);
				}
			}
		}
		for(int i = N ; i < (N+k-1); i++) {
			n[i]=n[i-N];
		}
		check();
		for(int i = k ; i < (N+k-1) ; i++) {
			int input = n[i];
			int output = n[i-k];
			//input 
			if(!Map.containsKey(input)) {
				Map.put(input, 1);
			}else {
				Map.put(input,Map.get(input)+1);
			}
			//output
			if(Map.get(output)==1) {
				Map.remove(output);
			}else {
				Map.put(output, Map.get(output)-1);
			}
			check();
		}
		System.out.println(Max);
	}	
}