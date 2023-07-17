package algorithm.src.junseo;
import java.util.Scanner;

public class b14719 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt(), W = sc.nextInt();
        int i, j, k;

        int[] arr = new int[W];
        for (i = 0; i < W; i++) {
            arr[i] = sc.nextInt();
        }
        int length = arr.length;
        int sum = 0;
        ////////////////////////////// ////////////////////////////
        for (i = 0; i < length - 1; i++) {
            if (arr[i] <= 0)
                continue; // 왼쪽벽을 찾아야하기 때문에 0은 패스
            for (j = i + 1; j < length; j++) { // 왼쪽 벽을 찾은 후 그 벽의 오른쪽에서 같거나 큰 벽을 찾음
                if (arr[j] >= arr[i])
                    break;
                if (j == length - 1) {
                    arr[i] -= 1;
                    j = i;
                }
            }
            if (j != (i + 1)) {
                for (k = i + 1; k < j; k++) {
                    sum += arr[i] - arr[k];// 왼쪽벽과 오른쪽 벽 사이의 빗물을 계산
                }
                i = j-1;
            }
        }
        System.out.println(sum);
    }
}
