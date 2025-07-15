import java.io.*;
import java.util.*;

class Main {
    public static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            if(isPrime(Integer.parseInt(st.nextToken()))){
                sum+=1;
            }
        }

        System.out.println(sum);
    }

    public static boolean isPrime(int num){
        if(num<=1) return false;
        for(int i=2 ; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        return true;
    }
}