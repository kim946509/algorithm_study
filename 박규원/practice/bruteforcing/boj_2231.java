import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int answer = 0;

        for(int i=1;i<=n;i++){
            String str = i + "";
            int length = str.length();
            int value = 0;

            for(int j=0;j<length;j++){
                value += (str.charAt(j) - '0');
            }
            
            if((i + value) == n) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}