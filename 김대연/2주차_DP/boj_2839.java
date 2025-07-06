import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pocket = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min1;
            int min2;

            if (i < 3) {
                min1 = -1;
            } else {
                min1 = pocket[i - 3];
            }
            if (i < 5) {
                min2 = -1;
            } else {
                min2 = pocket[i - 5];
            }

            if (min1 == -1 && min2 == -1) {
                pocket[i] = -1;
                continue;
            }

            if (min1 != -1 && min2 != -1) {
                pocket[i] = Math.min(min1, min2) + 1;
                continue;
            }

            if (min1 == -1) {
                pocket[i] = min2 + 1;
            } else if (min2 == -1) {
                pocket[i] = min1 + 1;
            }
        }
        System.out.println(pocket[n]);
    }
}