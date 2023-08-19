package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;


public class b5073 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();

        while(true){
            list.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(A == 0 && B == 0 && C == 0) return;


            list.add(A);
            list.add(B);
            list.add(C);
            list.sort(Comparator.comparingInt(x -> x));
            if(list.get(2) - ( list.get(0)+ list.get(1)) >= 0){
                System.out.println("Invalid");
            }else {
                if(A == B && B == C){
                    System.out.println("Equilateral");
                }else if(A == B || B == C || A == C){
                    System.out.println("Isosceles");
                }else{
                    System.out.println("Scalene");
                }
            }


        }
    }
}