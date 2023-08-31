package algorithm.src.ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class s1873 {
    static char[][] map;
    static int N, H, W;
    // 전차 위치
    static int x, y;
    // 명령어
    static String command;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    char s1 = s.charAt(j);
                    map[i][j] = s1;
                    if (s1 == '<' || s1 == '>' || s1 == '^' || s1 == 'v') {
                        x = i;
                        y = j;
                    }
                }
            }
 
            N = Integer.parseInt(br.readLine());
            command = br.readLine();
 
            dfs(command);
            System.out.print("#" + tc + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
 
    static void dfs(String command) {
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c != 'S') {
                move(c);
            } else {
                shoot(map[x][y], x, y);
            }
        }
    }
 
    static void shoot(char c, int x, int y) {
        if (c == '^') {
            if (x-1>=0&&(map[x - 1][y] == '.' || map[x - 1][y] == '-')) {
                shoot(c, x - 1, y);
            } else if (x-1>=0&&map[x - 1][y] == '*') {
                map[x - 1][y] = '.';
                return;
            }
        } else if (c == 'v') {
            if (x+1<H&&(map[x + 1][y] == '.' || map[x + 1][y] == '-')) {
                shoot(c, x + 1, y);
            } else if (x+1<H&&map[x + 1][y] == '*') {
                map[x + 1][y] = '.';
                return;
            }
        } else if (c == '>') {
            if (y+1<W&&(map[x][y + 1] == '.' || map[x][y + 1] == '-')) {
                shoot(c, x, y + 1);
            } else if (y+1<W&&map[x][y + 1] == '*') {
                map[x][y + 1] = '.';
                return;
            }
        } else if (c == '<') {
            if (y-1>=0&&(map[x][y - 1] == '.' || map[x][y - 1] == '-')) {
                shoot(c, x, y - 1);
            } else if (y-1>=0&&map[x][y - 1] == '*') {
                map[x][y - 1] = '.';
                return;
            }
        }
    }
 
    static void move(char c) {
        if (c == 'U') {
            map[x][y] = '^';
            if (x - 1 >= 0 && map[x - 1][y] == '.') {
                map[x][y] = '.';
                map[x - 1][y] = '^';
                x = x - 1;
            }
        }
        if (c == 'D') {
            map[x][y] = 'v';
            if (x + 1 < H && map[x + 1][y] == '.') {
                map[x][y] = '.';
                map[x + 1][y] = 'v';
                x = x + 1;
            }
        }
        if (c == 'L') {
            map[x][y] = '<';
            if (y - 1 >= 0 && map[x][y - 1] == '.') {
                map[x][y] = '.';
                map[x][y - 1] = '<';
                y = y - 1;
            }
        }
        if (c == 'R') {
            map[x][y] = '>';
            if (y + 1 < W && map[x][y + 1] == '.') {
                map[x][y] = '.';
                map[x][y + 1] = '>';
                y = y + 1;
            }
        }
    }
}
