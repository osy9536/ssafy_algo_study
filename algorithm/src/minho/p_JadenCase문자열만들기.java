class p_JadenCase문자열만들기 {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        for(int i=0; i<arr.length; i++) {
            String now = arr[i];
            if(arr[i].length() == 0) {
                answer += " ";
            }
            else {
                answer += now.substring(0, 1).toUpperCase();
                answer += now.substring(1, now.length()).toLowerCase();
                answer += " ";
            }
        }
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }
        return answer.substring(0, answer.length()-1);
    }
}