import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

// 5430번 AC
public class Main {

    // T: Testcase, p: 명령어의 개수, n: 배열안의 수의 개수
    static int T,n;

    // orders: 명령어가 일렬로 들어가있는 문자열
    static String orders;

    // arr: 숫자가 들어있는 배열
    static String [] arr ;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());


        for (int t = 0; t < T; t++) {

            // 1) 값 입력 받기

            orders = br.readLine();
            n = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            if(temp.equals("[]")){
                arr = new String[0];
            }else{
                arr = temp.substring(1,temp.length()-1).split(",");
            }

            int isError = 0;

            // 2) Deque에 넣기
            ArrayDeque<String> aq1 = new ArrayDeque<>();
            aq1.addAll(Arrays.asList(arr));

            // 3) Reverse toggle을 두고 R이 들어올 때마다 위치 바꾸기
            //    true -> front, false -> rear
            boolean toggle = true;

            for (int i = 0; i < orders.length(); i++) {

                if(orders.charAt(i) == 'R'){
                    toggle = !toggle;
                }
                if(orders.charAt(i) == 'D'){

                    if(aq1.isEmpty()){
                        isError = 1;
                        break;
                    }

                    if(toggle){
                        aq1.pollFirst();
                    }
                    else{
                        aq1.pollLast();
                    }
                }
            }


            // 출력 부분
            if(aq1.isEmpty()){
                if(isError == 0){
                    System.out.println("[]");
                }else {
                    System.out.println("error");
                }
            } else if (!toggle) {

                StringBuilder sb = new StringBuilder().append("[");

                int Qsize = aq1.size();
                for (int i = 0; i < Qsize; i++) {
                    sb.append(aq1.pollLast());
                    if(i != Qsize-1){
                        sb.append(",");
                    }
                }

                sb.append("]");

                System.out.println(sb);
            } else {
                StringBuilder sb = new StringBuilder().append("[");

                int Qsize = aq1.size();
                for (int i = 0; i < Qsize; i++) {
                    sb.append(aq1.poll());

                    if(i != Qsize-1){
                        sb.append(",");
                    }
                }

                sb.append("]");
                System.out.println(sb);
            }


        }

    }
}

