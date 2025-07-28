package 박규원.practice.math;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        int num_idx = 0;
        
        for(int i =0;i<3;i++){
            try{
                n = Integer.parseInt(br.readLine());
                num_idx = i;
                break;
            }catch(Exception e){
                continue;
            }
        }
        
        System.out.println(check_FizzBuzz(n, num_idx));
    }

    public static String check_FizzBuzz(int n, int num_idx){
        int num = n + 3 - num_idx;

        if(num % 15 ==0){
            return "FizzBuzz";
        }

        if(num % 3 ==0){
            return "Fizz";
        }

        if(num % 5 == 0){
            return "Buzz";
        }

        return num+"";
    }
}