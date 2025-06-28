import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static int[] house;
    private static int n;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int left = 1; // 최소 거리
        int right = house[n - 1] - house[0]; // 가능한 최대 거리
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canInstall(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    // 최소 거리 dist로 설정하면 공유기 설치 가능한지 확인
    private static boolean canInstall(int dist) {
        int count = 1;
        int lastPosition = house[0];

        for (int i = 1; i < n; i++) {
            if (house[i] - lastPosition >= dist) {
                count++;
                lastPosition = house[i];
            }
        }

        if (count >= c) {
            return true;
        }
        return false;
    }
}
