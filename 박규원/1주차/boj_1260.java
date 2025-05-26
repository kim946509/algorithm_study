import java.io.*;
import java.util.*;

class Main {
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static boolean[] visited;
    public static boolean[] b_visited;
    public static StringBuilder sb = new StringBuilder();
    public static StringBuilder b_sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        b_visited = new boolean[n+1];

        for(int i =0;i<n+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0 ;i<m;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st1.nextToken());
            int value = Integer.parseInt(st1.nextToken());

            list.get(key).add(value);
            list.get(value).add(key);
        }

        for(ArrayList<Integer> arr : list){
            Collections.sort(arr);
        }

        dfs(v);
        bfs(v);
        System.out.println(sb.toString());
        System.out.println(b_sb.toString());
    }

    public static void dfs(int node){
        sb.append(node).append(" ");
        visited[node] = true;

        int size = list.get(node).size();

        for(int i=0;i<size;i++){
            int v = list.get(node).get(i);
            if(!visited[v]){
                dfs(v);
            }
        }

    }

    public static void bfs(int node){
        Deque<Integer> q = new LinkedList<>();

        b_visited[node] = true;
        
        q.offerLast(node);
        
        while(!q.isEmpty()){
            int v = q.pop();
            b_sb.append(v).append(" ");
            
            int size = list.get(v).size();

            for(int i=0;i<size;i++){
                int num = list.get(v).get(i);
                if(!b_visited[num]){
                    q.add(num);
                    b_visited[num] = true;
                }
                
            }
            
        }
    }
}