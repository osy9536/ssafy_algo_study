package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class swea_1873 {

    static String [][] field;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <=T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            field = new String[H][W];

            int tankX = 0; int tankY = 0;

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    field[i][j] = String.valueOf(s.charAt(j));

                    if(field[i][j].equals("<") || field[i][j].equals("^")
                            ||field[i][j].equals(">") || field[i][j].equals("v")) {
                        tankX = i; tankY = j;
                    }
                }
            }
            br.readLine();
            String order = br.readLine();

            for (int i = 0; i < order.length(); i++) {
                switchOut:
                switch (order.charAt(i)) {
                    case 'U':
                        field[tankX][tankY] = new String("^");
                        if(tankX-1 >=0 && !(field[tankX-1][tankY].equals("-"))&& !(field[tankX-1][tankY].equals("#"))&& !(field[tankX-1][tankY].equals("*"))) {
                            field[tankX-1][tankY] = new String("^");
                            field[tankX][tankY] = new String(".");
                            tankX = tankX-1;
                        }
                        break switchOut;
                    case 'D':
                        field[tankX][tankY] = new String("v");
                        if(tankX+1 < H && !(field[tankX+1][tankY].equals("-"))&& !(field[tankX+1][tankY].equals("#"))&& !(field[tankX+1][tankY].equals("*")) ) {
                            field[tankX+1][tankY] = new String("v");
                            field[tankX][tankY] = new String(".");
                            tankX = tankX+1;
                        }
                        break switchOut;
                    case 'L':
                        field[tankX][tankY] = new String("<");
                        if(tankY-1 >=0 && !(field[tankX][tankY-1].equals("-"))&& !(field[tankX][tankY-1].equals("#"))&& !(field[tankX][tankY-1].equals("*"))  ) {
                            field[tankX][tankY-1] = new String("<");
                            field[tankX][tankY] = new String(".");
                            tankY = tankY-1;
                        }
                        break switchOut;
                    case 'R':
                        field[tankX][tankY] = new String(">");
                        if(tankY+1 < W  && !(field[tankX][tankY+1].equals("-")) && !(field[tankX][tankY+1].equals("#"))&& !(field[tankX][tankY+1].equals("*"))) {
                            field[tankX][tankY+1] = new String(">");
                            field[tankX][tankY] = new String(".");
                            tankY = tankY+1;
                        }
                        break switchOut;
                    case 'S':
                        shoot(tankX, tankY);
                        break switchOut;
                }
            }

            System.out.printf("#%d ",test_case);
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }


        }
    }

    // 포탄 방향에 따라 포탄이 발사되도록 하는 매소드
    public static void shoot(int x, int y) {
        switch (field[x][y]) {
            case "<":

                for (int i = y-1; i >= 0; i--) {
                    if(field[x][i].equals("*")) {
                        field[x][i] = new String(".");
                        break;
                    }

                    if( field[x][i].equals("#")) {
                        break;
                    }
                }
                break;
            case ">":

                for (int i = y+1; i < field[x].length; i++) {
                    if(field[x][i].equals("*")) {
                        field[x][i] = new String(".");
                        break;
                    }
                    if(field[x][i].equals("#")) break;
                }
                break;
            case "^":

                for (int i = x; i >= 0; i--) {
                    if(field[i][y].equals("*")) {
                        field[i][y] = new String(".");
                        break;
                    }

                    if(field[i][y].equals("#")) break;
                }
                break;
            case "v":


                for (int i = x+1; i < field.length; i++) {
                    if(field[i][y].equals("*")) {
                        field[i][y] = new String(".");
                        break;
                    }
                    if (field[i][y].equals("#")) break;
                }
                break;
        }
    }
}
