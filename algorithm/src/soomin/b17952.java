package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b17952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 삼성이가 받을 총 점수
        int sum = 0;

        Stack<Work> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 각각 일 했는지 여부, 점수, 시간
            int isWork = Integer.parseInt(st.nextToken());
            int score = 0;
            int time = 0;

            // 현재 주어진 일이 있다면,
            if(isWork == 1) {

                // work 객체를 만들어서 점수와 걸리는 시간을 집어넣는다.
                Work work = new Work();
                score = Integer.parseInt(st.nextToken());
                time = Integer.parseInt(st.nextToken());

                // 일을 정의하고, 일을 일단 1분 한다.
                work.score= score;
                work.time = time-1;

                // time이 0가 되면 score를 sum에 더하고 work 제거
                if(work.time == 0) {
                    sum += work.score;
                }
                // 일을 했는데 더 걸릴 것 같다. -> 1분하고 넣어둠
                else {
                    stack.push(work);
                }

            }

            // 만약에 work가 0이면 stack 최상단을 꺼내서 일 함.
            else if(isWork == 0 && !stack.isEmpty()){
                Work work = stack.pop();
                work.time -= 1;

                // time이 0가 되면 score를 sum에 더하고 work 제거
                if(work.time == 0) {
                    sum += work.score;
                }
                // 일을 했는데 더 걸릴 것 같다. -> 1분하고 넣어둠
                else {
                    stack.push(work);
                }
            }
            else if(isWork == 0 && stack.isEmpty()){
                continue;
            }
        }

        System.out.println(sum);
    }
}


// 일을 담아두는 객체
class Work {
    int score;
    int time;

    public Work(int score, int time) {
        this.score = score;
        this.time = time;
    }

    public Work () {};
}
