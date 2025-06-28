import java.io.*;
import java.util.*;

class Main {
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
            return Integer.compare(this.weight, node.getWeight());
        }
    }
    
    public static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    public static int[] d;
    public static PriorityQueue<Node> q = new PriorityQueue<>();
    public static int stopA; //거쳐가는 첫번째 점
    public static int stopB; //거쳐가는 두번째 점


    public static void dijkstra(int start){
        d[start] = 0;
        q.offer(new Node(start, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            int idx = node.getIndex();
            int value = node.getWeight();

            if(d[idx] < value) continue;

            for(int i=0;i<list.get(idx).size();i++){
                int cost = d[idx] + list.get(idx).get(i).getWeight();

                if(d[list.get(idx).get(i).getIndex()] > cost){
                    d[list.get(idx).get(i).getIndex()] = cost;
                    q.offer(new Node(list.get(idx).get(i).getIndex(), cost));
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st2.nextToken());
        int e = Integer.parseInt(st2.nextToken());

        //정점을 저장할 그래프 초기화
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<Node>());
        }

        d = new int[n+1];

        //정점에 대한 정보 초기화
        for(int i=0;i<e;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b,c));
            list.get(b).add(new Node(a,c));
        }

        //반드시 거쳐야할 두 개의 정점을 저장
        StringTokenizer st1= new StringTokenizer(br.readLine());

        stopA = Integer.parseInt(st1.nextToken()); 
        stopB = Integer.parseInt(st1.nextToken());

        Arrays.fill(d, Integer.MAX_VALUE);

        int[] answer = new int[2];



        dijkstra(1);

        if(d[stopA] == Integer.MAX_VALUE){
            System.out.print(-1);
            return;
        }else answer[0]+=d[stopA];

        Arrays.fill(d, Integer.MAX_VALUE);

        dijkstra(stopA);

        if(d[stopB] == Integer.MAX_VALUE){
            System.out.print(-1);
            return;
        }else answer[0]+=d[stopB];

        Arrays.fill(d, Integer.MAX_VALUE);

        dijkstra(stopB);

        if(d[n] == Integer.MAX_VALUE){
            System.out.print(-1);
            return;
        }else answer[0]+=d[n];

        
        Arrays.fill(d, Integer.MAX_VALUE);


        dijkstra(1);

        if(d[stopB] == Integer.MAX_VALUE){
            System.out.print(-1);
            return;
        }else answer[1]+=d[stopB];

        Arrays.fill(d, Integer.MAX_VALUE);

        dijkstra(stopB);

        if(d[stopA] == Integer.MAX_VALUE){
            System.out.print(-1);
            return;
        }else answer[1]+=d[stopA];

        Arrays.fill(d, Integer.MAX_VALUE);

        dijkstra(stopA);

        if(d[n] == Integer.MAX_VALUE){
            System.out.print(-1);
            return;
        }else answer[1]+=d[n];

        System.out.println(Math.min(answer[0], answer[1]));
    }

}