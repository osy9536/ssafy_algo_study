package algorithm.src.minho.Solution;

class Solution {
    public int solution(int n) {
        return fibo(n);
    }
    public int fibo(int n){
        int[] num = new int[n+1];
        num[0] = 0;
        num[1] = 1;
        for(int i = 2 ; i <= n ; i++)
            num[i] = (num[i-1]+num[i-2])%1234567;
        return num[n]%1234567;
    }
}