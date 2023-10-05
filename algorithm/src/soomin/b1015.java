package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
 *  수열 정렬
 *  입력된 수열을 비내림차순으로 정렬했을 때, 각 원소의 인덱스를 구하라.
 */

/*  문제 풀이
    1. 클래스를 만든다. -> 클래스에는 원소의 값, 원소의 원래 인덱스 원소의 비내림차순 정렬 시 인덱스를 저장하는 멤버 변수가 있다.
    2. 먼저 원소의 값과 원래 인덱스를 초기화한 클래스 배열을 만든다.
    3. 원 배열을 비내림 차순으로 정렬하고, 그때의 인덱스를 클래스 배열의 멤버변수에 저장한다.
    4. 클래스 배열을 순회하면서, 비내림 차순 시 인덱스를 차례대로 출력한다.
*/

public class b1015 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        Comprehensive [] comArr = new Comprehensive[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
            comArr[i] = new Comprehensive(value, i);
        }

        Arrays.sort(arr);

        outline:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 정렬된 배열 순회하면서, 클래스 배열의 값과 같은 것 가졌고, 아직 sortedIndex가 초기화되지 않은 상태라면,
                if(comArr[j].v == arr[i] && comArr[j].sortedIndex == -1){
                    comArr[j].sortedIndex = i;
                    continue outline;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(comArr[i].sortedIndex).append(" ");
        }

        System.out.println(sb);




    }
}

class Comprehensive {
    int v;
    int originIndex;
    int sortedIndex = -1;

    public Comprehensive(int v, int originIndex){
        this.v = v;
        this.originIndex = originIndex;
    }
}
