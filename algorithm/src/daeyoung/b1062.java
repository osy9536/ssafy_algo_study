package algorithm.src.daeyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1062
 * 가르침
 * 골드 4
 * https://www.acmicpc.net/problem/1062
 */
public class b1062 {

    static int answer = 0;
    static boolean[] check;
    static String[] dic;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //단어 수
        k = Integer.parseInt(st.nextToken()); //가르칠 수 있는 글자 수

        dic = new String[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            dic[i] = temp.substring(4, temp.length() - 4);
        }

        if(k >= 5) {
            check = new boolean[26];

            k -= 5;
            check[0] = true; //a
            check[13] = true; //n
            check[19] = true; //t
            check[8] = true; //i
            check[2] = true; //c

            combi(1, k);
        }



        System.out.println(answer);

    }

    public static void combi(int cur, int cnt) {
        if(cnt == 0) {
            int tempAnswer = 0;

            // 읽을 수 있는 단어 세기
            for(int i = 0; i < n; i++) {
                int count = 0;
                for(char c : dic[i].toCharArray()) {
                    if(check[(int)c - 97]) {
                         count += 1;
                    }
                }

                if(count == dic[i].length())
                    tempAnswer++;
            }

            answer = Math.max(answer, tempAnswer);
            return;
        }

        for(int i = cur; i < 26; i++) {
            if(check[i])
                continue;
            check[i] = true;
            combi(i + 1, cnt-1);
            check[i] = false;
        }
    }
}
