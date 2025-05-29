import java.io.*;
import java.util.*;

class Main {
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static boolean[] visited;
    public static int[] result;
    public static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        result = new int[n+1];
        answer = new int[n+1];

        int[] count = new int[n+1];


        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }

        //친구 관계 입력
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1) break;

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=1;i<=n;i++){
            int member_count = bfs(i, result);
            answer[i] = member_count;
            //다시 초기화
            for(int j=1;j<=n;j++){
                visited[j] = false;
                result[j] = 0;
            }
        }

        int min = min(answer);
        int count_answer  = 0;
        ArrayList<Integer> arr =new ArrayList<>();

        for(int i = 1; i<=n;i++){
            if(answer[i] == min){
                count_answer++;
                arr.add(i);
            }
        }

        System.out.println(min + " " + count_answer);
        for(int i=0;i<count_answer;i++){
            System.out.print(arr.get(i) + " ");
        }
        
    }

    public static int bfs(int num, int[] result){
        Deque<Integer> q = new LinkedList<>();

        q.offer(num);
        visited[num]= true;

        while(!q.isEmpty()){
            int number = q.poll();
            int size = list.get(number).size();

            for(int i=0;i<size;i++){
                int value = list.get(number).get(i);

                if(!visited[value]){
                    q.offer(value);
                    visited[value] = true;
                    result[value] = result[number]+1;
                }
                
            }
        }
        Arrays.sort(result);
        return result[result.length-1];
    }

    public static int min(int[] answer){
        int size = answer.length;
        int min = answer[1];

        for(int i=1;i<size;i++){
            if(min>answer[i]) min=answer[i];
        }
        return min;
    }
}
