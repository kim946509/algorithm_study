import java.io.IOException;
import java.util.*;
import java.io.*;

class Main {
    static int n, m, k;
    static char[][] board;
    static int[][] dir = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 },
            { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 }
    };
    static int[][][] dp;
    static String word;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        List<String> targets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            targets.add(sc.nextLine());
        }

        for (String w : targets) {
            word = w;
            dp = new int[n][m][word.length()];
            for (int[][] mat : dp)
                for (int[] row : mat)
                    Arrays.fill(row, -1);

            int total = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        total += dfs(i, j, 1);
                    }
                }
            }
            System.out.println(total);
        }
    }

    private static int dfs(int x, int y, int depth) {
        if (depth == word.length())
            return 1;
        if (dp[x][y][depth] != -1)
            return dp[x][y][depth];

        int count = 0;
        for (int[] d : dir) {
            int nx = (x + d[0] + n) % n;
            int ny = (y + d[1] + m) % m;
            if (board[nx][ny] == word.charAt(depth)) {
                count += dfs(nx, ny, depth + 1);
            }
        }
        return dp[x][y][depth] = count;
    }
}