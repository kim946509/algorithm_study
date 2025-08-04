import java.io.*;
import java.util.*;
import java.awt.Point;

class Main {
    private static int row;
    private static int column;
    private static int[][] board;
    private static int[] dirColumn = { 0, 1, 0, -1 };
    private static int[] dirRow = { -1, 0, 1, 0 };
    private static Queue<Point> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        board = new int[row][column];

        for (int r = 0; r < row; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < column; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                if (board[r][c] == 1) {
                    queue.add(new Point(c, r));
                }
            }
        }

        bfs();

        int value = -1;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (value < board[r][c]) {
                    value = board[r][c];
                }
                if (board[r][c] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(value - 1);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nextRow = p.y + dirRow[dir];
                int nextColumn = p.x + dirColumn[dir];
                if (nextRow < 0 || nextRow >= row || nextColumn < 0 || nextColumn >= column) {
                    continue;
                }
                if (board[nextRow][nextColumn] != 0)
                    continue;
                queue.add(new Point(nextColumn, nextRow));
                board[nextRow][nextColumn] = board[p.y][p.x] + 1;
            }
            // for (int r = 0; r < row; r++) {
            // for (int c = 0; c < column; c++) {
            // System.out.print(board[r][c] + " ");
            // }
            // System.out.println();
            // }
            // System.out.println("-------------");
        }
    }
}