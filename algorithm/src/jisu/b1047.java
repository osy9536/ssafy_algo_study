package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1047 {
    static int n;
    static int[][] tree;
    static List<Integer> garden = new ArrayList<>();
    static TreeSet<Integer> ySet = new TreeSet<>();
    static TreeSet<Integer> xSet = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        tree = new int[n][3];

        int result = n - 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            tree[i][0] = y;
            tree[i][1] = x;
            tree[i][2] = height;

            ySet.add(y);
            xSet.add(x);
        }

        List<Integer> yList = new ArrayList<>(ySet);
        List<Integer> xList = new ArrayList<>(xSet);

        for (int i : ySet) {
            int iIdx = yList.indexOf(i);

            for (int ieIdx = iIdx; ieIdx < yList.size(); ieIdx++) {
                int ie = yList.get(ieIdx);

                for (int j : xSet) {
                    int jIdx = xList.indexOf(j);

                    for (int jeIdx = jIdx; jeIdx < xList.size(); jeIdx++) {
                        int je = xList.get(jeIdx);

                        int ultari = (ie - i + je - j) * 2;
                        int cnt = 0;
                        garden.clear();
                        // 바깥에 있는 애들 더 효율적으로 찾으려면 어떻게 해야 할까
                        for (int k = 0; k < n; k++) {
                            int y = tree[k][0];
                            int x = tree[k][1];
                            int height = tree[k][2];

                            boolean out = y < i || y > ie || x < j || x > je;

                            if (out) {
                                ultari -= height;
                                cnt++;
                            } else {
                                garden.add(height);
                            }
                        }

                        // 다 찾고 합산한 뒤 ultari보다 짧으면 긴 애들부터 잘라봐
                        garden.sort(Collections.reverseOrder());
                        int gIdx = 0;
                        int gardenSize = garden.size();
                        while (ultari > 0 && gIdx < gardenSize) {
                            int num = garden.get(gIdx);
                            ultari -= num;
                            gIdx++;
                            cnt++;
                        }

                        result = Math.min(result, cnt);
                    }
                }
            }
        }
        System.out.println(result);
    }
}
