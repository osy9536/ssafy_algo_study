package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b10799 {

    static int count;
    static boolean isPrevLazer = false;

    public static void main(String[] args) throws IOException {

        Stack<Character> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            // (는 쇠막대기를 여는 괄호이거나, 레이저를 여는 괄호이다.
            // 어쩄든 ( 가 등장한 이상 그 앞이 레이져였든 똑같은 ( 였는 상관이 없다.
            // 왜냐하면 이제 그 다음으로 ) 등장하면 바로 레이저 이고 ( 등장하면 쇠막대기를
            // 하나더 쌓는 것이기 때문이다. ]

            if(now == '(') {
                stack.push(now);
                isPrevLazer = false;


                // )를 만나면 생각해야할 것이 두 가지
                // 그 이전이 레이져였다면 지금의 ) 는 쇠막대기를 닿는 괄호
                // 그 전이 레이저가 아니였다면 이번 )가 레이저를 닫는 괄호
            } else if (now == ')') {
                if (!isPrevLazer && !stack.isEmpty()) {
                    stack.pop();
                    count += stack.size();
                    isPrevLazer = true;

                } else if (isPrevLazer && !stack.isEmpty()) {
                    stack.pop();
                    count++;
                }
            }

        }

        System.out.println(count);
    }
}
