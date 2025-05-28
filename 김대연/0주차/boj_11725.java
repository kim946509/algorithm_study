import java.io.*;
import java.util.*;

class Main {
    private static List<List<Integer>> tree;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree.get(s).add(e);
            tree.get(e).add(s);
        }
        int[] parent = new int[n + 1];
        bfs(1, parent);
    }

    private static void bfs(int root, int[] parent) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int node : tree.get(num)) {
                if (parent[num] == node)
                    continue;
                queue.add(node);
                parent[node] = num;
            }
        }
        for (int i = 2; i <= n; i++) {
            bw.write(String.valueOf(parent[i]) + "\n");
        }
        bw.flush();
    }
}