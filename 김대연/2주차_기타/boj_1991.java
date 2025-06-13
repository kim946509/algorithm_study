import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> friends = graph.get(st.nextToken().charAt(0) - 'A' + 1);
            char lc = st.nextToken().charAt(0);
            char rc = st.nextToken().charAt(0);
            if (lc == '.') {
                friends.add(-1);
            } else {
                friends.add(lc - 'A' + 1);
            }
            if (rc == '.') {
                friends.add(-1);
            } else {
                friends.add(rc - 'A' + 1);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        postVisit(graph, 1, sb);
        sb.append('\n');
        middleVisit(graph, 1, sb);
        sb.append('\n');
        afterVisit(graph, 1, sb);
        System.out.println(sb);
    }

    // 전위
    private static void postVisit(List<List<Integer>> graph, int cur, StringBuilder sb) {
        sb.append((char) (cur + 'A' - 1));
        List<Integer> friends = graph.get(cur);
        if (friends.get(0) != -1) {
            postVisit(graph, friends.get(0), sb);
        }
        if (friends.get(1) != -1) {
            postVisit(graph, friends.get(1), sb);
        }
    }

    // 중위
    private static void middleVisit(List<List<Integer>> graph, int cur, StringBuilder sb) {
        List<Integer> friends = graph.get(cur);
        if (friends.get(0) != -1) {
            middleVisit(graph, friends.get(0), sb);
        }
        sb.append((char) (cur + 'A' - 1));
        if (friends.get(1) != -1) {
            middleVisit(graph, friends.get(1), sb);
        }
    }

    // 후위
    private static void afterVisit(List<List<Integer>> graph, int cur, StringBuilder sb) {
        List<Integer> friends = graph.get(cur);
        if (friends.get(0) != -1) {
            afterVisit(graph, friends.get(0), sb);
        }
        if (friends.get(1) != -1) {
            afterVisit(graph, friends.get(1), sb);
        }
        sb.append((char) (cur + 'A' - 1));

    }
}