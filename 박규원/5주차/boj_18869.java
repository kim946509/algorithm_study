import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); //우주의 개수
        int n = Integer.parseInt(st.nextToken()); //행성의 개수

        int[] planet = new int[n];

        ArrayList<String> compress = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> tree = new TreeMap<>();

            for(int j=0;j<n;j++){
                planet[j] = Integer.parseInt(st.nextToken()); //행성 크기 초기화
                tree.put(planet[j], 0); 
            }

            int rank = 0;
            for(int t : tree.keySet()){
                tree.put(t, rank++); //행성 우선순위 기록
            }

            sb = new StringBuilder();
            for(int p : planet){
                sb.append(tree.get(p));
                sb.append(",");
            } //각 행성의 우선순위를 기록

            compress.add(sb.toString()); //압축한 우주의 행성들을 저장
        }

        Map<String, Integer> answer = new TreeMap<>();
        for(String s : compress){
            answer.put(s, answer.getOrDefault(s,0)+1);
        }

        int answer_sum = 0;
        for(String a : answer.keySet()){
            if(answer.get(a)>1){
                int k = answer.get(a);
                answer_sum += k*(k-1)/2;
            }
        }

        System.out.print(answer_sum);
    }
}