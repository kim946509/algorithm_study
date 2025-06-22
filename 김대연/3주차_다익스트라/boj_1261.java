import java.io.*;
import java.util.*;

class Main {

    private static int rowCount;
    private static int colCount;
    private static int[][] board;
    private static int[][] cost;

    // 상, 우, 하, 좌
    private static final int[] dirR = { -1, 0, 1, 0 };
    private static final int[] dirC = { 0, 1, 0, -1 };

    private static class Node implements Comparable<Node> {
        int row;
        int col;
        int cost;

        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        cost[1][1] = 0;
        pq.offer(new Node(1, 1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int row = current.row;
            int col = current.col;
            int currentCost = current.cost;

            if (currentCost > cost[row][col])
                continue;

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + dirR[direction];
                int nextCol = col + dirC[direction];

                if (nextRow < 1 || nextCol < 1 || nextRow > rowCount || nextCol > colCount) {
                    continue;
                }

                int nextCost = currentCost + board[nextRow][nextCol]; // 1: 벽, 0: 빈칸
                if (nextCost < cost[nextRow][nextCol]) {
                    cost[nextRow][nextCol] = nextCost;
                    pq.offer(new Node(nextRow, nextCol, nextCost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        colCount = Integer.parseInt(stringTokenizer.nextToken()); // M
        rowCount = Integer.parseInt(stringTokenizer.nextToken()); // N

        board = new int[rowCount + 1][colCount + 1];
        cost = new int[rowCount + 1][colCount + 1];

        for (int i = 1; i <= rowCount; i++) {
            String line = bufferedReader.readLine();
            for (int j = 1; j <= colCount; j++) {
                board[i][j] = line.charAt(j - 1) - '0';
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        dijkstra();
        System.out.println(cost[rowCount][colCount]);
    }
}
