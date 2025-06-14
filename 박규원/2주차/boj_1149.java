import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 집의 수 입력

        // 각 집을 R, G, B로 칠하는 비용을 저장하는 배열
        int[][] cost = new int[N + 1][3];
        // DP 배열: dp[i][j]는 i번째 집을 j색(R:0, G:1, B:2)으로 칠했을 때의 최소 비용
        int[][] dp = new int[N + 1][3];

        // 비용 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // R 비용
            cost[i][1] = Integer.parseInt(st.nextToken()); // G 비용
            cost[i][2] = Integer.parseInt(st.nextToken()); // B 비용
        }

        // DP 초기화: 첫 번째 집의 비용은 주어진 비용 그대로
        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];

        // DP 점화식 계산
        for (int i = 2; i <= N; i++) {
            // i번째 집을 R(0)로 칠할 경우: (i-1)번째 집은 G(1) 또는 B(2)여야 함
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            // i번째 집을 G(1)로 칠할 경우: (i-1)번째 집은 R(0) 또는 B(2)여야 함
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            // i번째 집을 B(2)로 칠할 경우: (i-1)번째 집은 R(0) 또는 G(1)이어야 함
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }

        // N번째 집을 R, G, B로 칠한 경우 중 최소값 출력
        int answer = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
        System.out.println(answer);

    }
}