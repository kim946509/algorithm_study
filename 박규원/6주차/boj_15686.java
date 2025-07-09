import java.io.*;
import java.util.*;

class Main {
    public static ArrayList<Node> home = new ArrayList<>();
    public static ArrayList<Node> chicken_store = new ArrayList<>();
    public static ArrayList<Node> target_chicken_store = new ArrayList<>();
    public static int target_count = 0;
    public static boolean[] check;
    public static int total_city_chicken_distance = Integer.MAX_VALUE;

    public static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        int getX(){
            return x;
        }

        int getY(){
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        check = new boolean[m];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                int value = Integer.parseInt(st.nextToken());
                if(value == 1) home.add(new Node(i,j));
                else if(value == 2) chicken_store.add(new Node(i,j));
                else continue;
            }
        }

        chicken(0, m);

        System.out.println(total_city_chicken_distance);
    }

    public static void chicken(int now, int m){
        if(target_count == m){
            int city_chicken_distance = 0;
            for(Node h : home){
                int min = Integer.MAX_VALUE;
                for(Node t : target_chicken_store){
                    int value = Math.abs(h.getX() - t.getX()) + Math.abs(h.getY() - t.getY());
                    if(value < min){
                        min = value; //치킨거리 구하기
                    }
                }
                city_chicken_distance += min; //도시 치킨 거리 구하기
            }

            if(city_chicken_distance < total_city_chicken_distance){
                total_city_chicken_distance = city_chicken_distance;
            }

            return;
        }

        for(int i=now;i<chicken_store.size();i++){
                target_count++;
                target_chicken_store.add(chicken_store.get(i));
                chicken(i+1,m);
                target_chicken_store.remove(target_chicken_store.size()-1);
                target_count--;
        }

    }
}