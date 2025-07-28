package 박규원.practice.bruteforcing;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count=0;
        int value=666;

        while(true){

            if(String.valueOf(value).contains("666")){
                count++;
                if(count==n) break;
            }

            value++;
        }

        System.out.println(value);
    }
}