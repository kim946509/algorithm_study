import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 코드 작성
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for (int i = 1; i <= n; i++) {
            graph.get(i).sort(Comparator.naturalOrder());
        }

        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] visited = new int[n + 1];
        stack.add(root);
        visited[root] = 1;
        bw.write(root + " ");
        dfs(graph, stack, visited);
        bw.newLine();

        visited = new int[n + 1];
        bfs(graph, root, visited);
        bw.flush();
    }

    public static void dfs(List<List<Integer>> graph, Deque<Integer> stack, int[] visited) throws IOException {
        int visitNode = stack.removeLast();
        List<Integer> nodes = graph.get(visitNode);
        for (int node : nodes) {
            if (visited[node] == 1) {
                continue;
            }
            stack.addLast(node);
            visited[node] = 1;
            bw.write(node + " ");
            dfs(graph, stack, visited);
        }
    }

    public static void bfs(List<List<Integer>> graph, int rootNode, int[] visited) throws IOException {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(rootNode);
        visited[rootNode] = 1;
        bw.write(rootNode + " ");
        while (!queue.isEmpty()) {
            int visitNode = queue.poll();
            List<Integer> nodes = graph.get(visitNode);
            for (int i = 0; i < nodes.size(); i++) {
                int node = nodes.get(i);
                if (visited[node] == 1)
                    continue;
                queue.add(node);
                visited[node] = 1;
                bw.write(node + " ");
            }
        }
    }
}