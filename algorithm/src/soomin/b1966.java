package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1966 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Queue<Print> q1 = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int test_case =0; test_case < T; test_case++) {
            StringTokenizer st = new  StringTokenizer(br.readLine());

            //문서의 갯수
            int N = Integer.parseInt(st.nextToken());

            // 몇 번째로 출력되는지 알고 싶어하는 값의 index
            int M = Integer.parseInt(st.nextToken());

            // N개의 프린트물 받기
            st = new StringTokenizer(br.readLine());




            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(st.nextToken());
                q1.add(new Print(i,value));
                list.add(value);
            }
            Collections.sort(list, Collections.reverseOrder());

            int cnt = 0;


            while(!list.isEmpty()){
                if(list.get(0) == q1.peek().value && Collections.frequency(list, list.get(0)) >1){
                    cnt++;

                    if(M == q1.peek().originIndex){
                        break;
                    }

                    list.remove(0);
                    q1.poll();
                } else if (list.get(0) == q1.peek().value && Collections.frequency(list, list.get(0)) == 1) {
                    cnt++;
                    if(M == q1.peek().originIndex){
                        break;
                    }
                    list.remove(0);
                    q1.poll();

                } else if (list.get(0) !=q1.peek().value) {
                    int i = q1.peek().originIndex;
                    int v = q1.poll().value;
                    q1.add(new Print(i,v));
                }
            }

            System.out.println(cnt);
            list.clear();
            q1.clear();
        }
    }
}

class Print {
    // 최초 큐에 들어왔을 때 index;
    int originIndex;
    // 실제 값
    int value;

    Print(int originIndex, int value){
        this.originIndex=originIndex;
        this.value=value;
    }
}

