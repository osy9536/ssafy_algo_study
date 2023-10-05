package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

import java.util.StringTokenizer;

public class b9205 {

    // Base[0] == home, Base[마지막] = 페스티벌 좌표
    static Zhapho2 [] Base;
    static boolean [] flag;

    // bfs로 S에서 움직인다. 물(*)도 BFS로 움직인다. *이 S보다 먼저 Bfs로 움직임, 떠난 자리는 다시 .으로 채워넣는다. -> *이 채울 수 있게
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());

        for (int T = 0; T < TestCase; T++) {
            int conviniCount = Integer.parseInt(br.readLine());
            Base= new Zhapho2[conviniCount+2];

            for (int i = 0; i < Base.length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Base[i] = new Zhapho2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);

            }

            bfs();
        }


    }

    private static void bfs() {

        flag = new boolean[Base.length];
        flag[0] = true;

        ArrayDeque<Zhapho2> aq1 = new ArrayDeque<>();
        aq1.add(Base[0]);

        while(!aq1.isEmpty()){
            Zhapho2 cur = aq1.poll();
            flag[cur.index] = true;

            for (int i = 1; i < Base.length; i++) {
                if(flag[i]) {
                    continue;
                } else{

//                    System.out.println(Calcul(cur,Base[i]));
                    if(Calcul(cur,Base[i]) <= 1000){

                        aq1.add(Base[i]);
                        if(Base[i] == Base[Base.length-1]){
                            System.out.println("happy");
                            return;
                        }
                    }
                }
            }


        }
        System.out.println("sad");

    }

    private static double Calcul(Zhapho2 cur, Zhapho2 tar){


        return Math.abs(cur.x- tar.x) + Math.abs(cur.y - tar.y);
    }
}

class Zhapho2 {
    int x;
    int y;

    int index;

    public Zhapho2(int x, int y, int index){
        this.x = x;
        this.y = y;
        this.index = index;
    }
}