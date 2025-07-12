import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String s = br.readLine();
            vps_check(s);
        }
    }

    public static void vps_check(String s){
        ArrayList<String> left_ps = new ArrayList<>();
        
        String[] arr = s.split("");

        if(arr[0].equals(")")){
            System.out.println("NO");
            return;
        }

        for(String str : arr){
            if(str.equals("(")){
                left_ps.add(str);
                continue;
            }
            
            if(str.equals(")") && left_ps.size()>0){
                left_ps.remove(left_ps.size()-1);
                continue;
            }

            if(str.equals(")") && left_ps.size()==0){
                System.out.println("NO");
                return;
            }
        }

        if(left_ps.size()>0){
            System.out.println("NO");
            return;
        }
        
        System.out.println("YES");

    }
}