package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicBoolean;

public class b22942 {

    /*	22942번	데이터체커	*/

    /*	문제풀이
     * 	1. x좌표와 반지름을 이용해, x축과 원의 오른쪽 교점과 왼쪽 교점을 구한다.
     * 	2. 일렬로 교점들을 정렬한다.
     *  3. 왼쪽 교점을 여는 괄호, 오른쪽 교점을 닫는 괄호라고 쳤을 때, 서로의 pair가 맞게 열고 닫히면, 교점이 없는 것이다.
     *  4. 만약 서로 pair에 안 맞게 열고 닫히면 거기서 교점이 생기므로 답은 NO가 된다.
     *  5. 하나도 그런게 없이 pair에 딱딱 맞게 열고 닫히면 답은 Yes가 된다.
     * */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<CirNo> list = new ArrayList<>();

        // 만약 같은 교점을 공유하면 그 자리에서 바로 false로 바꾸고 답을 NO로 내기 위한 용
        AtomicBoolean vaild = new AtomicBoolean(true);

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int center = Integer.parseInt(st.nextToken());
            int radius = Integer.parseInt(st.nextToken());

            // 교점 두 개 집어넣기
            list.add(new CirNo(center-radius, i, '('));
            list.add(new CirNo(center+radius, i, ')'));
        }

        // 교점 좌표를 기준으로 오름차순 정렬
        list.sort(((o1, o2) -> {
            if(o1.coordinate == o2.coordinate){
                vaild.set(false);
                return o1.bracket - o2.bracket;
            }
            return  o1.coordinate - o2.coordinate;
        }));

        if(!vaild.get()) {
            System.out.println("NO");
            return;
        }

        // 교점이 있는지 없는지 확인
        Stack<CirNo> stack = new Stack<>();

        for (int i = 0; i < list.size(); i++) {
            CirNo cur = list.get(i);

            if(cur.bracket == '('){
                stack.push(cur);
            }
            else if(cur.bracket == ')'){
                if(stack.peek().cirNum == cur.cirNum){
                    stack.pop();
                }else{
                    break;
                }
            }
        }

        if(stack.isEmpty()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}

class CirNo {
    int coordinate;
    int cirNum;

    char bracket;

    public CirNo(int coordinate, int cirNum, char bracket) {
        this.coordinate = coordinate;
        this.cirNum = cirNum;
        this.bracket = bracket;
    }
}
