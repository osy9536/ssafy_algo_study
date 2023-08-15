package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b12933 {

    static char [] alphabet = {'q','u','a','c','k'};
    static StringBuilder [] sbs = new StringBuilder[500];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int cnt = 0;

        loopout:
        for (int i = 0; i < s.length(); i++) {
            // 문자열에서 문자 하나씩 받는다.
            char c = s.charAt(i);
            // sbs에 문자를 넣는다. 만약 현재 sbs에 문자가 들어가 있다면, 현재 문자의 다음 꺼가 아니면 다른 sbs 원소에 넣는다.
            for (int j = 0; j < sbs.length; j++) {


                // 만약 완성 했으면 빌더를 비운다.
                if((String.valueOf(sbs[j]).equals("quack"))){
                    sbs[j] = new StringBuilder();

                    // q면 넣고, 다른 언어이면 다음 builder로 토스
                    if(c == 'q'){
                        sbs[j].append(c);
                        break;
                    }else if(c == 'u' ||c == 'a' ||c == 'c' || c == 'k'){
                        continue;
                    }
                }

                // 빌더가 비어 있다면,
                if(String.valueOf(sbs[j]).equals("")){
                    // q면 넣고 아니면 다음으로 toss
                    if(c == 'q'){
                        sbs[j].append(c);
                        break;
                    }else if(c == 'u' ||c == 'a' ||c == 'c' || c == 'k'){
                        continue;
                    }
                }

                // null 일때 q면 넣고, 다른 언어이면 예외이므로 바로 종료. (앞의 모든 builder가 해당 언어를 품을 수 없다는 소리)
                if(sbs[j] == null){

                    sbs[j] = new StringBuilder();
                    if(c == 'q'){
                        sbs[j].append(c);
                    }else{
                        cnt = -1;
                        break loopout;
                    }
                    break;
                } else{
                    // alphabet의 인덱스로 넣어야할 값인지 아닌지를 계산.
                    int origin = 0;
                    int curIndex = 0;
                    for (int k = 0; k < 5; k++) {
                        // 만약 sbs 원소의 마지막 자리 문자가 c 이전 문자라면 넣는다. ex) sbs[j] == q이고 c == u면 넣는다.
                        // sbs[j] =q 인데 c == k이거나 c == q이면 안 넣음.

                        if(alphabet[k] == sbs[j].charAt(sbs[j].length()-1)) origin = k;
                        if(alphabet[k] == c) curIndex = k;
                    }
                    if(origin+1 == curIndex){
                        // 맞다면 해당 값에 넣고 빠져나오기
                        sbs[j].append(c);
                        break;
                    }
                }
            }
        }

        // ucak같이 예외가 일어났다면 바로 출력
        if(cnt == -1){
            System.out.println(cnt);
            return;
        }

        int vaild = 0;
        for (int i = 0; i < sbs.length; i++) {
            if(sbs[i] != null){
                vaild++;
            }else {
                break;
            }
        }

        //sbs 중 null 이 아닌 녀석의 수를 센다.
        for (int j = 0; j < vaild; j++) {
            if(String.valueOf(sbs[j]).equals("quack") || String.valueOf(sbs[j]).equals("") )  cnt++;
                // 모든 빌더가 q인 경우의 수 예외처리
            else {
                cnt = -1;
                break;
            }
        }

        System.out.println(cnt);



    }
}
