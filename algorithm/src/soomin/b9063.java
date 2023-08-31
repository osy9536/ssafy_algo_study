package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class b9063 {
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            xList.add(Integer.parseInt(st.nextToken()));
            yList.add(Integer.parseInt(st.nextToken()));
        }
        if( N == 1) {
            System.out.println(0);
            return;
        }

        System.out.println((xList.stream().mapToInt(x->x).max().orElse(-1) -
                xList.stream().mapToInt(x->x).min().orElse(-1)) *
                (yList.stream().mapToInt(x->x).max().orElse(-1) -
                        yList.stream().mapToInt(x->x).min().orElse(-1)));
    }
}