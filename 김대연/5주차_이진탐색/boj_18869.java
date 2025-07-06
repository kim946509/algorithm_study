import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {

    private static int m;
    private static int n;
    private static int[][] sizes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        sizes = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sizes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int[] rank = getRankArray(sizes[i]);
            String key = Arrays.toString(rank);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int result = 0;
        for (int count : map.values()) {
            if (count > 1) {
                result += (count * (count - 1)) / 2;
            }
        }

        System.out.println(result);
    }

    private static int[] getRankArray(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int value : sortedArr) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank++);
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}