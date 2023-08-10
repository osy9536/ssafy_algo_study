package algorithm.src.soomin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;



public class B2493   {


    // 스택을 이용하여 푼다.
    static Stack<Top> stack = new  Stack<>();
    static int N;

    // list: 정답을 담는 리스트, i는 stack과 list 같이 세어나가는 index
    // list: 해당 위치의 탑이 보내는 신호를 수신한 탑의 인덱스
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = 0;
        int a = Integer.parseInt(st.nextToken());
        while(i < N) {
            if(list.size() == N) {
                break;
            }

            if(stack.isEmpty()) {
                stack.push(new Top(a, i++));
                list.add(0);
                if(st.hasMoreElements()) {
                    a = Integer.parseInt(st.nextToken());
                }
                continue;
            }

            if(stack.peek().height > a) {
                list.add(stack.peek().index+1);
                stack.push(new Top(a,i++));
                if(st.hasMoreElements()) {
                    a = Integer.parseInt(st.nextToken());
                }
            }else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(new Top(a,i++));
                    list.add(0);
                    if(st.hasMoreElements()) {
                        a = Integer.parseInt(st.nextToken());
                    }
                }

            }

        }

        for(int t : list) {
            System.out.print(t + " ");
        }
    }
}

// top은 높이와 인덱스가 있는 클래스이다.
class Top {
    int height;
    int index;


    public Top(int height, int index) {

        this.height = height;
        this.index = index;
    }


}
