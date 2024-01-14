package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b5525 {
    // IOIOI 문제
    // 투포인터로 풀어야 할 듯?
    // 앞에 것, 뒤의 것 계속 움직이기

    static int N ;
    static int M ;

    // 전체 문자열
    static String str;

    public static void main(String[] args) throws IOException {

        // 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        str = br.readLine();


        int IOICnt = 0;
        int resultCnt = 0;

        // N의 값 => Pn의 IOI 숫자
        // ex) P1 = IOI임. 이때, N = 1 , P3 = IOIOIOI. 이때 N = 3

        for (int i = 1; i < M; i++) {

            // IOI 체킹
            if(i+1 <= str.length()-1 && str.charAt(i-1) == 'I' && str.charAt(i) == 'O' && str.charAt(i+1) == 'I'){
                IOICnt++;

                // 만약 하나의 성공적인 Pn을 찾았다면, 두칸 이동해서 또 성공적인 Pn을 찾는 경우의 수도 있음.
                // 따라서 IOI 카운트를 하나 줄인다.
                // IOI 카운트를 하나 줄인다는 말의 의미는 맨 앞에 체크했던 유효한 수를 하나 버린다는 뜻이다.

                if(IOICnt == N){
                    IOICnt--;
                    resultCnt++;
                }
                // 2칸으로 바로 이동해서 다시 IOI 체킹
                i++;
            }
            else {
                // 지금까지 셋던 것이 의미가 없으므로 무로 돌린다.
                IOICnt = 0;
            }
        }

        System.out.println(resultCnt);
    }
}
