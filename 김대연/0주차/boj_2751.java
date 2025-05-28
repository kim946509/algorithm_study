import java.io.IOException;
import java.util.Scanner;
import java.io.*;

class Main {

    private static int n;
    private static int arr[];
    private static int tmp[];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        merge_sort(0, n);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
    }

    private static void merge(int start, int end) {
        int mid = (start + end) / 2;
        int lcur = start;
        int rcur = mid;
        int cur = start;

        for (int i = start; i < end; i++) {
            if (rcur == end) {
                tmp[i] = arr[lcur];
                lcur++;
            } else if (lcur == mid) {
                tmp[i] = arr[rcur];
                rcur++;
            } else if (arr[lcur] <= arr[rcur]) {
                tmp[i] = arr[lcur];
                lcur++;
            } else {
                tmp[i] = arr[rcur];
                rcur++;
            }
        }

        for (int i = start; i < end; i++) {
            arr[i] = tmp[i];
        }
    }

    private static void merge_sort(int start, int end) {
        if (end == start + 1)
            return;
        int mid = (start + end) / 2;
        merge_sort(start, mid);
        merge_sort(mid, end);
        merge(start, end);
    }

}