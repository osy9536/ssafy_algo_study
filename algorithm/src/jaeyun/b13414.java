package algorithm.src.jaeyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class b13414 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        // LinkedHashSet: 삽입 순서 그대로 & 중복 제거해주는 자료구조, HashSet은 자동 정렬됨
        LinkedHashSet<String> map = new LinkedHashSet<>(500000);
        ArrayList<String> input = new ArrayList<String>();
        
        for (int i=0; i<L; i++) {
            input.add(br.readLine());
        }
        // reverse order to remove duplicated IDs
        for (int i=input.size()-1; i>=0; i--) {
        	map.add(input.get(i));
        }
        Object[] ans = map.toArray();  // answer array
        for (int i=map.size()-1; i>=map.size()-K; i--) {
        	if (i<0) break;
        	System.out.println(ans[i]);
        }
        
        br.close();
    }
}
