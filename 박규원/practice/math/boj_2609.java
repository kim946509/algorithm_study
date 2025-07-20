import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int max;

        if(a<b){
            max=a;
        }else{
            max=b;
        }

        int gcd=1, lcm=a*b;

        for(int i=max;i>=2;i--){
            if(a%i==0 && b%i==0){
                gcd = i;
                break;
            }
        }

        lcm = a*b/gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}