import java.io.*;
import java.util.*;

class Main {
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        for(int i=0;i<k;i++){  
            money(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        for(int i : list){
            sum+=i;
        }

        System.out.println(sum);
    }

    public static void money(int num){
        if(num==0){
            list.remove(list.size()-1);
            return;
        }

        list.add(num);
    }
}