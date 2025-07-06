import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] treeHeight = new int[n];
        int maxHeight = -1;
        for (int i = 0; i < n; i++) {
            treeHeight[i] = Integer.parseInt(st.nextToken());
            if (maxHeight < treeHeight[i]) {
                maxHeight = treeHeight[i];
            }
        }

        long lcur = 0;
        long rcur = maxHeight;
        long value = 0;

        while (lcur <= rcur) {
            long height = (lcur + rcur) / 2;
            // 잘려진 나무 높이 계산
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (treeHeight[i] < height) {
                    continue;
                }
                sum += treeHeight[i] - height;
            }

            if (sum >= m) {
                value = height;
                lcur = height + 1;
            } else {
                rcur = height - 1;
            }
        }
        System.out.println(value);
    }
}