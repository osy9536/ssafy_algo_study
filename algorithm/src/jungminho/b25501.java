package algorithm.src.jungminho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b25501 {
    static int count=0;
    public static int recursion(String str,int l, int r) {
        count+=1;
        if(l>=r) return 1;
        else if(str.charAt(l)!=str.charAt(r)) return 0;
        else return recursion(str,l+1,r-1);
    }
    public static int isPallindrome(String s) {

        return recursion(s,0,s.length()-1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i<n;i++) {
            count=0;
            System.out.println(isPallindrome(br.readLine())+" "+count);
        }
    }
}
