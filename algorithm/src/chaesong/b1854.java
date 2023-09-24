import java.util.*;                                                                    
import java.io.*;                                                                      
                                                                                       
public class b1854 {                                                                   
	static final int INF = 10000_0000;                                                 
	static class Node implements Comparable<Node>{                                     
		int v, w;                                                                      
		public Node(int v, int w) {                                                    
			this.v = v;                                                                
			this.w = w;                                                                
		}                                                                              
		@Override                                                                      
		public int compareTo(Node o) {                                                 
			// TODO Auto-generated method stub                                         
			return this.w-o.w;                                                         
		}                                                                              
		@Override                                                                      
		public String toString() {                                                     
			return "Node [v=" + v + ", w=" + w + "]";                                  
		}                                                                              
	}                                                                                  
	public static void main(String[] args) throws Exception{                           
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));    
		StringTokenizer st = new StringTokenizer(br.readLine());                       
		                                                                               
		int n = Integer.parseInt(st.nextToken());                                      
		int m = Integer.parseInt(st.nextToken());                                      
		int k = Integer.parseInt(st.nextToken());                                      
		                                                                               
		PriorityQueue<Integer> distQueue[] = new PriorityQueue[n+1];                   
		for(int i = 1; i <= n; i++) {                                                  
			distQueue[i] = new PriorityQueue<>(k, (o1, o2)-> {                         
				return o2-o1;                                                          
			});                                                                        
		}                                                                              
		                                                                               
		int lst[][] = new int[n+1][n+1];                                               
		for(int i = 0; i < m; i++) {                                                   
			st = new StringTokenizer(br.readLine());                                   
			int a = Integer.parseInt(st.nextToken());                                  
			int b = Integer.parseInt(st.nextToken());                                  
			int c = Integer.parseInt(st.nextToken());                                  
			lst[a][b] = c;                                                             
		}                                                                              
		                                                                               
		PriorityQueue<Node> pq = new PriorityQueue<>();                                
		pq.add(new Node(1, 0));                                                        
		distQueue[1].add(0);                                                           
		while(!pq.isEmpty()) {                                                         
			Node temp = pq.poll();                                                     
			for(int i = 1; i <= n; i++) {                                              
				if(lst[temp.v][i] != 0) { //temp.v -> i가 연결되어 있다면?                     
					//크기가 k미만이라면                                                       
					if(distQueue[i].size() < k) {                                      
						distQueue[i].add(temp.w + lst[temp.v][i]);                     
						pq.add(new Node(i, temp.w + lst[temp.v][i]));                  
					}                                                                  
					//크기가 k이상이라도 현재 계산한 거리가 q.peek()보다 작다면 q에 넣을 수 있음!                 
					else if(distQueue[i].peek() > temp.w + lst[temp.v][i]) {           
						distQueue[i].poll(); //안에꺼 빼내고                                 
						distQueue[i].add(temp.w + lst[temp.v][i]); //새로 계산한 값을 넣어줌     
						pq.add(new Node(i, temp.w + lst[temp.v][i]));                  
					}                                                                  
				}                                                                      
			}                                                                          
		}                                                                              
		                                                                               
		for(int i = 1; i <= n; i++) {                                                  
			// q의 크기가 꽉 찼다면-> k번째 크기의 경로가 있다는 것                                        
			if(distQueue[i].size() == k) {                                             
				bw.write(distQueue[i].poll()+"\n");                                    
			}else {                                                                    
				bw.write(-1+"\n");                                                     
			}                                                                          
		}                                                                              
		bw.flush();                                                                    
		bw.close();                                                                    
		br.close();                                                                    
	}                                                                                  
}                                                                                      
                                                                                       
