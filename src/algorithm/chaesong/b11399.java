package algorithm.chaesong;

import java.util.Arrays;
import java.util.Scanner;

public class b11399 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int people[] = new int[N];
        for(int i = 0; i < N; i++){
            people[i] = Integer.parseInt(sc.next());
        }
        Arrays.sort(people);

        int hap = 0;
        int prev = 0;

        for(int i = 0; i < N; i++){
            prev += people[i];
            hap += prev;
        }
        System.out.println(hap);
    }
}
