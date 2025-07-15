import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            ArrayList<Integer> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i=0;i<3;i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);

            if(list.get(0) == 0) break;

            if(Math.pow(list.get(0), 2) + Math.pow(list.get(1), 2) == Math.pow(list.get(2),2)){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }

        }
    }
}