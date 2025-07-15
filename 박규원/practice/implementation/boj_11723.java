import java.io.*;
import java.util.*;

class Main {
    public static Set<Integer> set = new HashSet<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("empty")){
                set.clear();
                continue;
            }else if(command.equals("all")){
                
                set.clear();
                set = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
                continue;
            }else{
                command(command, Integer.parseInt(st.nextToken()));
                continue;
            }

        }

        System.out.println(sb.toString());
    }

    public static void command(String command, int num){
        switch(command){
            case "add":
                if(!set.contains(num)){
                    set.add(num);
                }
                break;
            
            case "remove":
                if(set.contains(num)){
                    set.remove(num);
                }
                break;
            
            case "check":
                if(set.contains(num)){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
                break;
            
            case "toggle":
                if(set.contains(num)){
                    set.remove(num);
                }else{
                    set.add(num);
                }
                break;

            default:
                break;
            
        }
    }

}