import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int sum = 0;
        int count = 0;
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            if (sum >= s) {
                while (sum > s) {
                    sum -= arr[left];
                    left++;
                }
                if (sum == s) {
                    count++;
                }

            }
        }
        System.out.println(count);
    }
}