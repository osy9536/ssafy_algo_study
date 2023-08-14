package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b16435 {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        int fruitNum = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i< fruitNum; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        for(int i = 0 ; i< list.size(); i++) {
            if(list.get(i)<=L) {
                L++;
            }else {
                break;
            }
        }

        System.out.println(L);

    }
}
