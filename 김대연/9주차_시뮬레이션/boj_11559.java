import java.io.IOException;
import java.io.*;
import java.util.*;
import java.awt.Point;

class Main {

    static char[][] board = new char[12][6];
    static boolean[][] visited;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 12; i++) {
            String line = sc.next();
            for (int j = 0; j < 6; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int count = 0;

        while (true) {
            visited = new boolean[12][6];
            boolean isContinue = false;

            for (int y = 0; y < 12; y++) {
                for (int x = 0; x < 6; x++) {
                    if (board[y][x] != '.' && !visited[y][x]) {
                        if (bfs(x, y)) {
                            isContinue = true;
                        }
                    }
                }
            }

            if (!isContinue)
                break;

            drop();
            count++;
        }

        System.out.println(count);
    }

    static boolean bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        List<Point> chainPoints = new ArrayList<>();
        char color = board[y][x];

        queue.add(new Point(x, y));
        visited[y][x] = true;
        chainPoints.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= 6 || ny < 0 || ny >= 12)
                    continue;
                if (!visited[ny][nx] && board[ny][nx] == color) {
                    visited[ny][nx] = true;
                    queue.add(new Point(nx, ny));
                    chainPoints.add(new Point(nx, ny));
                }
            }
        }

        if (chainPoints.size() >= 4) {
            for (Point p : chainPoints) {
                board[p.y][p.x] = '.';
            }
            return true;
        }

        return false;
    }

    static void drop() {
        for (int x = 0; x < 6; x++) {
            Stack<Character> stack = new Stack<>();

            for (int y = 0; y < 12; y++) {
                if (board[y][x] != '.') {
                    stack.push(board[y][x]);
                    board[y][x] = '.';
                }
            }

            int row = 11;
            while (!stack.isEmpty()) {
                board[row][x] = stack.pop();
                row--;
            }
        }
    }
}