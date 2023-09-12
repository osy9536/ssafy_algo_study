package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class b18870 { 
    static int n;
    static int result = 0;
    static List<Integer> list = new ArrayList<>();
    
    public static int binarySearch(int f) {
    	int s = 0;
    	int e = list.size()-1;
    	int p = (s+e)/2;
    	
    	for (int i = 0; i < list.size(); i++) {
    		p = (s+e)/2;
    		int now = list.get(p);
			if (now == f) return p;
			else if (now < f) s = p + 1;
			else e = p - 1;
		}
    	
    	return p;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        Set<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	set.add(arr[i]);
		}
        
        list = new ArrayList<>();
        list.addAll(set);
        
        for (int i = 0; i < n; i++) {
        	bw.write(binarySearch(arr[i]) + " ");
		}
        
        bw.flush();
        bw.close();
    }
}