import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i=1;i<=n;i++){
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<");
        int idx = (k-1)%list.size();
        while(true){

            if(list.size() == 1){
                sb.append(list.remove(idx)).append(">");
                break;
            }
            sb.append(list.remove(idx)).append(", ");

            idx+=k-1;
            if(idx > list.size()-1){
                idx %= list.size();
            }
        }

        System.out.println(sb.toString());
    }
}