import java.io.IOException;
import java.io.*;
import java.util.*;
import java.awt.Point;

class Main {

    private static int n;
    private static int m;
    private static int[][] board;
    private static int[][] visited;
    private static int minValue = Integer.MAX_VALUE;

    private static int[] dirR = { -1, 0, 1, 0 }; // 시계방향
    private static int[] dirC = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new int[n][m];

        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < m; c++) {
                board[r][c] = line.charAt(c) - '0';
            }
        }

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        visited[0][0] = 1;

        int value = bfs(board, 0, queue, visited);
        if (value > 0 && minValue > value) {
            value = minValue;
        }

        if (minValue == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minValue);
        }
    }

    public static int bfs(int[][] board, int pushCount, Queue<Point> queue, int[][] visited) {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nextR = p.y + dirR[dir];
                int nextC = p.x + dirC[dir];

                // 밖으로 벗어났을 경우
                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) {
                    continue;
                }

                Point nextP = new Point(nextC, nextR);

                // 벽일 경우
                if (board[nextP.y][nextP.x] == 1) {
                    if (pushCount == 0) {

                        // 새로운 visited
                        int[][] newVisited = new int[n][m];
                        for (int r = 0; r < n; r++) {
                            for (int c = 0; c < m; c++) {
                                newVisited[r][c] = visited[r][c];
                            }
                        }

                        // 새로운 큐
                        Queue<Point> newQueue = new ArrayDeque<>(queue);
                        newQueue.add(nextP); // 큐에 넣기
                        newVisited[nextP.y][nextP.x] = visited[p.y][p.x] + 1; // 방문 표시

                        int value = bfs(board, 1, newQueue, newVisited);
                        if (value > 0 && minValue > value) {
                            minValue = value;
                        }
                    }
                    continue;
                }

                // 이미 방문했을경우 continue
                if (visited[nextR][nextC] != 0) {
                    continue;
                }

                visited[nextR][nextC] = visited[p.y][p.x] + 1; // 방문 표시
                queue.add(nextP);
            }
        }

        return visited[n - 1][m - 1];
    }
}