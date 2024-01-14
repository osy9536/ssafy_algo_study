package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class b4153 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int value = Integer.parseInt(br.readLine());

            if(value == 0) {
                break;
            }

            StringBuilder sb = new StringBuilder().append(value);
            StringBuilder sb2 = new StringBuilder().append(value);

            sb.reverse();

            if(sb.toString().equals(sb2.toString())){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }


    }
}