import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        Map<Long, Integer> abSumMap = new HashMap<>();
        Map<Long, Integer> cdSumMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long ab = a[i] + b[j];
                abSumMap.put(ab, abSumMap.getOrDefault(ab, 0) + 1);

                long cd = c[i] + d[j];
                cdSumMap.put(cd, cdSumMap.getOrDefault(cd, 0) + 1);
            }
        }

        long count = 0;
        for (Map.Entry<Long, Integer> entry : abSumMap.entrySet()) {
            long abSum = entry.getKey();
            int abCount = entry.getValue();

            long cdSum = -abSum;
            if (cdSumMap.containsKey(cdSum)) {
                count += (long) abCount * cdSumMap.get(cdSum);
            }
        }
        System.out.println(count);
    }
}