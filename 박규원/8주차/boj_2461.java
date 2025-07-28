import java.io.*;
import java.util.*;

public class Main {
    static class Student implements Comparable<Student> {
        int value; // 능력치
        int classIdx; // 학급 번호

        Student(int value, int classIdx) {
            this.value = value;
            this.classIdx = classIdx;
        }

        @Override
        public int compareTo(Student other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 학급 수
        int M = Integer.parseInt(st.nextToken()); // 각 학급의 학생 수
        
        // 모든 학생을 하나의 리스트에 저장
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                students.add(new Student(value, i));
            }
        }
        
        // 능력치 기준으로 정렬
        Collections.sort(students);
        
        // 슬라이딩 윈도우를 위한 변수
        int[] classCount = new int[N]; // 각 학급에서 선택된 학생 수
        int uniqueClasses = 0; // 윈도우 내 선택된 학급 수
        int minDiff = Integer.MAX_VALUE;
        
        int left = 0;
        for (int right = 0; right < students.size(); right++) {
            // 오른쪽 포인터에서 학생 추가
            int classIdx = students.get(right).classIdx;
            classCount[classIdx]++;
            if (classCount[classIdx] == 1) {
                uniqueClasses++;
            }
            
            // 모든 학급에서 한 명 이상 선택된 경우
            while (uniqueClasses == N) {
                // 현재 윈도우의 능력치 차이 계산
                int diff = students.get(right).value - students.get(left).value;
                minDiff = Math.min(minDiff, diff);
                
                // 왼쪽 포인터 이동
                int leftClassIdx = students.get(left).classIdx;
                classCount[leftClassIdx]--;
                if (classCount[leftClassIdx] == 0) {
                    uniqueClasses--;
                }
                left++;
            }
        }
        
        System.out.println(minDiff);
    }
}