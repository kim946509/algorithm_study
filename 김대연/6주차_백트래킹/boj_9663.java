import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {

    private static boolean[][] board;
    private static int n;
    private static int count = 0;
    private static int[] dirX = { -1, 0, 1 };
    private static int[] dirY = { -1, -1, -1 };

    private static void putQueen(int line) {

        if (line == n) {
            count++;
            return;
        }

        for (int column = 0; column < n; column++) {
            if (isPut(column, line)) {
                board[line][column] = true;
                putQueen(line + 1);
                board[line][column] = false;
            }
        }

    }

    private static boolean isPut(int posX, int posY) {

        for (int i = 0; i < 3; i++) {
            int y = posY + dirY[i];
            int x = posX + dirX[i];
            while (y >= 0 && x >= 0 && x < n) {
                if (board[y][x]) {
                    return false;
                }
                y = y + dirY[i];
                x = x + dirX[i];
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new boolean[n][n];
        putQueen(0);
        System.out.println(count);
    }
}