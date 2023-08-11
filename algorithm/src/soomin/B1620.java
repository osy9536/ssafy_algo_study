package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;



public class B1620  {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            map.put(i, pokemon);
            map2.put(pokemon, i);
        }

        for(int i = 0; i <M; i++) {

            String s = br.readLine();

            if(s.charAt(0)>=65) {
                System.out.println(map2.get(s));
            }else {
                System.out.println(map.get(Integer.parseInt(s)));
            }

        }
    }
}
