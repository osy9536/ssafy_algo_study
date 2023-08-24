package algorithm.src.junseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b17471 {
    static int N;
    static List<ArrayList<Integer>> list;
    static int[] numPeople;
    static List<Integer> leftSide;
    static List<Integer> rightSide;
    static boolean[] visited;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        numPeople = new int[N];
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numPeople[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int adjArea =  Integer.parseInt(st.nextToken());
            for (int j = 0; j < adjArea; j++) {
                int a = Integer.parseInt(st.nextToken())-1;
                list.get(i).add(a);
                list.get(a).add(i);
            }
        }

        /////////////////////////////////////////////////////////////////////
        rightSide = new ArrayList<>();
        leftSide = new ArrayList<>();
        divide(0);
        if(res == Integer.MAX_VALUE) res = -1;
        System.out.println(res);
    }
    static void divide(int idx){
        if(idx == N){
            if(leftSide.size() == 0 || rightSide.size() == 0) return;
            if(bfs(leftSide) && bfs(rightSide)){
                cal();
            }
            return;
        }
        leftSide.add(idx);
        divide(idx+1);
        leftSide.remove(Integer.valueOf(idx));
        rightSide.add(idx);
        divide(idx+1);
        rightSide.remove(Integer.valueOf(idx));

    }
    static boolean bfs(List<Integer> checkLlst){
        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[N];
        queue.offer(checkLlst.get(0));
        visited[checkLlst.get(0)] = true;
        int cnt = 1;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 0; i < list.get(cur).size(); i++) {
                int y = list.get(cur).get(i);
                if (!visited[y] && checkLlst.contains(y)) {
                    queue.offer(y);
                    visited[y] = true;
                    cnt++;
                }
            }
        }
        return cnt == checkLlst.size();
    }
    static void cal(){
        int left= 0,right = 0;
        for (Integer value : leftSide) {
            left += numPeople[value];
        }
        for (Integer integer : rightSide) {
            right += numPeople[integer];
        }
        res = Math.min(res,Math.abs(left-right));
    }
}

