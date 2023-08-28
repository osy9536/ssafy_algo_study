package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14888 {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int [] arr;
    static int [] calculation;
    static int [] operations;

    // 조합에서 사용할 flag -> 사칙연산이 하나 이상 나올 수 있으므로 int로 잡는다.
    // index 0,1,2,3 -> + - x %
    static int [] flag = new int [4];


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int [N];
        calculation = new int[N];
        operations = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());



        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            int operCount = Integer.parseInt(st.nextToken());
            flag[i] = operCount;
        }

        Combination(0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void Combination(int deepth){

        if(deepth == N-1){
            calcul();
            max = Math.max(max, calculation[N-1]);
            min = Math.min(min,calculation[N-1]);
            return;
        }

        // 각 위치마다 연산자를 고르는 행동
        for (int i = deepth; i < N-1; i++) {

            //남은 연산자 체크 남아있으면 현 위치에 해당 연산자를 넣는다.
            for (int j = 0; j < 4; j++) {
                if(flag[j] == 0) continue;

                flag[j]--;
                operations[i] =  j;
                Combination(i+1);
                flag[j]++;
            }
            return;
        }
    }

    public static void calcul(){

        for (int i = 0; i < N - 1; i++) {

            if(i == 0){
                switch (operations[i]){
                    case 0:
                        calculation[i+1] = arr[i]+arr[i+1];
                        break;
                    case 1:
                        calculation[i+1] = arr[i]-arr[i+1];
                        break;
                    case 2:
                        calculation[i+1] = arr[i]*arr[i+1];
                        break;
                    case 3:
                        if(arr[i]>=0){
                            calculation[i+1] = arr[i] / arr[i+1];
                        }else{
                            calculation[i+1] =  -(Math.abs(arr[i])/arr[i+1]);
                        }
                        break;
                }
                continue;
            }

            switch (operations[i]){
                case 0:
                    calculation[i+1] = calculation[i] + arr[i+1];
                    break;
                case 1:
                    calculation[i+1] = calculation[i] - arr[i+1];
                    break;
                case 2:
                    calculation[i+1] = calculation[i] * arr[i+1];
                    break;
                case 3:
                    if(calculation[i]>=0){
                        calculation[i+1] = calculation[i] / arr[i+1];
                    }else{
                        calculation[i+1] =  -(Math.abs(calculation[i])/arr[i+1]);
                    }
                    break;
            }
        }
    }
}
