package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b20436 {
    static char[][] keyboards = {
            {'Q','W','E','R','T','Y','U','I','O','P'},
            {'A','S','D','F','G','H','J','K','L'},
            {'Z','X','C','V','B','N','M'}
    };

    // 양쪽에서 현 키보드 자판까지의 거리 동일 처리를 위한 stack
    static Stack<Layout> stack = new Stack<>();
    static Layout sR;
    static Layout sL;

    //걸리는 시간 체크 용도
    static int time = 0;
    public static void main(String[] args) throws IOException {


        // 왼손 오른손 사이의 거리가 같을 경우의 처리 로직 use Stack
        // stack에 둘 사이 거리가 같을 시 넣음.
        // 둘 사이 거리가 다른 경우를 발견하면, 그거 처리하고, stack에 담긴 좌표를 하나씩 pop하여 처리

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        sL = new Layout(Character.toUpperCase(st.nextToken().charAt(0)));
        sR = new Layout(Character.toUpperCase(st.nextToken().charAt(0)));


        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < keyboards[i].length; j++) {
                if(keyboards[i][j] == sR.alphabet){
                    sR.x = i; sR.y = j;
                }
                if (keyboards[i][j] == sL.alphabet){
                    sL.x = i;
                    sL.y = j;
                }
            }
        }

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            Layout current = new Layout(Character.toUpperCase(s.charAt(i)));

            // 값 넣기
            for (int j = 0; j < keyboards.length; j++) {
                for (int k = 0; k < keyboards[j].length; k++) {
                    if(keyboards[j][k] == current.alphabet){
                        current.x = j;
                        current.y = k;
                    }
                }
            }

            //자음인 경우
            if((current.x <2 && current.y <5 ) || (current.x == 2 && current.y <4)){
                time += Distance(sL,current);
                sL.alphabet = current.alphabet;
                sL.x = current.x;
                sL.y = current.y;
            }

            //모음인 경우
            else{
                time += Distance(sR,current);
                sR.alphabet = current.alphabet;
                sR.x = current.x;
                sR.y = current.y;

            }
        }

        System.out.println(time);

    }

    public static int Distance(Layout hand, Layout current){
        return Math.abs(hand.x - current.x) + Math.abs(hand.y - current.y) + 1;
    }
}
class Layout {
    char alphabet;
    int x;
    int y;

    public Layout(char alphabet) {
        this.alphabet = alphabet;
    }
}
