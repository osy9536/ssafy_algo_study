package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b1759 {
    static ArrayList<Character> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean [] flag;
    static int L,C;

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        flag = new boolean[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            list.add(st.nextToken().charAt(0));
        }

        list.sort(Comparator.comparingInt(x -> x));
        dfs(0,0);
    }
    public static void dfs(int deepth, int start){

        if(deepth == L){
            String s = String.valueOf(sb);

            if(!s.contains("a") && !s.contains("e") && !s.contains("i") && !s.contains("o") && !s.contains("u")){
                return;
            }else{
                int cnt = 0;
                if(s.contains("a")){cnt++;}
                if(s.contains("e")){cnt++;}
                if(s.contains("i")){cnt++;}
                if(s.contains("o")){cnt++;}
                if(s.contains("u")){cnt++;}

                if(L - cnt < 2) return;
            }


            System.out.println(sb);
            return;
        }

        for (int i = start; i < C; i++) {
            sb.append(list.get(i));
            dfs(deepth+1, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
