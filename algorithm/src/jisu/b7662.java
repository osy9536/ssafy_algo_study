package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b7662 {
	static int n;

	static TreeSet<Integer> fset = new TreeSet<>();

    static Map<Integer, Integer> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            fset = new TreeSet<>();
            map = new HashMap<Integer, Integer>();
            for (int l = 0; l < n; l++) {
                st = new StringTokenizer(br.readLine());
                char inst = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                
                if (inst == 'D') {
                	if (fset.size() == 0) continue;
                	
                	int find = fset.last();
                    if (num == -1) {
                        find = fset.first();
                    } 
                    
                    int cnt = map.get(find);
                    if (cnt == 1) {
                    	fset.remove(find);
                    	map.remove(find);
                    } else {
                    	map.put(find, cnt-1);
                    }
                } else {
                	if (fset.contains(num)) {
                		map.put(num, map.get(num)+1);
                	} else {
                		fset.add(num);
                        map.put(num, 1);
                	}
                    
                }
            }
            
            if (fset.size() == 0) System.out.println("EMPTY");
            else System.out.println(fset.last() + " " + fset.first());
        }
		
	}
}
