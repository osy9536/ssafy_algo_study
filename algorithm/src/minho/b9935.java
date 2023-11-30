package algorithm.src.minho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom  = br.readLine();

        int boomSize = boom.length();

        Stack<Character> st = new Stack<>();

        for(int i = 0; i<str.length(); i++){
            st.push(str.charAt(i));

            if(st.size() >= boomSize) {
                boolean flag = true;

                for(int j = 0 ; j < boomSize ; j++){
                    if(st.get(st.size()-boomSize+j) != boom.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int j = 0 ; j < boomSize ; j++){
                        st.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : st){
            sb.append(c);
        }
        System.out.println(sb.length()==0? "FRULA" : sb.toString());
    }
}