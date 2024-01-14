package algorithm.src.junseo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = 0; i <N; i++) {
            for (int j = i; j <N; j++) {
                list.add(arr[i]+arr[j]);
            }
        }
        list.sort((o1,o2) -> o1-o2);

        for (int i = N-1; i >=0 ; i--) {
            for (int j = 0; j < N; j++) {
                if(binary_search(list,arr[i]-arr[j])){
                    System.out.println(arr[i]);
                    return;
                }

            }
        }


    }

    private static boolean binary_search(List<Integer> list, int val) {
        int st = 0;
        int end = list.size()-1;
        int mid = 0;
        while(st<end){
            mid = (st+end)/2;

            if(list.get(mid)>val){
                end = mid-1;
            }
            else if (list.get(mid)<val){
                st = mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}



