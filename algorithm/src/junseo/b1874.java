package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int [] arr = new int[N];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int sIdx = 1;
        int aIdx = 0;
        while(sIdx <=N){
            if (stack.size()> 0 && stack.peek() == arr[aIdx]){
                list.add(stack.pop());
                aIdx++;
                sb.append("-").append("\n");
            }
            else{
                stack.push(sIdx++);
                sb.append("+").append("\n");
            }
        }

        while(!stack.isEmpty()){
            list.add(stack.pop());
            sb.append("-").append("\n");
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(list.toString());
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            if(list.get(i) != arr[i]){
                flag = false;
                break;
            }
        }
        if (!flag) System.out.println("NO");
        else System.out.println(sb);

    }

}


