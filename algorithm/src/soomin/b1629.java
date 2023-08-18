package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Long> list = new ArrayList<>();

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());;

        if(A == 1) {
            System.out.println(A%C);
        }
        else {
            System.out.println(DAC(A,B,C));
        }




    }

    public static long DAC (long base, long exponent, long moduler) {

        // 기저 조건
        if(exponent == 1) {
            return base%moduler;
        }

        long ans = DAC(base,exponent/2, moduler);

        if(exponent%2 == 0) {
            return (ans*ans)% moduler;
        }else {
            return (((ans*ans)% moduler)*base)% moduler;
        }

    }
}
