package 박규원.practice.implementation;
import java.io.*;
import java.util.*;

class Main {
    public static class Node{
        int x,y;

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
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Node> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        for(int i=0;i<n;i++){
            int count = 1; //나보다 덩치가 큰사람
            int x = list.get(i).getX();
            int y = list.get(i).getY();

            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(x<list.get(j).getX() && y<list.get(j).getY()){
                    count++; //나보다 덩치가 큰사람
                }
            }

            System.out.print(count + " ");
        }

    }
}
