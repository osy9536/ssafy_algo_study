package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class b1181 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        ArrayList<Words> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }


        for (String s :
                set) {
            list.add(new Words(s));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).s).append("\n");
        }

        System.out.println(sb);
    }
}

class Words implements Comparable<Words>{

    String s;

    public Words(String s){
        this. s = s;
    }


    @Override
    public int compareTo(Words o) {
        if(this.s.length() == o.s.length()){
            for (int i = 0; i < s.length(); i++) {
                if(this.s.charAt(i) == o.s.charAt(i)) continue;
                return this.s.charAt(i) - o.s.charAt(i);
            }
        }
        return this.s.length() - o.s.length();
    }
}
