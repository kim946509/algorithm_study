import java.io.*;
import java.util.*;
import java.awt.Point;

class Main {
    private static List<Point> blank = new ArrayList<>();
    private static int[][] board = new int[9][9];
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static boolean isEnd = false;

    private static void fill(int cur) throws IOException {
        if (cur == blank.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(board[i][j] + " ");
                }
                bw.write("\n");
            }
            isEnd = true;
            return;
        }
        for (int num = 1; num <= 9; num++) {
            Point p = blank.get(cur);
            if (isSatisfied(p.y, p.x, num)) {
                board[p.y][p.x] = num;
                fill(cur + 1);
                if (isEnd) {
                    return;
                }
                board[p.y][p.x] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    blank.add(new Point(j, i));
                }
            }
        }
        fill(0);
        bw.flush();
    }

    private static boolean isSatisfied(int line, int column, int num) {
        // 가로
        for (int i = 0; i < 9; i++) {
            if (board[line][i] == num) {
                return false;
            }
        }
        // 세로
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == num) {
                return false;
            }
        }

        // 같은 칸
        int startLine;
        int startColumn;
        if (line < 3) {
            if (column < 3) {
                startLine = 0;
                startColumn = 0;
            } else if (column < 6) {
                startLine = 0;
                startColumn = 3;
            } else {
                startLine = 0;
                startColumn = 6;
            }

        } else if (line < 6) {
            if (column < 3) {
                startLine = 3;
                startColumn = 0;
            } else if (column < 6) {
                startLine = 3;
                startColumn = 3;
            } else {
                startLine = 3;
                startColumn = 6;
            }
        } else {
            if (column < 3) {
                startLine = 6;
                startColumn = 0;
            } else if (column < 6) {
                startLine = 6;
                startColumn = 3;
            } else {
                startLine = 6;
                startColumn = 6;
            }
        }
        return checkSquare(startLine, startColumn, num);
    }

    private static boolean checkSquare(int startLine, int startColumn, int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startLine + i][startColumn + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}