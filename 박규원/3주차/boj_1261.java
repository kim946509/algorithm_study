import java.io.*;
import java.util.*;

class Main {
    public static int[] xd = {0, 0, -1, 1};
    public static int[] yd = {-1, 1, 0, 0};
    public static PriorityQueue<Node> q = new PriorityQueue<>();
    public static int[][] d;
    public static int[][] miro;
    public static int m,n;

    public static class Node implements Comparable<Node>{
        private int x;
        private int y;
        private int value;

        public Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }

        public int getValue(){
            return this.value;
        }

        @Override
        public int compareTo(Node node){
            return Integer.compare(this.value, node.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        miro = new int[n+1][m+1];
        d = new int[n+1][m+1];

        //미로 입력받기
        for(int i=1;i<=n;i++){
            String s = br.readLine(); 

            for(int j=1;j<=m;j++){
                miro[i][j] = s.charAt(j-1) - '0';    
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        dijkstra(1, 1);
        System.out.print(d[n][m]);
    }

    public static void dijkstra(int x, int y){
        d[y][x] = 0;
        q.offer(new Node(x,y,0));

        while(!q.isEmpty()){
            Node node = q.poll();

            int x_pos = node.getX();
            int y_pos = node.getY();
            int value_pos = node.getValue();

            while(d[y_pos][x_pos] < value_pos) continue;

            for(int i=0;i<4;i++){
                if(y_pos+yd[i]>=1 && y_pos+yd[i]<=n && x_pos+xd[i]<=m && x_pos+xd[i]>=1){
                    int cost = d[y_pos][x_pos]+miro[y_pos+yd[i]][x_pos+xd[i]];

                    if(d[y_pos+yd[i]][x_pos+xd[i]]>cost){
                        d[y_pos+yd[i]][x_pos+xd[i]] = cost;
                        q.offer(new Node(x_pos+xd[i], y_pos+yd[i], cost));
                    }
                }
            }

        }

    }
}