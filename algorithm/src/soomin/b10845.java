package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class b10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> q1 = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s){
                case "push": {
                    q1.add(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop" : {
                    if(q1.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(q1.poll()).append("\n");
                    }
                    break;
                }
                case "size": {
                    sb.append(q1.size()).append("\n");
                    break;
                }
                case "empty": {
                    if(q1.isEmpty()){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                }
                case "front": {
                    if(q1.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(q1.peekFirst()).append("\n");
                    }
                    break;
                }
                case "back": {
                    if(q1.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(q1.peekLast()).append("\n");
                    }
                    break;
                }
            }

        }
        System.out.println(sb);

    }
}