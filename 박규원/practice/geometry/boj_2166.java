package 박규원.practice.geometry;
import java.io.*;
import java.util.*;

class Main {
    public static class Node{
        long x;
        long y;

        public Node(long x, long y){
            this.x = x;
            this.y = y;
        }

        long getX(){
            return x;
        }

        long getY(){
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        double sum = 0;

        ArrayList<Node> list = new ArrayList<>();

        for(int i =0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Node(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken())));
        }


        double sum_fst = 0;
        double sum_sed = 0;
        //신발끈 공식을 사용하여 오목다각형과 볼록다각형의 넓이를 구하기
        //헤일로 공식은 다각형의 넓이를 구하기에는 오목다각형의 넓이를 구하지 못함
        for(int i=0;i<n;i++){
            int idx = (i+1) % n;
            sum_fst += list.get(i).getX()*list.get(idx).getY();
            sum_sed += list.get(i).getY()*list.get(idx).getX();
        }

        double result = Math.abs(sum_fst-sum_sed)/2.0;

        System.out.printf("%.1f", result);

    }
}