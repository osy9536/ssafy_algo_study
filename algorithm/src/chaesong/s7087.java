import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(sc.nextLine());
            String words[] = new String[N];
            for(int i = 0; i < N; i++) {
                words[i] = sc.nextLine();
            }
            Arrays.sort(words);
            int cnt = 0; int prev = 0; int now = 65;
            for(int i = 0; i < N; i++) {
                 if((int)words[i].charAt(0) == now) {
                     cnt++;
                     now++;
                 }
            }
            System.out.println("#"+t+" "+cnt);
        }
    }
}
