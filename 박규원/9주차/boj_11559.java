import java.io.*;
import java.util.*;

class Main {
    public static ArrayList<ArrayList<Character>> list = new ArrayList<>();

    public static boolean[][] check;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    

    public static class Node{
        private int x;
        private int y;
        private char ch;

        public Node(int x, int y, char ch){
            this.x = x;
            this.y = y;
            this.ch = ch;
        }

        public int getX(){return x;}
        public int getY(){return y;}
        public char getCh(){return ch;}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력받기
        for(int i=0;i<12;i++){
            String str = br.readLine();
            list.add(new ArrayList<>());
            for(int j=0;j<6;j++){
                list.get(i).add(str.charAt(j));
            }
        }

        int chains = 0;

        while(true){
            boolean burst = false;
            check = new boolean[12][6];

            for(int i=0;i<12;i++){
                for(int j=0;j<6;j++){
                    if(list.get(i).get(j) != '.' && !check[i][j]){
                        if(bfs(new Node(i, j, list.get(i).get(j)))){
                            burst = true;
                        }
                    }
                }
            }

            if(!burst) break;
            chains++;
            applyGravity(); //중력 적용
        }
        System.out.println(chains);

    }

    //bfs로 터질수 있는 뿌요들 찾기
    public static boolean bfs(Node node){
        ArrayList<Node> puyo_boom = new ArrayList<>();
        Deque<Node> q = new ArrayDeque<>();
        q.offer(node);
        puyo_boom.add(node);
        check[node.getX()][node.getY()] = true;

        while(!q.isEmpty()){
            Node n = q.poll();
            char ch = n.getCh();
            int x = n.getX();
            int y = n.getY();

            for(int i=0;i<4;i++){
                //범위를 벗어나면 안됨
                if(x+dx[i]<0 || x+dx[i] > 11 || y+dy[i]<0 || y+dy[i]>5) continue;
                
                //같은 색의 노드들만 선택하도록 함
                if(!check[x+dx[i]][y+dy[i]] && list.get(x+dx[i]).get(y+dy[i]) == ch){
                    q.offer(new Node(x+dx[i], y+dy[i], ch));
                    puyo_boom.add(new Node(x+dx[i], y+dy[i], ch));
                    check[x+dx[i]][y+dy[i]] = true;
                }
            }

        }

        if(puyo_boom.size()>=4){
            for(Node pb : puyo_boom){
                list.get(pb.getX()).set(pb.getY(), '.');
            }
            return true;
        }
        return false;
    }

    //뿌요를 터뜨린 후 뿌요들을 모두 밑으로 내리기
    public static void applyGravity(){
        for(int j=0;j<6;j++){
            int empty = 11;
            for(int i=11;i>=0;i--){
                if(list.get(i).get(j) != '.'){
                    if(empty != i){
                        list.get(empty).set(j, list.get(i).get(j));
                        list.get(i).set(j, '.');
                    }
                    empty--;
                }
            }
        }
    }
    
}