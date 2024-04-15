import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
 * 팩토리얼 0의 개수
 * */

public class Main {

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger amount = BigInteger.valueOf(1);

        for (long i = 1; i <= N; i++) {
            amount = amount.multiply(BigInteger.valueOf(i));
        }

        String temp = String.valueOf(amount);

        int cnt = 0;

        for (int i = temp.length()-1; i >= 0; i--) {

            if(temp.charAt(i) != '0'){

                System.out.println(cnt);
                return;
            }
            else{
                cnt ++;
            }
        }
    }
}
