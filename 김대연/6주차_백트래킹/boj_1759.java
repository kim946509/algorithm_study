import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {

    private static int l;
    private static int c;
    private static char[] pocket;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void pickPassword(int cur) throws IOException {
        if (sb.length() == l) {
            if (isSatisfied(sb)) {
                bw.write(sb.toString() + "\n");
            }
            return;
        }

        for (int i = cur; i < c; i++) {
            sb.append(pocket[i]);
            pickPassword(i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer sb = new StringTokenizer(br.readLine());
        l = Integer.parseInt(sb.nextToken());
        c = Integer.parseInt(sb.nextToken());
        pocket = new char[c];
        sb = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            pocket[i] = sb.nextToken().charAt(0);
        }

        Arrays.sort(pocket);

        pickPassword(0);
        bw.flush();
    }

    private static boolean isSatisfied(StringBuilder sb) {
        int count1 = 0; // 자음
        int count2 = 0; // 모음
        char[] moem = { 'a', 'e', 'i', 'o', 'u' };
        for (int i = 0; i < l; i++) {
            int idx = Arrays.binarySearch(moem, sb.charAt(i));
            if (idx >= 0) {
                count2++;
            } else {
                count1++;
            }
        }
        if (count1 >= 2 && count2 >= 1) {
            return true;
        }

        return false;
    }
}