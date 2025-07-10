import java.io.*;
import java.util.*;

class Main {
    public static ArrayList<Integer> stack_list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push")){
                stack("push", Integer.parseInt(st.nextToken()));
            }else{
                stack(command);
            }

        }
    }

    public static void stack(String command, int num){
        stack_list.add(num);
    }

    public static void stack(String command){
        switch(command){
            case "top":
                if(stack_list.size()==0){
                    System.out.println("-1");
                    break;
                }
                System.out.println(stack_list.get(stack_list.size()-1));
                break;
            
            case "pop":
                if(stack_list.size()==0){
                    System.out.println("-1");
                    break;
                }

                System.out.println(stack_list.remove(stack_list.size()-1));
                break;

            case "size":
                System.out.println(stack_list.size());
                break;

            case "empty":
                if(stack_list.isEmpty()) System.out.println("1");
                else System.out.println("0");
                break;

            default:
                break;
        }
        
    }
}