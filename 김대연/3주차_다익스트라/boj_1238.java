import java.io.*;
import java.util.*;

class Main {
    private static int n;
    private static int m;
    private static int x;

    private static List<Node>[] graph;
    private static List<Node>[] reverseGraph;

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

    private static int[] dijkstra(int start, List<Node>[] graph) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        cost[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;
            int currentCost = current.cost;

            if (currentCost > cost[currentVertex])
                continue;

            for (Node neighbor : graph[currentVertex]) {
                int newCost = currentCost + neighbor.cost;
                int newVertex = neighbor.vertex;
                if (newCost < cost[newVertex]) {
                    cost[newVertex] = newCost;
                    pq.offer(new Node(newVertex, newCost));
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        reverseGraph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, time));
            reverseGraph[to].add(new Node(from, time));
        }

        int[] fromX = dijkstra(x, graph);

        int[] toX = dijkstra(x, reverseGraph);

        int maxCost = 0;
        for (int i = 1; i <= n; i++) {
            int sumCost = toX[i] + fromX[i];
            maxCost = Math.max(maxCost, sumCost);
        }

        System.out.println(maxCost);
    }
}
