import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> students = new LinkedHashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        for(int i=0;i<l;i++){
            String str = br.readLine();
            if(students.contains(str)){
                students.remove(str);
            }
            students.add(str);
        }

        // 출력하는 다른 방법
        Iterator<String> iterator = students.iterator();

        for(int i=0;i<k;i++){
            if(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
        

        // 출력하는 다른 방법
        // int idx = 0;
        // for(String s : students){
        //     if(idx == 3) break;
        //     System.out.println(s);
        //     idx++;
        // }


    }
}