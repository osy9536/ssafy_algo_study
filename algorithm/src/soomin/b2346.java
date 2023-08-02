package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b2346 {

    /*
       ** 풍선 터트리기 **
    *  풍선이 N개 주어지고,
    *  풍선들은 차례가 있고 원형을 이룬다. 즉 풍선 1번 2번 ... N번 다음 다시 1번으로 돌아간다. (수건 돌리기 생각)
    *  풍선을 하나 터트리면, 해당 풍선안에 쪽지로 다음번 터트려야할 풍선의 번호가 적혀있다.
    *  번호는 -N ~ N 이네 이며 음수 일 시 왼쪽으로 이동, 양수일시 오른쪽으로 이동해서 터트릴 풍선을 찾는다.
    *  풍선을 터트리는 순서를 출력해보자.
    * */

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 풍선이 들어있는 q
        Deque<Balloon> balloons = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 결과 담는 통
        ArrayList<Integer> list = new ArrayList<>();



        for (int i = 0; i < N; i++) {
            // Balloon 객체에 index 및 값 집어넣기
            balloons.add(new Balloon(i+1,Integer.parseInt(st.nextToken())));
        }

//        for(Balloon b: balloons) {
//        	System.out.print(b.value + " ");
//        }

        while(true){

            // 풍선이 하나 남으면 해당 풍선의 인덱스를 리스트 안에 넣고 끝낸다.
            if(balloons.size() ==1) {
                Balloon last = balloons.poll();

                list.add(last.index);
                break;
            }

            // 맨 앞 순서의 풍선 하나를 queue 에서 뺀다.
            Balloon b = balloons.poll();

            // 해당 큐의 인덱스를 list안에 넣는다.
            list.add(b.index);

            // 만약 풍선에 적혀있는 쪽지의 값이 음수일경우 왼쪽으로 간다. -> 큐의 머리부분에서 빼서 꼬리로 다시 넣는 것으로 표현
            if(b.value<0) {
                for (int i = 0; i < Math.abs(b.value); i++) {
                    Balloon bb = balloons.removeLast();
                    balloons.addFirst(bb);
                }
                // 만약 풍선에 적힌 쪽지의 값이 양수이면 오른쪽으로 간다. -> 큐의 꼬리부분에서 빼서 다시 머리로 넣는 것으로 표현
            }else {
                for(int i=0; i < b.value-1; i++) {
                    Balloon bb = balloons.removeFirst();
                    balloons.addLast(bb);
                }
            }
        }

        for(int a: list) {
            System.out.print(a+ " ");
        }



    }
}

class Balloon {
    // 초기 인덱스
    int index;
    int value;

    Balloon(int i,int v){
        index = i;
        value = v;
    }
}

