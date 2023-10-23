package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/* 13701번 중복제거 */

/*  문제 풀이 방법
*   이번엔 비트 연산으로 풀어보자. int형 배열의 원소는 4byte 즉 32개의 bit를 가지고 있다. 32개의 bit 하나하나가 수를 나타낸다고 가정해보자
*   그러면 arr[1]의 32bit는 각각 0~31이란 수를 나타내고, arr[2]는 32~ 63를 나타낼 것이다.
*   현재 중복한지 보려는 값이 N이라 치면, N을 비트연산 값으로 나타내려면, N/32 == idx 이고, N%32이가 arr[N/32]내에서 쓰이는 비트의 위치이다.
*/

public class b13701 {
        static int [] arr = new int[(int)Math.pow(2,20)+1];
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            StringBuilder sb = new StringBuilder();
            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());

                //만약 v란 존재를 나타내는 비트의 위치가 이미 채워져 있다면? 이미 이전에 한번 나온 것 따라사 continue;
                if ((arr[v / 32] & (1 << v % 32)) == (1 << v % 32)) continue;
                else {
                    arr[v / 32] |= (1 << v % 32);
                    sb.append(v).append(" ");
                }
            }

            System.out.println(sb);
        }
}
