import java.io.*;
import java.util.*;

class Main {
    public static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    public static PriorityQueue<Node> q = new PriorityQueue<>();
    public static int[] d;
    public static int INF = Integer.MAX_VALUE;

    //정점 클래스 초기화
    public static class Node implements Comparable<Node>{
        private int index;
        private int weight;

        public Node(int index, int weight){
            this.index = index;
            this.weight = weight;
        }

        public int getIndex(){
            return this.index;
        }

        public int getWeight(){
            return this.weight;
        }

        @Override
        public int compareTo(Node node){
            if(this.weight < node.getWeight()){
                return -1;
            }
            return 1;
        }
    }

    public static void dijkstra(int start){
        d[start] = 0;
        q.offer(new Node(start, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            int idx = node.getIndex();
            int value = node.getWeight();

            if(d[idx] < value) continue;

            for(int i=0;i<list.get(idx).size();i++){
                int cost = value + list.get(idx).get(i).getWeight();

                if(cost<d[list.get(idx).get(i).getIndex()]){
                    d[list.get(idx).get(i).getIndex()] = cost;
                    q.offer(new Node(list.get(idx).get(i).getIndex(),cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        //그래프 공간 초기화
        for(int i=0;i<=v;i++){
            list.add(new ArrayList<Node>());
        }

        //최단 경로 업데이트할 1차원 배열 초기화
        d = new int[v+1];

        Arrays.fill(d, INF);

        //그래프 값 초기화
        for(int i=0;i<e;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            list.get(Integer.parseInt(st1.nextToken())).add(new Node(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken())));
        }

        dijkstra(k);
        
        for(int i=1;i<=v;i++){
            if(d[i]==INF) System.out.println("INF");
            else System.out.println(d[i]);
        }
    }
}