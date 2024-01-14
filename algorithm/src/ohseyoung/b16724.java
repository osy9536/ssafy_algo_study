package algorithm.src.ohseyoung;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

// 피리 부는 사나이
// gold 3
public class b16724 {

    static int n, m;
    static char[][] map;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        parents = new int[n * m];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curIdx = i * m + j;
                int nextIdx = findIdx(i, j);
                if (find(curIdx) != find(nextIdx)) {
                    union(curIdx, nextIdx);
                }
            }
        }

        int ans = findSaveZone();
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }

    // 집합의 개수를 카운트
    static int findSaveZone() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < parents.length; i++) {
            set.add(find(i));
        }
        return set.size();
    }

    // parents 배열이 1차원이기 때문에 2차원배열을 1차원배열로 인덱싱
    static int findIdx(int x, int y) {
        int nx = x;
        int ny = y;

        if (map[x][y] == 'U') {
            nx--;
        } else if (map[x][y] == 'D') {
            nx++;
        } else if (map[x][y] == 'L') {
            ny--;
        } else if (map[x][y] == 'R') {
            ny++;
        }

        return nx * m + ny;
    }

    // 주어진 파라미터의 최상위 부모를 찾음
    static int find(int idx) {
        if (parents[idx] == idx) {
            return idx;
        }

        return parents[idx] = find(parents[idx]);
    }

    // 주어진 파라미터들을 묶음
    static void union(int idx1, int idx2) {
        idx1 = find(idx1);
        idx2 = find(idx2);

        if (idx1 > idx2) {
            parents[idx1] = idx2;
        } else {
            parents[idx2] = idx1;
        }
    }
}
