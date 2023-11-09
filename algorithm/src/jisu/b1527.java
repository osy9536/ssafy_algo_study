package algorithm.src.jisu;

import java.util.*;
import java.io.*;

public class b1527 {
	static long s, e, result;

    public static void solve(long num) {
        if (num > e)
            return;
        if (num >= s)
            result += 1;

        solve(num * 10 + 4);
        solve(num * 10 + 7);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        
        solve(4);
        solve(7);
        
        System.out.println(result);
    }
}
