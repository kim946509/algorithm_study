import java.io.*;
import java.util.*;

class Main {
    public static class Student implements Comparable<Student>{
        int class_idx;
        int ability;

        public Student(int class_idx, int ability){
            this.class_idx = class_idx;
            this.ability = ability;
        }

        public int getClasses(){
            return this.class_idx;
        }

        public int getAbility(){
            return this.ability;
        }

        @Override
        public int compareTo(Student student){
            return Integer.compare(this.ability, student.getAbility());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Student> list = new ArrayList<>();

        //입력 받기
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                list.add(new Student(i, Integer.parseInt(st.nextToken())));
            }
        }

        Collections.sort(list);

        int[] current_class = new int[n];
        int total_student = 0;

        int left = 0;
        int min_diff = Integer.MAX_VALUE;

        for(int right =0; right<list.size();right++){
            int class_idx = list.get(right).getClasses();

            current_class[class_idx]++;
            if(current_class[class_idx] == 1){
                total_student++;
            }

            while(total_student == n){
                int diff = list.get(right).getAbility() - list.get(left).getAbility();
                min_diff = Math.min(diff, min_diff);

                current_class[list.get(left).getClasses()]--;
                if(current_class[list.get(left).getClasses()] == 0){
                    total_student--;
                }
                left++;
            }
        }

        System.out.println(min_diff);
    }
}