import java.util.*;
import java.io.*;

class Main {
    static int N, M; // 보드의 세로(N)와 가로(M) 크기
    static char[][] board; // 보드 상태를 저장하는 2D 배열
    static int[] dx = {0, 0, -1, 1}; // 이동 방향: 왼쪽, 오른쪽, 위, 아래 (x 좌표 변화)
    static int[] dy = {-1, 1, 0, 0}; // 이동 방향: 왼쪽, 오른쪽, 위, 아래 (y 좌표 변화)

    // 보드 상태를 저장하는 클래스 (빨간 구슬, 파란 구슬의 위치와 이동 횟수)
    static class State {
        int rx, ry, bx, by, moves;
        State(int rx, int ry, int bx, int by, int moves) {
            this.rx = rx; // 빨간 구슬의 x 좌표
            this.ry = ry; // 빨간 구슬의 y 좌표
            this.bx = bx; // 파란 구슬의 x 좌표
            this.by = by; // 파란 구슬의 y 좌표
            this.moves = moves; // 현재까지의 이동 횟수
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 보드의 세로 크기 입력
        M = Integer.parseInt(st.nextToken()); // 보드의 가로 크기 입력
        board = new char[N][M]; // 보드 배열 초기화
        
        // 구슬 초기 위치 저장 변수
        int rx = 0, ry = 0, bx = 0, by = 0;
        // 보드 입력 처리 및 구슬 위치 찾기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') { // 빨간 구슬 위치
                    rx = i;
                    ry = j;
                } else if (board[i][j] == 'B') { // 파란 구슬 위치
                    bx = i;
                    by = j;
                }
            }
        }

        // BFS 실행 및 결과 출력
        System.out.println(bfs(rx, ry, bx, by));
    }

    // BFS를 이용해 최소 이동 횟수 계산
    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> queue = new LinkedList<>(); // BFS 큐
        boolean[][][][] visited = new boolean[N][M][N][M]; // 방문 여부 체크 (4D 배열)
        queue.offer(new State(rx, ry, bx, by, 0)); // 초기 상태 추가
        visited[rx][ry][bx][by] = true; // 초기 상태 방문 처리

        while (!queue.isEmpty()) {
            State curr = queue.poll(); // 현재 상태 가져오기
            if (curr.moves > 10) return -1; // 10번 초과 시 실패

            // 네 방향으로 기울이기 시도
            for (int i = 0; i < 4; i++) {
                // 빨간 구슬과 파란 구슬 이동
                int[] nextRed = move(curr.rx, curr.ry, dx[i], dy[i]);
                int[] nextBlue = move(curr.bx, curr.by, dx[i], dy[i]);

                // 파란 구슬이 구멍에 빠지면 실패
                if (board[nextBlue[0]][nextBlue[1]] == 'O') continue;

                // 빨간 구슬이 구멍에 빠지면 성공
                if (board[nextRed[0]][nextRed[1]] == 'O') {
                    if(curr.moves + 1 > 10) return -1;
                    return curr.moves + 1;
                }

                // 구슬이 같은 위치에 있을 경우 위치 조정
                if (nextRed[0] == nextBlue[0] && nextRed[1] == nextBlue[1]) {
                    if (i == 0) { // 왼쪽으로 기울이기
                        if (curr.ry < curr.by) nextBlue[1]++; // 파란 구슬이 뒤에 있으면 한 칸 뒤로
                        else nextRed[1]++; // 빨간 구슬이 뒤에 있으면 한 칸 뒤로
                    } else if (i == 1) { // 오른쪽으로 기울이기
                        if (curr.ry > curr.by) nextBlue[1]--; // 파란 구슬이 뒤에 있으면 한 칸 뒤로
                        else nextRed[1]--; // 빨간 구슬이 뒤에 있으면 한 칸 뒤로
                    } else if (i == 2) { // 위로 기울이기
                        if (curr.rx < curr.bx) nextBlue[0]++; // 파란 구슬이 뒤에 있으면 한 칸 뒤로
                        else nextRed[0]++; // 빨간 구슬이 뒤에 있으면 한 칸 뒤로
                    } else { // 아래로 기울이기
                        if (curr.rx > curr.bx) nextBlue[0]--; // 파란 구슬이 뒤에 있으면 한 칸 뒤로
                        else nextRed[0]--; // 빨간 구슬이 뒤에 있으면 한 칸 뒤로
                    }
                }

                // 새로운 상태가 방문되지 않았다면 큐에 추가
                if (!visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
                    visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
                    queue.offer(new State(nextRed[0], nextRed[1], nextBlue[0], nextBlue[1], curr.moves + 1));
                }
            }
        }
        return -1; // 해결 불가능 시 -1 반환
    }

    // 구슬을 주어진 방향으로 이동시키는 함수
    static int[] move(int x, int y, int dx, int dy) {
        // 벽이나 구멍을 만날 때까지 이동
        while (board[x + dx][y + dy] != '#' && board[x][y] != 'O') {
            x += dx;
            y += dy;
        }
        return new int[]{x, y}; // 최종 위치 반환
    }
}