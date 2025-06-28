import java.io.*;
import java.util.*;

class Main {
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static boolean[] visited;
    public static int count = 0;
    public static int time = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];

        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }

        //친구 관계도 입력 받기
        for(int i = 0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs(1);
        System.out.println(count);
    }

    public static void bfs(int num){
        Deque<Integer> q = new LinkedList<>();

        q.offerLast(num);
        visited[num] = true;

        int compare = list.get(num).size();

        while(!q.isEmpty()){
            int top = q.pollFirst();
        
            int size = list.get(top).size();

            for(int i=0;i<size;i++){
                int value = list.get(top).get(i);
                if(!visited[value]) {
                    q.addLast(value);
                    visited[value] = true;
                    count++;
                }
            }
            if(compare == time) break;
            time++;
        }

    }
}