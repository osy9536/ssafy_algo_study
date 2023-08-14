package algorithm.src.soomin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class b17406 {

    static int [][] origin;
    static int [][] arr;

    // 2차원 배열에서 움직임을 더하는 배열들
    static int []mv = {1,0,-1,0};
    static int []mh = {0,1,0,-1};

    static boolean []isSelected;

    static TreeMap<Character, R> map = new TreeMap<>();
    static ArrayList<Character> list = new ArrayList<>();
    static ArrayList<Integer> minList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        arr = new int[N][M];
        origin = new int[N][M];

        // 2차원 배열 원본 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                origin[i][j] = temp;
            }
        }
        int alphavet = 65;
        // 2차원 배열을 회전 시키는 명령어 받기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            map.put((char)(alphavet+i), new R(r,c,s));


        }

        isSelected = new boolean[map.size()];



//        for (int [] a:
//             arr) {
//            System.out.println(Arrays.toString(a));
//        }

        Permutation(0);
        System.out.println(minList.stream().mapToInt(x->x).min().orElse(0));

    }

    public static void Permutation(int deepth){


        // 기저조건
        if(deepth == map.size()){
            for (int i = 0; i < list.size(); i++) {
                R order = map.get(list.get(i));
                rotate(order.r-1, order.c-1, order.s,0);
            }
            int min = Integer.MAX_VALUE;
            int temp =0;
            for (int[] a :
                    arr) {
                for (int b :
                        a) {
                    temp += b;
                }
                min = Math.min(min,temp);
                temp = 0;
            }

            minList.add(min);

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = origin[i][j];
                }
            }

            return;
        }

        // 유도부분 t -> 방문, f -> 미방문
        for (int i = 0; i < map.size(); i++) {
            if(!isSelected[i]){
                isSelected[i] = true;
                list.add((char)(i+65));
                Permutation(deepth+1);
                isSelected[i] = false;
                list.remove(list.size()-1);
            }
        }
    }

    public static void rotate(int a, int b, int s, int deepth){

        if(s == deepth){
            return;
        }

        //초반 start 지점;
        int x = a-s+deepth;
        int y = b-s+deepth;

        // 초기값은 바로 덮어써짐으로 미리 저장해놔야 한다.
        int temp = arr[x][y];
        // 방향값을 받아서 맨 첫 값을 temp에 집어넣고, 시계방향으로 값을 대입해서, 한 칸씩 움직이게 만든다.

        // 사방향 키잡이
        int k =0;

        while(k<4){
            int nx = x + mv[k];
            int ny = y + mh[k];

            if(nx <= a+s-deepth && ny <= b+s-deepth && nx>= a-s+deepth && ny >=b-s+deepth){
                arr[x][y] = arr[nx][ny];
                x = nx;
                y = ny;
            }else {
                k++;
            }
        }
        arr[x][y+1] = temp;

        rotate(a,b,s,deepth+1);
    }
}

class R {
    public R(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }

    int r;
    int c;
    int s;
}
