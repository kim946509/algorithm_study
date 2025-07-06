import java.io.*;
import java.util.*;

class Main {

    private static int m;
    private static int n;
    private static int[] snacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        snacks = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = -1;
        for (int i = 0; i < n; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            if (max < snacks[i]) {
                max = snacks[i];
            }
        }

        int start = 1;
        int end = max;
        int value = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (canCut(mid)) {
                start = mid + 1;
                value = mid;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(value);
    }

    private static boolean canCut(int length) {
        int count = 0;
        for (int snack : snacks) {
            count += snack / length;
            if (count >= m) {
                return true;
            }
        }

        return false;
    }

}
