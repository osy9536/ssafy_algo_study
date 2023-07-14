package algorithm.src.jungminho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10870 {
    public static long f(int x) {
        if(x<=0)
            return 0;
        if(x==1)
            return 1;
        return f(x-1)+f(x-2);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(f(n));
    }
}

