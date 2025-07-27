import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] classes = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                classes[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.sort(classes[i]);
        }

        int[] cur = new int[n];
        int minValue = Integer.MAX_VALUE;

        while (true) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int minClass = 0;
            for (int i = 0; i < n; i++) {

                if (min > classes[i][cur[i]]) {
                    min = classes[i][cur[i]];
                    minClass = i;
                }
                if (max < classes[i][cur[i]]) {
                    max = classes[i][cur[i]];
                }

            }
            if (max - min < minValue) {
                minValue = max - min;
            }

            if (cur[minClass] + 1 >= m) {
                break;
            }

            cur[minClass] += 1;
        }

        System.out.println(minValue);
    }
}