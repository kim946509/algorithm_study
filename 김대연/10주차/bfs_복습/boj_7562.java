import java.io.IOException;
import java.util.*;
import java.awt.Point;

class Main {
    private static int[] dirRow = { -2, -2, -1, -1, 1, 1, 2, 2 };
    private static int[] dirColumn = { -1, 1, -2, 2, -2, 2, -1, 1 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();

        for (int t = 0; t < times; t++) {
            int size = sc.nextInt();
            int[][] board = new int[size][size];
            int startRow = sc.nextInt();
            int startColumn = sc.nextInt();
            int goalRow = sc.nextInt();
            int goalColumn = sc.nextInt();

            Queue<Point> queue = new ArrayDeque<>();
            queue.add(new Point(startColumn, startRow));
            board[startRow][startColumn] = 1;
            bfs(queue, board, new Point(goalColumn, goalRow));
            System.out.println(board[goalRow][goalColumn] - 1);
        }
    }

    public static void bfs(Queue<Point> queue, int[][] board, Point goal) {

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.equals(goal)) {
                return;
            }
            for (int dir = 0; dir < 8; dir++) {
                int nextRow = p.y + dirRow[dir];
                int nextColumn = p.x + dirColumn[dir];
                if (nextRow < 0 || nextRow >= board.length || nextColumn < 0 || nextColumn >= board[0].length) {
                    continue;
                }
                if (board[nextRow][nextColumn] != 0) {
                    continue;
                }
                queue.add(new Point(nextColumn, nextRow));
                board[nextRow][nextColumn] = board[p.y][p.x] + 1;
            }
        }
    }
}