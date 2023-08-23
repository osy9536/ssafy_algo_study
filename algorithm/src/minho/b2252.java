package algorithm.src.minho;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//줄세우기 2252번
public class b2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] edgeCount = new int[N+1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<=N;i++) {
        	list.add(new ArrayList<Integer>());
        }
        for(int i=0;i<M;i++) {
        	StringTokenizer str = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(str.nextToken());
        	int b = Integer.parseInt(str.nextToken());
        	edgeCount[b]++;
        	list.get(a).add(b);
        }
        for(int i = 1 ; i <= N; i++)
        	if(edgeCount[i]==0)
        		q.add(i);
        while(!q.isEmpty()) {
        	int num = q.poll();
        	bw.write(String.valueOf(num)+" ");
        	ArrayList<Integer> l = list.get(num);
        	for(int i : l) {
        		edgeCount[i]--;
        		if(edgeCount[i]==0)
        			q.add(i);
        	}
        		
        }
        bw.flush();
    }
}