package algorithm.src.soomin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1931 {

    static int N, first, last;
    static int max = 0;
    static MeetingHour [] Meetings;

    static boolean [] flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Meetings = new MeetingHour[N];
        flag = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Meetings[i] = new MeetingHour(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(Meetings);
        Combination(0);

        System.out.println(max);
    }


    public static void Combination (int deepth) {

        if(deepth == N) {
            int cnt = 0;
            for (int i = 0; i < flag.length; i++) {
                if(flag[i]) cnt++;
            }

            max = Math.max(cnt, max);
            first = 0;
            last = 0;
            return;
        }



        if(deepth == 0) {
            flag[deepth] = true;
            first = Meetings[deepth].start;
            last = Meetings[deepth].end;
            Combination(deepth+1);
            flag[deepth] = false;
        }

        if(Meetings[deepth].start >=last){
            flag[deepth]= true;
            last = Meetings[deepth].end;
            Combination(deepth+1);

        }else {
            Combination(deepth+1);
        }
    }

}

class MeetingHour implements Comparable<MeetingHour>{
    int start;
    int end;

    public MeetingHour(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(MeetingHour o) {

        if(this.end == o.end){
            return this.start-o.start;
        }
        return this.end-o.end;
    }
}
