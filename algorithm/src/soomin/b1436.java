package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b1436 {
    static ArrayList<Integer> list = new ArrayList<>();
    static int N;
    static int cnt;
    static String s;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        making666();

    }


    public static void making666() {

        list.add(0);

        int next = 0;

        while(cnt != N){
            list.set(0, list.get(0)+1);

            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) == 10){
                    list.set(i,0);
                    if(i+1 == list.size()){
                        list.add(1);
                    }else{
                        list.set(i+1, list.get(i+1)+1);
                    }
                }
            }

            int predicate = 0;
            for (int i = 0; i < list.size(); i++) {
                predicate += list.get(i)*Math.pow(10,i);
            }

            if(String.valueOf(predicate).contains("666")){
                cnt++;
            }

            if(cnt == N){
                break;
            }
        }

        for (int i = list.size()-1; i >=0; i--) {
            System.out.print(list.get(i));
        }

    }
}
