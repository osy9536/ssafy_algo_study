package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b18870 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        ArrayList<CoordiCompress> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(new CoordiCompress(Integer.parseInt(st.nextToken()), i));
        }

        Collections.sort(list);

        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {

            if(i-1 >= 0 && list.get(i).content == list.get(i-1).content){
                list.get(i).AfterSortingIndex = list.get(i-1).AfterSortingIndex;
                continue;
            }

            list.get(i).AfterSortingIndex = cnt;
            cnt++;

        }

        list.sort(new Comparator<CoordiCompress>() {
            @Override
            public int compare(CoordiCompress o1, CoordiCompress o2) {
                return o1.originIndex - o2.originIndex;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).AfterSortingIndex).append(" ");
        }

        System.out.println(sb);
    }
}

class CoordiCompress  implements Comparable<CoordiCompress>{
    int content;
    int originIndex;
    int AfterSortingIndex;

    public CoordiCompress(int content, int originIndex) {
        this.content = content;
        this.originIndex = originIndex;

    }

    @Override
    public int compareTo(CoordiCompress o) {
        return this.content - o.content;
    }
}
