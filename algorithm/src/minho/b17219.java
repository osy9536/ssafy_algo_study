
package algrogithm.src.minho;
import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int NUMBER_OF_SITE = Integer.parseInt(st.nextToken());
        final int NUMBER_OF_REQUEST = Integer.parseInt(st.nextToken());
        
        HashMap<String,String> site = new HashMap<String,String>();
        for(int i=0;i<NUMBER_OF_SITE;i++) {
            st = new StringTokenizer(br.readLine());
            site.put(st.nextToken(), st.nextToken());
        }
        for(int i=0;i<NUMBER_OF_REQUEST;i++) {
            bw.write(site.get(br.readLine())+"\n");
        }

       
        bw.flush();
	br.close();
	bw.close();
        
        
    }

 
}