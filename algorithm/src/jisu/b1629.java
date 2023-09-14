package algorithm.src.jisu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1629 { 
    static int n;
    static int[] dp;
    static int result = 0;
    
    static long pow(long a, long b, long c) {
    	if (b == 1) return a%c;
    	long imsi = pow(a, b/2, c);
    	if (b%2==1) return (imsi*imsi%c)*a%c;
    	return imsi*imsi%c;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        
        
        System.out.println(pow(a,b,c));
    }
}