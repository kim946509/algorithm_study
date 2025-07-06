import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {

    private static long[] propertyValue;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        propertyValue = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            propertyValue[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(propertyValue);
        long minSum = Long.MAX_VALUE;
        long[] mixed = new long[3];

        for (int i = 0; i < n - 2; i++) {
            long fixed = propertyValue[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = fixed + propertyValue[left] + propertyValue[right];

                if (Math.abs(sum) < minSum) {
                    minSum = Math.abs(sum);
                    mixed[0] = fixed;
                    mixed[1] = propertyValue[left];
                    mixed[2] = propertyValue[right];
                }

                if (sum < 0) {
                    left++;
                } else if (sum == 0) {
                    System.out.println(mixed[0] + " " + mixed[1] + " " + mixed[2]);
                    return;
                } else {
                    right--;
                }
            }
        }

        System.out.println(mixed[0] + " " + mixed[1] + " " + mixed[2]);
    }
}