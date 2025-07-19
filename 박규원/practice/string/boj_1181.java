import java.io.*;
import java.util.*;

class Main {
    public static class Node implements Comparable<Node>{
        int length;
        String str;

        public Node(int length, String str){
            this.length = length;
            this.str = str;
        }

        public int getLength(){
            return length;
        }

        public String getStr(){
            return str;
        }

        @Override
        public int compareTo(Node node){
            if(this.length != node.getLength()){
                return Integer.compare(this.length, node.getLength());
            }
            
            return this.str.compareTo(node.getStr());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Node> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(int i=0;i<n;i++){
            String str = br.readLine();
            set.add(str);
        }

        for(String s : set){
            list.add(new Node(s.length(), s));
        }

        Collections.sort(list);

        for(Node node : list){
            System.out.println(node.getStr());
        }

    }
}