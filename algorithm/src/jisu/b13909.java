package algorithm.src.jisu;

import java.io.*;

public class b13909 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0; 
        for(int i = 1; i * i <= N; i++) { 
            count++;
        }

        bw.write(count + "\n");

        br.close();

        bw.flush();
        bw.close();
    }


}
