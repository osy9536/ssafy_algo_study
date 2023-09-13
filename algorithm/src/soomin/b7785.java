package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            int value = st.nextToken().equals("enter")? 1 : 0;

            map.put(key,value);
        }

        ArrayList<String> list = new ArrayList<>();
        for (String k :
                map.keySet()) {
            if(map.get(k) == 1){
                list.add(k);
            }
        }

        list.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String temp :
                list) {
            sb.append(temp).append("\n");
        }
        System.out.println(sb);
    }
}
