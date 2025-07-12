import java.io.*;
import java.util.*;

class Main {
    public static Deque<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals( "push")){
                command("push", Integer.parseInt(st.nextToken()));
            }else{
                command(command);
            }
        }
    }

    public static void command(String command){
        switch(command){
            case "pop":
                if(q.isEmpty()) {
                    System.out.println("-1");
                    break;
                }
                System.out.println(q.poll());
                break;

            case "size":
                System.out.println(q.size());
                break;
            
            case "empty":
                if(q.isEmpty()) System.out.println(1);
                else System.out.println(0);
                break;

            case "front":
                if(q.isEmpty()) {
                    System.out.println(-1);
                    break;
                }
                System.out.println(q.peek());
                break;
            
            case "back":
                if(q.isEmpty()) {
                    System.out.println(-1);
                    break;
                }
                System.out.println(q.peekLast());
                break;
        }
    }

    public static void command(String command, int num){
        q.offer(num);
    }
}