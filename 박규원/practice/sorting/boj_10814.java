package 박규원.practice.sorting;
import java.io.*;
import java.util.*;

class Main {
    public static class Node implements Comparable<Node>{
        int age;
        String name;

        public Node(int age, String name){
            this.age = age;
            this.name = name;
        }

        int getAge(){
            return age;
        }

        String getName(){
            return name;
        }

        @Override
        public int compareTo(Node node){
            return Integer.compare(this.age, node.getAge());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Node> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        //입력
        for(int i=0;i< n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
        
            list.add(new Node(age, name));
        }

        Collections.sort(list);
    
        for(Node node : list){
            System.out.println(node.getAge() + " " + node.getName());
        }
    }
}