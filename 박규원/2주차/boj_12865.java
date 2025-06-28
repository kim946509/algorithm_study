import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물건의 개수
        int K = Integer.parseInt(st.nextToken()); // 배낭의 최대 무게

        int[] weights = new int[N + 1]; // 물건의 무게 배열
        int[] values = new int[N + 1];  // 물건의 가치 배열
        int[][] dp = new int[N + 1][K + 1]; // DP 테이블: i번째 물건까지 고려했을 때 무게 j에서의 최대 가치

        // 물건의 무게와 가치 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        // DP로 최대 가치 계산
        for (int i = 1; i <= N; i++) { // 각 물건에 대해
            for (int j = 1; j <= K; j++) { // 가능한 모든 무게에 대해
                if (weights[i] <= j) {
                    // i번째 물건을 포함할 수 있는 경우: 포함하는 경우와 포함하지 않는 경우 중 최대값 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                } else {
                    // i번째 물건을 포함할 수 없는 경우: 이전 상태 유지
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 최종 답변: N개의 물건을 고려하고 무게 K일 때의 최대 가치
        System.out.println(dp[N][K]);
    }
}