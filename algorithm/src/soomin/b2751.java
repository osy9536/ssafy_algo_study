package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b2751 {

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list =new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for(int a: list){
            sb.append(a).append("\n");
        }

        System.out.println(sb);

    }

}
