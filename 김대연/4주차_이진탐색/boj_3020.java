import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] stalagmite = new int[h + 2]; // 석순
        int[] stalactite = new int[h + 2]; // 종유석

        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                // 석순: 높이 1부터 length까지 충돌 (즉, length 이하에서 충돌)
                stalagmite[1]++;
                stalagmite[length + 1]--;
            } else {
                // 종유석: 높이 (h-length+1)부터 h까지 충돌
                int startHeight = h - length + 1;
                stalactite[startHeight]++;
                stalactite[h + 1]--;
            }
        }

        // 누적합 계산
        for (int i = 1; i <= h; i++) {
            stalagmite[i] += stalagmite[i - 1];
            stalactite[i] += stalactite[i - 1];
        }

        int minCrash = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 1; i <= h; i++) {
            int crash = stalagmite[i] + stalactite[i];

            if (crash < minCrash) {
                minCrash = crash;
                count = 1;
            } else if (crash == minCrash) {
                count++;
            }
        }

        System.out.println(minCrash + " " + count);
    }
}