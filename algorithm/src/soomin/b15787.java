package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b15787 {

    // <기차 번호, 좌석수 - 비트로 표현 20개의 칸>
    static HashMap<Integer,Integer> train = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());



        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 유효하게 통과한 기차의 수
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            train.put(i,0);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 값 받기
            int order = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int index = 0;
            if(order == 1 || order == 2){
                index = Integer.parseInt(st.nextToken())-1;
            }
            if(order == 1) {order1(num,index);}
            if(order == 2) {order2(num,index);}
            if(order == 3) {order3(num);}
            if(order == 4) {order4(num);}

//            for (int a :
//                    train.values()) {
//                System.out.println(Integer.toBinaryString(a));
//            }
//            System.out.println();
        }


        Deque<Integer> dq1 = new ArrayDeque<>();

        for (int i = 1; i <= train.size(); i++) {
            if(dq1.isEmpty()){
                cnt++;
                dq1.add(train.get(i));
            }
            else{
                int vaild = 0;
                for (int j = 0; j < dq1.size(); j++) {
                    int a = dq1.poll();
                    if(train.get(i) == a){
                        vaild = -1;
                        break;
                    }
                    dq1.add(a);
                }
                if(vaild == 0){
                    cnt++;
                }
                dq1.add(train.get(i));
            }
        }
        System.out.println(cnt);

    }

    // 원하는 자리에 상태 최신화
    public static void order1(int num, int index){
        train.put(num, train.get(num) | (1 << index));

    }

    // 원하는 자리에 삭제
    public static void order2(int num, int index){
        if((train.get(num) & (1 << index)) >= 1) {
            train.put(num,train.get(num) ^ (1 << index));
            return;
        } else {
            return;
        }


    }

    // 한 칸 뒤로 밀기
    public static void order3(int num){
        train.put(num,train.get(num)<<1);
        train.put(num,train.get(num) & ((int)Math.pow(2, 20)-1));
    }

    // 한칸 앞으로 가기
    public static void order4(int num){
        train.put(num,train.get(num) >> 1);

    }
}
