import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;

        int bestLeft = arr[left];
        int bestRight = arr[right];
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < Math.abs(bestLeft + bestRight)) {
                bestLeft = arr[left];
                bestRight = arr[right];
            }
            if (sum == 0) {
                break;
            } else if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            }
        }
        System.out.println(bestLeft + " " + bestRight);
    }
}