package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b22232 {

	static class Info implements Comparable<Info>{
        String front,back;
        int inSet;
        
        public Info(String front, String back, int inSet){
            this.front=front;
            this.back=back;
            this.inSet=inSet;
        }
        
        @Override
        public int compareTo(Info o){
            if(this.front.equals(o.front)){
                if(this.inSet==o.inSet){
                    return this.back.compareTo(o.back);
                }
                return Integer.compare(o.inSet,this.inSet);
            }
            return this.front.compareTo(o.front);
        }
    }
	
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int a = Integer.parseInt(st.nextToken());
	    int b = Integer.parseInt(st.nextToken());
	    
	    //√ ±‚»≠
	    List<String> li = new ArrayList<>();
	    HashSet<String> set = new HashSet<>();
	    
	    for(int i=0;i<a;i++){
	        String str = br.readLine();
	        li.add(str);
	    }
	    for(int i=0;i<b;i++){
	        String str = br.readLine();
	        set.add(str);
	    }
	    PriorityQueue<Info> pq = new PriorityQueue<>();
	    
	    for(int i=0;i<a;i++){
	        st = new StringTokenizer(li.get(i),".");
	        String front = st.nextToken();
	        String back = st.nextToken();
	        int flag = set.contains(back) ? 1 : 0;
	        pq.offer(new Info(front,back,flag));
	    }
	    while(!pq.isEmpty()){
	        Info ii = pq.poll();
	        System.out.println(ii.front+"."+ii.back);
	    }
	}
}
