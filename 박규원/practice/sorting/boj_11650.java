package 박규원.practice.sorting;
import java.io.*;
import java.util.*;

class Main {
    public static class Node implements Comparable<Node>{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }

        @Override
        public int compareTo(Node node){
            if(this.x!=node.x){
                return Integer.compare(this.x, node.getX());
            }
            return Integer.compare(this.y, node.getY());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayList<Node> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        for(Node node : list){
            System.out.println(node.getX() + " " +  node.getY());
        }
    }
}