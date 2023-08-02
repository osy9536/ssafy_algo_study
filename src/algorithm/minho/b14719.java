package algorithm.minho;

import java.io.IOException;
import java.util.Scanner;

public class b14719 {
    static int x;
    static int y;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        y=sc.nextInt();
        x=sc.nextInt();
        int sum=0;
        int[] arr = new int[501];
        for(int i =0;i<x;i++)
            arr[i]=sc.nextInt();
        for(int i=1;i<x;i++){
            int left =0;
            int right =0;
            for(int j = 0;j<i;j++)
                left = Math.max(arr[j],left);
            for(int j = i+1;j<x;j++)
                right =Math.max(arr[j],right);
            if(left!=0 && right!=0)
                if(arr[i] <left && arr[i] <right)
                    sum+=Math.min(left,right)-arr[i];
        }
        System.out.println(sum);
    }
}
// Math.min(a,b); Math.max(a.b) 에 대한 이해 필요