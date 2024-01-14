package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16967 {

    static int H, W, X, Y;

    static int [][] arrA;
    static int [][] arrB;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        arrA = new int[H][W];
        arrB = new int[H+X][W+Y];

        for (int i = 0; i < H+X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W+Y; j++) {
                arrB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(i < X || j < Y){
                    arrA[i][j] = arrB[i][j];
                }
                else{
                    arrA[i][j] = arrB[i][j] - arrA[i-X][j-Y];
                }
            }
        }

        for (int[] temp :
                arrA) {
            for (int temp2 :
                    temp) {
                System.out.print(temp2 + " ");
            }
            System.out.println();
        }

    }
}
