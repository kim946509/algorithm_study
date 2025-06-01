import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());
        for (int c = 0; c < cases; c++) {
            List<List<Integer>> graph = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph.get(start).add(end);
                graph.get(end).add(start);
            }

            boolean isBiPartieGraph = true;
            int[] visited = new int[v + 1];

            for (int i = 1; i <= v; i++) {
                if (visited[i] != 0)
                    continue;

                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(i);
                visited[i] = 1;

                while (!queue.isEmpty()) {
                    int currentNode = queue.poll();
                    int number = visited[currentNode];
                    for (int node : graph.get(currentNode)) {
                        if (visited[node] != 0) {
                            if (visited[node] == number) {
                                isBiPartieGraph = false;
                                break;
                            }
                            continue;
                        }
                        visited[node] = (number == 1) ? 2 : 1;
                        queue.add(node);
                    }
                    if (!isBiPartieGraph)
                        break;
                }

                if (!isBiPartieGraph)
                    break;
            }
            if (isBiPartieGraph) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}