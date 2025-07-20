import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            if(Integer.parseInt(str)==0){
                break;
            }

            if(str.equals(new StringBuilder(str).reverse().toString())){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}