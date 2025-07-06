import java.io.*;
import java.util.*;

class Main {

    private static int n;
    private static int[] x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            set.add(x[i]);
        }

        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int cur = Collections.binarySearch(sortedList, x[i]);
            sb.append(cur).append(" ");
        }
        System.out.println(sb);
    }

}