import java.util.StringTokenizer;

class p최댓값과최솟값 {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        int maxNum = Integer.MIN_VALUE,minNum = Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(maxNum < num)
                maxNum = num;
            if(minNum > num)
                minNum = num;
        }
        answer = Integer.toString(minNum)+" "+Integer.toString(maxNum);
        return answer;
    }
}