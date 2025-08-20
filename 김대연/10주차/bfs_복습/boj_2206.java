import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    private static int n, m;
    private static int[][] board;

    // 방향 벡터. 시계방향
    private static final int[] dirR = { -1, 0, 1, 0 };
    private static final int[] dirC = { 0, 1, 0, -1 };

    static class State {
        int r, c, broken;

        State(int r, int c, int broken) {
            this.r = r;
            this.c = c;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < m; c++) {
                board[r][c] = line.charAt(c) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        // visited[r][c][0] = 벽 안 부숨, visited[r][c][1] = 벽 부숨
        int[][][] visited = new int[n][m][2];

        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(0, 0, 0));
        visited[0][0][0] = 1; // 시작점 거리 = 1

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            int dist = visited[cur.r][cur.c][cur.broken];

            // 도착지점 도달
            if (cur.r == n - 1 && cur.c == m - 1) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dirR[d];
                int nc = cur.c + dirC[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;

                // 벽이고, 아직 부수지 않은 경우
                if (board[nr][nc] == 1 && cur.broken == 0 && visited[nr][nc][1] == 0) {
                    visited[nr][nc][1] = dist + 1;
                    queue.add(new State(nr, nc, 1));
                }

                // 벽이 아니고, 현재 broken 상태 그대로 방문하지 않았던 경우
                if (board[nr][nc] == 0 && visited[nr][nc][cur.broken] == 0) {
                    visited[nr][nc][cur.broken] = dist + 1;
                    queue.add(new State(nr, nc, cur.broken));
                }
            }
        }

        // 도착 불가능
        return -1;
    }
}