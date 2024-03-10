package algorithm.src.minho.Solution;

import java.util.Arrays;

public class p최솟값만들기
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0 ; i < A.length ; i++){
            answer+= A[i]*B[A.length-i];
        }





        return answer;
    }
}