import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 감소하는 수 - 조합
 * (1) 조합으로 구해야하는 값의 자릿수 선정
 * (2) 해당 자릿수에서 시작 숫자 선정
 * (3) 시작 숫자에서 역순으로 값 구하기
 * */

public class Main {

    static int N;

    static StringBuilder sb = new StringBuilder();

    static int [] arr = {0,1,2,3,4,5,6,7,8,9};
    static int [] output;

    static int cnt = 9;

    static boolean isValid = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        // 1. 예외 처리
        if(N >= 0 && N < 10){
            System.out.println(N);
        }


        // 2. 조합으로 값 구하기
        for (int i = 2; i <= 10; i++) {

            // 자릿수 구하기
            output = new int [i];

            // 맨 앞의 수 구하기
            for (int j = 1; j < 10; j++){
                output[0] = j;
                Combination(1,j);
                if(isValid){
                    return;
                }
            }
        }

        // 3. 제한 횟수 내에 못 찾았으면 에러
        if(cnt < N){
            System.out.println(-1);
        }
    }

    // limit을 이전 배열 값으로 정해서 그 이상은 넘지 않도록 한다.
    public static void Combination (int depth,  int limit) {
        // 1) 기저 조건
        if(depth == output.length){

            cnt++;

            if(cnt == N){
                isValid = true;
                for (int temp : output){
                    System.out.print(temp);
                }
            }

            return;
        }

        for (int i = 0; i < limit; i++) {
            output[depth] = i;
            Combination(depth+1, i);
        }



    }
}
