package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class b15686 {

    static int N,M;
    static int [][] city;
    static ArrayList<ZhaPho4> cList = new ArrayList<>();
    static ArrayList<ZhaPho4> surviveList = new ArrayList<>();
    static ArrayList<ZhaPho4> homeList = new ArrayList<>();

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                city[i][j] = value;
                if(value == 2){
                    cList.add(new ZhaPho4(i,j));
                } else if (value == 1) {
                    homeList.add(new ZhaPho4(i,j));
                }
            }
        }

        Combination(0,0);
        System.out.println(min);

    }
    public static void Combination (int deepth, int cnt) {
        if( cnt == M){
            int value = CalculD();
            min = Math.min(value, min);
            return;
        }

        for (int i = deepth; i < cList.size(); i++) {
            surviveList.add(cList.get(i));
            Combination(i+1, cnt+1);
            surviveList.remove(surviveList.size()-1);
        }
    }

    public static int CalculD (){
        int sum = 0;
        for (int i = 0; i < homeList.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < surviveList.size(); j++) {
                int value = Math.abs(homeList.get(i).x - surviveList.get(j).x) + Math.abs(homeList.get(i).y - surviveList.get(j).y);
                min = Math.min(min,value);
            }
            sum +=min;
        }

        return sum;
    }
}

class ZhaPho4 {
    int x;
    int y;

    public ZhaPho4(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
