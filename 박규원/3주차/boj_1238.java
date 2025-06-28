import java.io.*;
import java.util.*;

class Main {
    public static int[] d;
    public static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    public static PriorityQueue<Node> q = new PriorityQueue<>();
    public static int[] answer; //최종 왕복 거리를 합산할 1차원 배열

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
            return Integer.compare(this.weight, node.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int m = Integer.parseInt(st.nextToken()); // 도로 수
        int x = Integer.parseInt(st.nextToken()); // 최종 목적지
    

        for(int i = 0; i<=n ;i++){
            list.add(new ArrayList<Node>());
        }

        //도로 입력값들 초기화
        for(int i=0;i<m;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st1.nextToken()); //도로 시작점
            int b = Integer.parseInt(st1.nextToken()); //도로 종점
            int c = Integer.parseInt(st1.nextToken()); //도로 비용

            list.get(a).add(new Node(b,c));
        }

        d = new int[n+1]; //최소 비용을 저장할 1차원 배열
        answer = new int[n+1];

        Arrays.fill(d, Integer.MAX_VALUE);

        for(int i=1;i<=n;i++){
            if(i==x) continue;

            dijkstra(i); //i번 부터 모든 경로까지의 최단 경로를 구하기, 여기서 i->X 로의 최단 경로만 가져기기
            answer[i] = d[x];
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        //최종 종점에서 본인 집으로 돌아가는 최소 비용
        dijkstra(x);

        int max = 0;

        for(int i=1;i<=n;i++){
            if(i==x) continue;
            
            answer[i] += d[i];

            if(max<answer[i]) max = answer[i];
        }

        System.out.print(max);
        
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
                int node_idx = list.get(idx).get(i).getIndex();
                int node_value = list.get(idx).get(i).getWeight();
                int cost = d[idx] + node_value;
                if(d[node_idx] > cost){
                    d[node_idx] = cost;
                    q.offer(new Node(node_idx, cost));
                }
            }
        }
    }


}