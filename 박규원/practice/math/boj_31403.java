import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int a_Plus_b = Integer.parseInt((a+""+b)); 

        System.out.println(a+b-c);
        System.out.println(a_Plus_b - c);
    }
}