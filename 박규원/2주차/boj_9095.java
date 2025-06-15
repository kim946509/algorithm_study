import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] list = new int[11];
        list[1] = 1;
        list[2] = 2;
        list[3] = 4;

        for(int i=4;i<=10;i++){
            list[i] = list[i-3] + list[i-2] + list[i-1];
        }

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());

            System.out.println(list[n]);
        }
    }
}