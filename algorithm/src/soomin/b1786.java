package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 *  찾기
 *  KMP 알고리즘을 이용하여 효울적으로 문자열 내에서 패턴을 찾는 문자열 문제이다.
 */

/*  문제 풀이
    (1) 패턴 문자열 P을 1~i번째 index까지 고려했을 때, 접미사와 일치하는 접두사의 최대길이를 값으로 하고, 인덱스를 i로 하는 배열 Pi를 만든다.
    (2) 해당 배열의 값은 0~i 까지 고려시 접미사와 일치하는 접두사의 최대길이의 뜻도 있지만, 우리가 전체 문자열에서 조회하는 곳과 일치하는지
        비교 해야하는 배열 P의 원소의 인덱스 값이기도 하다.
    (3) 부분일치 테이블을 이용하여, 전체 문자열 내에서 계속 점프하며, 문자열 내의 패턴을 찾는다.
    (4) 일치하는 패턴을 찾으면, 횟수 카운트하고, 일치하는 패턴의 맨 앞 대가리의 index도 따로 모아 저장한다.
    (5) (4)에서 기록한 내용을 출력한다.
*/

public class b1786 {

    static char [] T;
    static char [] P;
    static int  [] Pi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 값 받기
        T = br.readLine().toCharArray();
        P = br.readLine().toCharArray();
        Pi = new int[P.length];


        // Pi 배열 초기화
        // Pi 배열의 index 0는 하나의 원소만 존재하여 접두사, 접미사가 존재하지 않으므로, 생각 안한다. index 0~1비교를 처음 시작으로 함
        int pre = 0;
        for (int suf = 1;  suf< P.length; suf++) {

            // 0~i-1까지는 접두사, 접미사 일치가 존재했었는데, 0~i까지로 확장하자. 일치하지 않는 경우
            // 접두사를 오른쪽으로 잡아 댕겨서 접미사와 일치 여부를 확인해야함. (일치하는 접두사의 길이가 줄어드는 방향)
            // 이를 위해서는 0~(i-1)까지 원소 고려 시, 접두사와 접미사가 일치했다는 사실을 이용한다.
            // 0~ (i-1) 까지 고려 시, 일치하는 접두사와 접미사 의 원소들을 하나의 배열로 생각한다. -> 이를 바깥 접두사 접미사라 한다.
            // 그럼 그 배열 내에서도 일치하는 접두사와 접미사가 존재할 것이다. -> 이를 내부 접두사 접미사라고 한다.
            // 바깥 접두사와 접미사는 완전히 서로 같은 배열임.
            // 바깥 접두사의 내부 접두사를 바깥 접미사의 내부 접미사 위치로 옮겨버리면,
            // 동일한 부분 제외하고 유효한 비교를 할 수 있음.

            while(pre > 0 && P[pre] != P[suf]){
                pre = Pi[pre-1];
            }

            // 맨 처음부터 달라버리면, 테이블엔 값이 0이 들어간다. -> 전체 문자열의 현 조회 위치와 Pattern의 처음부터 다시 비교해라는 뜻
            // 일치하는게 있다면, pre를 ++ 해서 앞으로 나아가게함.
            // 그리고 현재 0~suf까지 비교한 값은 현재 일치하는 접두사의 개수와 같으므로 pre++ 한 값이 들어감.
            // (0부터 세니까 개수는 +1한 값이 들어간 것임. -> 이것이 다시 인덱스로 보면, 일치하는 부분이 끝난 후 index를 가리킴.)
            if(P[pre] == P[suf]){
                pre++;
                Pi[suf] = pre;
            }

        }

        // KMP 알고리즘 이용 -> 불일치 부분 발견 시, 접두사 접미사 일치하는 부분 제외하고, 유효한 원소와의 비교를 위해 패턴을 Shifting

        int cnt = 0;
        ArrayList<Integer> idxLists = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < T.length; i++) {

            while(j > 0 && T[i] != P[j]){
                j = Pi[j-1];
            }

            if(T[i] == P[j]){
                j++;
                // P배열 전체 순회했는데 다 되면, j는 index를 벗어나는 값이 된다.
                if(j == P.length) {
                    idxLists.add(i+2-j);
                    cnt ++;
                    j = Pi[j-1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");

        for (int temp :
                idxLists) {
            sb.append(temp).append(" ");
        }
        System.out.println(sb);
    }
}
