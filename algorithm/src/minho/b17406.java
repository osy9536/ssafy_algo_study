package algorithm.src.minho;

	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b17406 {
    //배열
	static int[][] arr ; //원본
    static int[][] copy ; //돌릴배열
    static int[][] how ;  //돌릴순서
    static List<int[]> list = new ArrayList<>();
    static int N,M,K,Min=Integer.MAX_VALUE;

    public static void permutation(int cnt, int[] numbers, boolean[] selected) {
        if(cnt==K) {
        	reset();
            list.add(numbers.clone());  
            for(int[] l : list) {
            	for(int i : l) {
            	   	letsgo(how[i][0],how[i][1],how[i][2]); //돌림
            	}
            }
            findMin();
            list.clear();
            return;
        }
        for(int i = 0 ; i<K;i++) {
        	if(selected[i]==false) {
        		selected[i]=true;
        		numbers[cnt]=i;
        		permutation(cnt+1,numbers,selected);
        		selected[i]=false;
        	}
        }
        return;
	}
	
	public static void findMin() {
	    //최소찾기  min 갱신
	    for(int i = 1; i <= N ; i++) {
	        int sum = 0 ;
	        for(int j = 1 ; j <= M ; j++) {
	            sum+=copy[i][j];
	        }
	        Min = (sum<Min) ? sum: Min;
	    }
	}
	
	public static void reset() { //copy초기화
	    for(int i =1;i<=N;i++){
	        copy[i] = Arrays.copyOfRange(arr[i],0 , M+2);
	    }
	}
	
	public static void letsgo(int X,int Y, int R) {
	    Queue<Integer> q = new ArrayDeque<>();
	    for(int r=1;r<=R;r++) {
	        //북 
	    	q.clear();
	        q.add(copy[X-r][Y-r]);
	        for(int y=0;y<(r*2);y++) { // - - 
	            q.add(copy[X-r][Y-r+1+y]);
	            copy[X-r][Y-r+1+y] =q.remove();
	        }
	        //동
	        for(int x=0;x<(r*2);x++) { // - +
	            q.add(copy[X-r+x+1][Y+r]);
	            copy[X-r+x+1][Y+r] =q.remove();
	        }
	        //남
	        for(int y=0;y<(r*2);y++) {
	            q.add(copy[X+r][Y+r-1-y]);
	            copy[X+r][Y+r-1-y] =q.remove();
	        }
	        //서
	        for(int x=0;x<(r*2);x++) {
	            q.add(copy[X+r-x-1][Y-r]);
	            copy[X+r-x-1][Y-r] =q.remove();
	        }
	    }
	}
	
	
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer first = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(first.nextToken());
	    M = Integer.parseInt(first.nextToken());
	    K = Integer.parseInt(first.nextToken());  //회전
	    
	    arr = new int[N+2][M+2];         //배열선언 
	    how = new int[K][3];
	    copy = new int[N+2][M+2];
	    
	    for(int i = 1 ; i <= N ; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for(int j = 1 ; j <= M ; j++) {
	            arr[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    for(int k = 0 ; k < K; k++) {
	        StringTokenizer st2 = new StringTokenizer(br.readLine());
	        for(int j = 0 ; j < 3 ; j++) {
	            how[k][j] = Integer.parseInt(st2.nextToken());
	        }
	    }
	    
	    int[] numbers = new int[K];
	    boolean[] selected = new boolean[K];
	    permutation(0,numbers,selected);
	    reset();
	    System.out.println(Min);
	}
}
