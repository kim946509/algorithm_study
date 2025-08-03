import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {

    static final String TARGET = "123456780";

    static int[][] move = {
            { 1, 3 },
            { 0, 2, 4 },
            { 1, 5 },
            { 0, 4, 6 },
            { 1, 3, 5, 7 },
            { 2, 4, 8 },
            { 3, 7 },
            { 4, 6, 8 },
            { 5, 7 }
    };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // 퍼즐 입력받기 (0은 빈칸)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(sc.nextInt());
            }
        }

        String start = sb.toString();
        System.out.println(bfs(start));
    }

    private static int bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>();

        queue.offer(start);
        dist.put(start, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int zeroIndex = current.indexOf('0');

            if (current.equals(TARGET)) {
                return dist.get(current);
            }

            for (int next : move[zeroIndex]) {
                String nextState = swap(current, zeroIndex, next);

                if (!dist.containsKey(nextState)) {
                    dist.put(nextState, dist.get(current) + 1);
                    queue.offer(nextState);
                }
            }
        }

        return -1;
    }

    private static String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}