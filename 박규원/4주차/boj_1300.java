import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine()); // 배열 크기
        long k = Long.parseLong(br.readLine()); // k번째 수
        
        long left = 1;
        long right = Math.min(N * N, 1000000000L); // N^2와 10^9 중 작은 값
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            
            // mid 이하의 수 개수 계산
            for (long i = 1; i <= N; i++) {
                count += Math.min(mid / i, N); // i행에서 mid 이하인 수의 개수
            }
            
            if (count >= k) {
                answer = mid; // 가능한 답 저장
                right = mid - 1; // 더 작은 값 탐색
            } else {
                left = mid + 1; // 더 큰 값 탐색
            }
        }
        
        System.out.println(answer);
    }
}