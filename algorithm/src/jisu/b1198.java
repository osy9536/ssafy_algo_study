package algorithm.src.jisu;

import java.io.*;
import java.util.*;

public class b1198 {
	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] coordinate = reader.readLine().split(" ");
            points[i][0] = Integer.parseInt(coordinate[0]);
            points[i][1] = Integer.parseInt(coordinate[1]);
        }

        double max = 0;
        for (int a = 0; a < n - 2; a++) {
            for (int b = a + 1; b < n - 1; b++) {
                for (int c = b + 1; c < n; c++) {
                    max = Math.max(max, area(points[a], points[b], points[c]));
                }
            }
        }

        writer.write(Double.toString(max));
        reader.close();
        writer.close();
    }

    private static double area(int[] a, int[] b, int[] c) {
        return (double) Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[1] * b[0] - b[1] * c[0] - c[1] * a[0]) / 2;
    }
}