import java.io.*;
import java.util.*;

class Main {
    private static PriorityQueue<Integer> pq;
    private static int n;
    private static int m;
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

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        cost[start] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;
            int currentCost = current.cost;

            if (currentCost > cost[currentVertex])
                continue;
            if (currentVertex == end) {
                return;
            }
            for (Node neighbor : graph[currentVertex]) {
                int newCost = cost[currentVertex] + neighbor.cost;
                int newVertex = neighbor.vertex;
                if (newCost < cost[newVertex]) {
                    cost[newVertex] = newCost;
                    pq.offer(new Node(newVertex, newCost));
                    beforeVisitNode[newVertex] = currentVertex;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        beforeVisitNode = new int[n + 1];

        StringTokenizer st;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
        // for (int i = 1; i <= n; i++) {
        // System.out.printf("cost %d: %d\n", i, cost[i]);
        // }
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = end;
        stack.add(cur);

        while (true) {
            if (beforeVisitNode[cur] == 0)
                break;
            stack.add(beforeVisitNode[cur]);
            cur = beforeVisitNode[cur];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(cost[end] + "\n");
        bw.write(stack.size() + "\n");
        while (!stack.isEmpty()) {
            bw.write(stack.pollLast() + " ");
        }
        bw.flush();

    }
}