package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b11650 {


    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        ArrayList<Coordinate12> list =new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            list.add(new Coordinate12(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }

        Collections.sort(list);

        for (int j = 0; j < list.size(); j++) {
            sb.append(list.get(j).x).append(" ").append(list.get(j).y).append("\n");
        }

        System.out.println(sb);
    }
}

class Coordinate12 implements Comparable<Coordinate12>{
    int x;
    int y;

    public Coordinate12(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Coordinate12 o) {
        if(this.x == o.x){
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}
