package algorithm.src.ohseyoung;

import java.io.*;

// 수 정렬하기2
public class b2751 {
    public static int[] a, tmp;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        a = new int[N + 1];
        tmp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(1, N);
        for (int i = 1; i <= N; i++) {
            bw.write(a[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int s, int e) {
        if(e-s<1) return;
        int m = s + (e - s) / 2;
        mergeSort(s, m);
        mergeSort(m + 1, e);
        for (int i = s; i <= e; i++) {
            tmp[i] = a[i];
        }
        int k = s;
        int idx1 = s;
        int idx2 = m + 1;
        while (idx1 <= m && idx2 <= e) {
            if (tmp[idx1] > tmp[idx2]) {
                a[k] = tmp[idx2];
                k++;
                idx2++;
            } else {
                a[k] = tmp[idx1];
                k++;
                idx1++;
            }
        }
        while (idx1 <= m) {
            a[k] = tmp[idx1];
            k++;
            idx1++;
        }
        while (idx2 <= e) {
            a[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}
