import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {

    static class Applicant {
        int documentRank;
        int interviewRank;

        Applicant(int documentRank, int interviewRank) {
            this.documentRank = documentRank;
            this.interviewRank = interviewRank;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        for (int t = 0; t < testCaseCount; t++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            Applicant[] applicants = new Applicant[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
                int documentRank = Integer.parseInt(tokenizer.nextToken());
                int interviewRank = Integer.parseInt(tokenizer.nextToken());
                applicants[i] = new Applicant(documentRank, interviewRank);
            }

            // 1) 서류 등수 오름차순 정렬 (동점 시 면접 등수 오름차순으로 정렬해도 무방)
            Arrays.sort(applicants, (a, b) -> {
                if (a.documentRank != b.documentRank)
                    return a.documentRank - b.documentRank;
                return a.interviewRank - b.interviewRank;
            });

            // 2) 스캔하며 면접 최소값 갱신 시 선발
            int selectedCount = 0;
            int currentMinInterview = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int interviewRank = applicants[i].interviewRank;
                if (interviewRank < currentMinInterview) {
                    selectedCount++;
                    currentMinInterview = interviewRank;
                }
            }
            System.out.println(selectedCount);
        }
    }
}
