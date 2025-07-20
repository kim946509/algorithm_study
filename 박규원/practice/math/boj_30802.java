import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> shirt = new ArrayList<>();

        for(int i=0;i<6;i++){
            shirt.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int shirt_sum=0;

        for(int i=0;i<6;i++){
            int value = shirt.get(i)/t;
            if(shirt.get(i)%t > 0) value+=1;
            shirt_sum+=value;
        }

        System.out.println(shirt_sum);

        System.out.print(n/p + " " + n%p);
    }
}