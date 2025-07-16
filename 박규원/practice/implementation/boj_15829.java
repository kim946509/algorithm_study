import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int r = 31;
        long m = 1234567891;
        long sum = 0;
        long pow = 1;


        for(int i=0;i<l;i++){
            sum = (sum + (str.charAt(i)-'a'+1) * pow % m)%m;
            pow = pow*r%m;
        }

        System.out.println(sum);
    }
}