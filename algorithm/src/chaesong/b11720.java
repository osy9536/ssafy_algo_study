package algorithm.src.chaesong;

import java.util.Scanner;

public class b11720 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //N값 입력받기
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(int i = 0; i < cNum.length; i++){
            sum += cNum[i];
        }
        System.out.print(sum);
        }
}
