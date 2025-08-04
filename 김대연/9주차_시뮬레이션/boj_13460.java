import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {

    private static char[][] board;
    private static int n, m;
    private static int[] dirR = { -1, 1, 0, 0 }; // 상,하,좌,우
    private static int[] dirC = { 0, 0, -1, 1 };

    static class MarbleState {
        int redRow, redCol, blueRow, blueCol, moveCount;

        MarbleState(int redRow, int redCol, int blueRow, int blueCol, int moveCount) {
            this.redRow = redRow;
            this.redCol = redCol;
            this.blueRow = blueRow;
            this.blueCol = blueCol;
            this.moveCount = moveCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        int initialRedRow = 0;
        int initialRedCol = 0;
        int initialBlueRow = 0;
        int initialBlueCol = 0;

        for (int r = 0; r < n; r++) {
            String line = br.readLine();
            for (int c = 0; c < m; c++) {
                board[r][c] = line.charAt(c);
                if (board[r][c] == 'R') {
                    initialRedRow = r;
                    initialRedCol = c;
                    board[r][c] = '.';
                } else if (board[r][c] == 'B') {
                    initialBlueRow = r;
                    initialBlueCol = c;
                    board[r][c] = '.';
                }
            }
        }

        System.out.println(findMinimumMoves(initialRedRow, initialRedCol, initialBlueRow, initialBlueCol));
    }

    private static int findMinimumMoves(int redRow, int redCol, int blueRow, int blueCol) {
        Queue<MarbleState> queue = new ArrayDeque<>();
        Set<String> visitedStates = new HashSet<>();

        queue.add(new MarbleState(redRow, redCol, blueRow, blueCol, 0));
        visitedStates.add(createStateKey(redRow, redCol, blueRow, blueCol));

        while (!queue.isEmpty()) {
            MarbleState currentState = queue.poll();

            if (currentState.moveCount >= 10)
                continue;

            for (int direction = 0; direction < 4; direction++) {
                int[] newRedPosition = moveMarbleUntilStop(currentState.redRow, currentState.redCol, direction);
                int[] newBluePosition = moveMarbleUntilStop(currentState.blueRow, currentState.blueCol, direction);

                if (isMarbleInHole(newBluePosition[0], newBluePosition[1]))
                    continue;

                if (isMarbleInHole(newRedPosition[0], newRedPosition[1])) {
                    return currentState.moveCount + 1;
                }

                if (isSamePosition(newRedPosition, newBluePosition)) {
                    adjustOverlappingMarbles(newRedPosition, newBluePosition,
                            currentState.redRow, currentState.redCol,
                            currentState.blueRow, currentState.blueCol, direction);
                }

                String stateKey = createStateKey(newRedPosition[0], newRedPosition[1],
                        newBluePosition[0], newBluePosition[1]);
                if (!visitedStates.contains(stateKey)) {
                    visitedStates.add(stateKey);
                    queue.add(new MarbleState(newRedPosition[0], newRedPosition[1],
                            newBluePosition[0], newBluePosition[1],
                            currentState.moveCount + 1));
                }
            }
        }

        return -1;
    }

    private static int[] moveMarbleUntilStop(int r, int c, int direction) {
        while (true) {
            int nextR = r + dirR[direction];
            int nextC = c + dirC[direction];

            if (board[nextR][nextC] == '#')
                break;

            r = nextR;
            c = nextC;

            if (board[r][c] == 'O')
                break;
        }

        return new int[] { r, c };
    }

    private static boolean isMarbleInHole(int r, int c) {
        return board[r][c] == 'O';
    }

    private static boolean isSamePosition(int[] pos1, int[] pos2) {
        return pos1[0] == pos2[0] && pos1[1] == pos2[1];
    }

    private static void adjustOverlappingMarbles(int[] redPos, int[] bluePos,
            int originalRedR, int originalRedC,
            int originalBlueR, int originalBlueC, int direction) {
        if (direction == 0) { // 상
            if (originalRedR > originalBlueR)
                redPos[0]++;
            else
                bluePos[0]++;
        } else if (direction == 1) { // 하
            if (originalRedR < originalBlueR)
                redPos[0]--;
            else
                bluePos[0]--;
        } else if (direction == 2) { // 좌
            if (originalRedC > originalBlueC)
                redPos[1]++;
            else
                bluePos[1]++;
        } else { // 우
            if (originalRedC < originalBlueC)
                redPos[1]--;
            else
                bluePos[1]--;
        }
    }

    private static String createStateKey(int redR, int redC, int blueR, int blueC) {
        return redR + "," + redC + "," + blueR + "," + blueC;
    }
}