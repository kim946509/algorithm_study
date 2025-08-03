import java.io.*;
import java.util.*;

class Main {

    private static int[][] board;
    private static int[] dirR = { -1, 0, 1, 0 }; // 북,동,남,서
    private static int[] dirC = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int pointR = Integer.parseInt(st.nextToken());
        int pointC = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while (true) {
            boolean isAction = false;
            // 현재 위치 청소
            if (board[pointR][pointC] == 0) {
                board[pointR][pointC] = -1;
                count++;
            }
            // 4방향을 차례로 확인
            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;
                int nextR = pointR + dirR[dir];
                int nextC = pointC + dirC[dir];

                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m)
                    continue;
                if (board[nextR][nextC] == -1 || board[nextR][nextC] == 1) {
                    continue;
                }

                pointR = nextR;
                pointC = nextC;
                isAction = true;
                break;
            }
            // 이미 다음 목적지가 정해졌으므로 continue;
            if (isAction)
                continue;

            // 후진
            int back = (dir + 2) % 4;
            int nextR = pointR + dirR[back];
            int nextC = pointC + dirC[back];

            // 후진 못하면 종료
            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m)
                break;
            if (board[nextR][nextC] == 1)
                break;

            // 방향은 그대로
            pointR = nextR;
            pointC = nextC;
        }
        System.out.println(count);
    }

}