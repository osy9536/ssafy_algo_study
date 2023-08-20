package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b16435 {
	static int[] fruit;
	static int N,Max=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer first = new StringTokenizer(br.readLine());
	    N = Integer.valueOf(first.nextToken());
	    int L = Integer.valueOf(first.nextToken());
	    fruit =new int[N];
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i =0 ; i < N; i ++) {
	    	fruit[i]=Integer.parseInt(st.nextToken());
	    }
	    Arrays.sort(fruit);
	    int len=L,cnt=0,save=0;
	    while(true) {
	    	cnt=0;
	    	for(int i=save;i<N;i++) {
	    		if(len>=fruit[i]) {
	    			cnt++;
	    			save++;
	    		} else break;
	    	}
	    	len+=cnt;
	    	if(cnt==0) {
	    		Max = (Max < len)?  len : Max ; 
	    		break;   //루프종료 
	    	}
	    }
	    System.out.println(Max);
	}
}
