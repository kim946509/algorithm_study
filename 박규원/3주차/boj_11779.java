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
            if (this.weight != node.weight) {
                return Integer.compare(this.weight, node.weight); // 가중치 오름차순
            }
            return Integer.compare(this.index, node.index); // 가중치 같으면 정점 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //도시의 개수
        int m = Integer.parseInt(br.readLine()); //버스의 개수

        ArrayList<ArrayList<Node>> list = new ArrayList<>(); //출발, 도착, 비용을 저장할 그래프
        ArrayList<Integer> answer = new ArrayList<>(); //최종 경로를 저장할 공간
        int[] d = new int[n+1];; //최단경로 비용을 저장할 1차원 배열
        int INF = Integer.MAX_VALUE; //초기 d에 저장할 무한대 값 (정수에서 최대값 2,14*,***)
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight)); //우선순위 큐 기반 다익스트라 알고리즘 구현
        int[] prev = new int[n+1];; //이전 경로들을 추적하기 위한 1차원 배열
    
        //그래프 초기화
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        for(int i =0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); //출발도시
            int b = Integer.parseInt(st.nextToken()); //도착도시
            int c = Integer.parseInt(st.nextToken()); //cost

            list.get(a).add(new Node(b, c));
        }
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st1.nextToken()); //최초 출발지
        int end = Integer.parseInt(st1.nextToken()); //최종 도착지

        Arrays.fill(d, INF);
        Arrays.fill(prev, -1);

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
                    prev[list.get(idx).get(i).getIndex()] = idx;
                }
            }
        }

        int current = end;
        answer.add(current);

        while(start!=current){
            current = prev[current];
            answer.add(current);
        }

        Collections.reverse(answer);

        System.out.println(d[end]);
        System.out.println(answer.size());

        for(int i=0;i<answer.size();i++){
            System.out.print(answer.get(i) + " ");
        }
    }
}

