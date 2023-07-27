package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class b11866{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=a;i++)
            q.add(i);         //입력
        while(!q.isEmpty()) {
            for(int i=1;i<b;i++) {
                int p=q.poll();
                q.add(p);
            }
            list.add(q.poll());
        }
        System.out.print("<");
        for(int i=0;i<list.size()-1;i++)
            System.out.print(list.get(i)+", ");
        System.out.print(list.get(list.size()-1)+">");
    }
}