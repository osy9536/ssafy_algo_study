import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
 * 팩토리얼 0의 개수
 * */


/*
 * 10이 만들어져야지 0이 맨 뒤의 일의 자릿수부터 하나씩 늘어남.
 * 10은 2 * 5가 들어가야지 나온다. 팩토리얼은 전부 곱으로 이어져 있다.
 * 2는 5에 비해 항상 많다. 왜냐하면 짝수인 수가 5의 배수보다 항상 많기 때문이다.
 * 따라서 5의 배수의 갯수가 곧 곱해지는 10의 개수이다.
 * 여기서 5로만 나눠서 10의 개수를 센다면 25와 같이 5의 제곱승으로 이루어진 값에 대해서는 5*5 중 5 하나만 사용한 것이 된다.
 * 따라서 25를 한번 더 나눠줘서 남은 5를 사용하게 한다.
 * 우리는 현재 MAX 값이 500 이어서,  5, 50, 125까지만 체크해서 5^n승인 값의 5도 쓰이게 해준다.
 *
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
 *
 * */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 1; i < 4; i++) {

            int exp = 5;
            for (int j = 1; j < i; j++) {
                exp = exp*5;
            }
            cnt += N/exp;
        }

        System.out.println(cnt);
    }
}

