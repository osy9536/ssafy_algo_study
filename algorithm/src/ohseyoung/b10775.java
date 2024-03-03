package ohseyoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 공항
// gold 2
public class b10775 {

    static int[] parent;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G+1];
        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }

        int ans = 0;
        for (int i = 0; i < P; i++) {
            int gi = Integer.parseInt(br.readLine());
            int gate = find(gi);

            if (gate == 0) {
                break;
            }

            ans++;
            union(gate, gate-1);
        }

        System.out.println(ans + "\n");
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int na = find(a);
        int nb = find(b);

        if (na == nb) {
            return false;
        }

        if (na < nb) {
            parent[nb] = na;
        }

        if (na > nb) {
            parent[na] = nb;
        }

        return true;
    }
}
