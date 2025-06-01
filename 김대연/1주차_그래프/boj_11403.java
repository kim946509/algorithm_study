import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> input = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int isConnect = Integer.parseInt(st.nextToken());
                if (isConnect == 0)
                    continue;
                input.add(j);
            }
            graph.add(input);
        }

        int[][] answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] visited = new int[n];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int parent = queue.poll();
                List<Integer> childs = graph.get(parent);
                for (int child : childs) {
                    if (visited[child] != 0)
                        continue;
                    queue.add(child);
                    visited[child] = 1;
                }
            }
            answer[i] = visited;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(answer[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}