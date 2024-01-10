import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        list.add(0);

        while(N-->0){
            int val = Integer.parseInt(st.nextToken());
            if(val > list.get(list.size()-1)) list.add(val);
            else{
                int left = 0;
                int right = list.size()-1;
                while(left<right) {
                    int mid = (left+right) >> 1;
                    if (list.get(mid) < val) left = mid+1;
                    if (list.get(mid)>= val) right = mid;
                }
                list.set(right,val);
            }
        }
        System.out.println(list.size()-1);
    }
}
