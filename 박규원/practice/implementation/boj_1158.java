import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1;i<=n;i++){
            list.add(i);
        }

        int idx = k-1;

        while(true){
            if(list.size() == 1) {
                sb.append(list.remove(idx)).append(">");
                break;
            }
            sb.append(list.remove(idx)).append(", ");

            idx = (idx + k - 1) % list.size();
        }

        System.out.println(sb.toString());
    }
}