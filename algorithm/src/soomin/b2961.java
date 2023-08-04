package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class b2961 {

    // 재료의 갯수
    static int T;

    // 최소값 비교 후 최소값 갱신, 그렇게 하기 위해 첫 int 값은 최대값으로 지칭
    static int min = Integer.MAX_VALUE;

    // 어떤 수가 포함되었고, 어떤 수가 포함되지 않았는지 Check
    static boolean [] flag;

    // 진짜 수를 포함시키는 곳 (재료 담는 통)
    static ArrayList<Ingredient> list = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        flag = new boolean[T];

        for(int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 통 안에 재로 넣기
            list.add(new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }

        // 요리 시작
        Cooking(0);

        System.out.println(min);

    }

    // 요리 재료를 포함하거나 미포함하는 모든 경우의 수를 살펴본다. -> 부분집합의 모든 set
    public static void Cooking(int deepth) {

        // 기저 조건
        if(deepth == T) {
            int cnt = 0;
            int Ssum = 1;
            int Bsum = 0;

            for(int i = 0; i<flag.length; i++) {
                if(flag[i] == true) {
                    Ssum *=list.get(i).S;
                    Bsum +=list.get(i).B;
                    cnt++;
                }
            }
            // 아무 재료도 안 넣은 경우는 제외
            if(cnt == 0) return;


            // 신맛과 쓴맛 의 차가 최소인 값 갱신
            min = Math.min(min, Math.abs(Ssum - Bsum));
            return;

        }

        // 유도부분
        for(int i = deepth; i < T; i++) {
            flag[i] = true;
            Cooking(deepth+1);
            flag[i] = false;
            Cooking(deepth+1);
            return;
        }
    }


}

class Ingredient {
    int S;
    int B;

    public Ingredient(int s, int b) {
        S = s;
        B = b;
    }


}

