import java.util.*;
import java.io.*;

class Main {

    private static Deque<Integer> pocket = new ArrayDeque<>();
    private static int n;
    private static int m;

    private static void backTracking(BufferedWriter bw, int cur) throws IOException {
        if (pocket.size() == m) {
            for (Integer i : pocket) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = cur; i <= n; i++) {
            pocket.addLast(i);
            backTracking(bw, i + 1);
            pocket.removeLast();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        backTracking(bw, 1);
        bw.flush();

    }
}