package algorithm.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1158 {

    /*
    * 실버 5 2차원 배열의 합
    * BufferedReader 아직 익숙하지가 않아, 값을 받을 때 마다, StringTokenizer에 새 할당을 받았는데,
    * 반복문으로 한줄 씩 받아서 변수에 집어넣는 법 있을까요?
    * */

    public static void main(String[] args) throws IOException {

        // 마피아 게임 산사람 모임
        Queue<Integer> q1 = new LinkedList<>();

        // 죽은 사람들 모임
        ArrayList<Integer> dead = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 참가자 전부 넣기
        for (int i = 1; i <= N; i++) {
            q1.add(i);
        }

        // k번 러시안 룰렛 돌려서 맨 앞에 남은 사람 제거
        for (int a = 0; a < N; a++) {
            for (int i = 0; i < K-1; i++) {
                int last = q1.poll();
                q1.add(last);
            }
            //죽은 사람은 죽은 사람 모임으로 옮기기
            dead.add(q1.poll());
        }

        // 출력 극혐임 더 쉽게 출력할 방법 찾을 것
        System.out.print("<");
        for (int i = 0; i < dead.size()-1; i++) {
            System.out.printf("%d, ",dead.get(i));
        }
        System.out.printf("%d",dead.get(dead.size()-1));
        System.out.print(">");
    }

}

