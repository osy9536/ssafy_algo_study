package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 14725
 * 개미굴
 * 골드 3
 * https://www.acmicpc.net/problem/14725
 */
public class b14725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<List<String>> cave = new ArrayList<>();


        for(int i = 0; i < n; i++)
            cave.add(new ArrayList<>());


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            for(int j = 0; j < k; j++) {
                cave.get(i).add(st.nextToken());
            }
        }

        Collections.sort(cave, (o1, o2) ->  {
            int last = Math.min(o1.size(), o2.size());
            for(int i = 0; i < last; i++) {
                if(o1.get(i).equals(o2.get(i)))
                    continue;
                return o1.get(i).compareTo(o2.get(i));
            }
            return o1.get(last - 1).compareTo(o2.get(last - 1));
        });

        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>();

        for(List<String> l : cave) {
            String level = "";
            String accumulate = "";
            for(int i = 0; i < l.size(); i++) {
                accumulate += l.get(i);
                if(visited.contains(accumulate)) {
                    level += "--";

                    continue;
                }
                visited.add(accumulate);
                sb.append(level).append(l.get(i)).append("\n");
                level += "--";
            }
        }

        System.out.println(sb);
    }
}
