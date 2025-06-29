import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 동굴의 길이
        int H = Integer.parseInt(st.nextToken()); // 동굴의 높이
        
        int[] bottom = new int[H + 1]; // 석순 (아래에서 위로)
        int[] top = new int[H + 1];    // 종유석 (위에서 아래로)
        
        // 입력 처리
        for (int i = 0; i < N / 2; i++) {
            bottom[Integer.parseInt(br.readLine())]++; // 석순 높이
            top[Integer.parseInt(br.readLine())]++;   // 종유석 높이
        }
        
        // 누적합 계산
        int[] bottomSum = new int[H + 1];
        int[] topSum = new int[H + 1];
        
        // 석순: 높이 1부터 H까지 누적
        for (int i = 1; i <= H; i++) {
            bottomSum[i] = bottomSum[i - 1] + bottom[i];
        }
        
        // 종유석: 높이 H부터 1까지 누적
        for (int i = H - 1; i >= 1; i--) {
            topSum[i] = topSum[i + 1] + top[i];
        }
        
        // 최소 장애물 수와 해당 높이 개수 계산
        int minObstacles = Integer.MAX_VALUE;
        int count = 0;
        
        // 높이 1부터 H까지 확인
        for (int h = 1; h <= H; h++) {
            // 해당 높이에서 부딪히는 장애물 수
            // 석순: 높이 h 이상, 종유석: 높이 H-h+1 이상
            int obstacles = bottomSum[H] - bottomSum[h - 1] + topSum[H - h + 1];
            
            if (obstacles < minObstacles) {
                minObstacles = obstacles;
                count = 1;
            } else if (obstacles == minObstacles) {
                count++;
            }
        }
        
        // 결과 출력
        System.out.println(minObstacles + " " + count);
    }
}