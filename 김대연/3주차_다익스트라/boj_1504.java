import java.io.*;
import java.util.*;

class Main {

    private static int n;
    private static int e;
    private static List<Node>[] graph;
    private static int[] cost;
    private static int[] beforeVisitNode;

    private static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    private static int[] dijkstra(int start) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(start, 0));
        cost[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            int currentVertex = current.vertex;
            int currentCost = current.cost;

            if (currentCost > cost[currentVertex])
                continue;

            for (Node neighbor : graph[currentVertex]) {
                int newVertex = neighbor.vertex;
                int newCost = currentCost + neighbor.cost;
                if (newCost < cost[newVertex]) {
                    cost[newVertex] = newCost;
                    priorityQueue.offer(new Node(newVertex, newCost));
                }
            }
        }

        return cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        e = Integer.parseInt(stringTokenizer.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());
            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int requiredVertex1 = Integer.parseInt(stringTokenizer.nextToken());
        int requiredVertex2 = Integer.parseInt(stringTokenizer.nextToken());

        int[] fromStart = dijkstra(1);
        int[] fromV1 = dijkstra(requiredVertex1);
        int[] fromV2 = dijkstra(requiredVertex2);

        int path1 = Integer.MAX_VALUE;
        if (fromStart[requiredVertex1] != Integer.MAX_VALUE
                && fromV1[requiredVertex2] != Integer.MAX_VALUE
                && fromV2[n] != Integer.MAX_VALUE) {
            path1 = fromStart[requiredVertex1] + fromV1[requiredVertex2] + fromV2[n];
        }

        int path2 = Integer.MAX_VALUE;
        if (fromStart[requiredVertex2] != Integer.MAX_VALUE
                && fromV2[requiredVertex1] != Integer.MAX_VALUE
                && fromV1[n] != Integer.MAX_VALUE) {
            path2 = fromStart[requiredVertex2] + fromV2[requiredVertex1] + fromV1[n];
        }

        int answer = Math.min(path1, path2);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
