import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = "666";

        if(n == 1) {
            System.out.println(666);
            return;
        }

        if(n < 7){
            System.out.println((n-1) + s);
            return;
        }

        StringBuilder plus_s = new StringBuilder("666");
        int count = 7;
        while(true){

            for(int i=0;i<=9;i++){
                plus_s.append(i);
                if(count == n){
                    System.out.println(plus_s);
                    return;
                }
                plus_s.deleteCharAt(plus_size()-1);
                count++;
            }

            for(int i= )

        }

    }
}