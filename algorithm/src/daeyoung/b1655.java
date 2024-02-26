package algorithm.src.daeyoung;

import java.io.*;
import java.util.*;

/*
 * 백준 1655
 * 가운데를 말해요
 * 골드 2
 * https://www.acmicpc.net/problem/1655
 */
public class b1655 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> q1 = new PriorityQueue<>(Collections.reverseOrder()); // middle index
        PriorityQueue<Integer> q2 = new PriorityQueue<>(); //middle index + 1

        for(int i = 0; i < n; i++) {
            int cur = Integer.parseInt(br.readLine());

            if (q1.size() == q2.size()) {
                q1.add(cur);

                if (!q2.isEmpty() && q1.peek() > q2.peek()) {
                    q2.add(q1.poll());
                    q1.add(q2.poll());
                }
            } else {
                q2.add(cur);

                if (q1.peek() > q2.peek()) {
                    q2.add(q1.poll());
                    q1.add(q2.poll());
                }
            }

            sb.append(q1.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
