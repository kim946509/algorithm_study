import java.io.IOException;
import java.util.*;
import java.io.*;

class Main {

    private static String startTime;
    private static String endTime;
    private static String streamingEndTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        startTime = st.nextToken();
        endTime = st.nextToken();
        streamingEndTime = st.nextToken();

        Map<String, Integer> attendList = new HashMap<>();

        int count = 0;
        while (true) {
            String line = br.readLine();
            if (line == null || line.length() == 0) {
                break;
            }

            st = new StringTokenizer(line);

            String currentTime = st.nextToken();
            String name = st.nextToken();

            int timeSlot = whatTime(currentTime);

            if (timeSlot == -1) {
                attendList.put(name, 1);
            } else if (timeSlot == 0) {
                continue;
            } else if (timeSlot == 1) {
                int isAttend = attendList.getOrDefault(name, -1);
                if (isAttend == 1) {
                    attendList.put(name, 0);
                    count++;
                } else {
                    continue;
                }
            } else {
                break;
            }

        }
        System.out.println(count);
    }

    // -1 : 이전, 0 : 진행중, 1 : 이후, 2: 완전 종료
    public static int whatTime(String currentTime) {

        // 시작 이전일 경우
        if (isBefore(currentTime, startTime) != 1) {
            return -1;
        }
        // 진행중
        else if (isBefore(currentTime, endTime) == -1) {
            return 0;
        }
        // 이후
        else if (isBefore(currentTime, streamingEndTime) != 1) {
            return 1;
        }
        // 종료
        else {
            return 2;
        }

    }

    // -1 : 이전, 0: 같음, 1: 이후
    public static int isBefore(String currentTime, String baseTime) {
        for (int i = 0; i < 5; i++) {
            if (currentTime.charAt(i) < baseTime.charAt(i)) {
                return -1;
            } else if (currentTime.charAt(i) == baseTime.charAt(i)) {
                continue;
            } else {
                return 1;
            }
        }
        // 시간이 같을 경우
        return 0;
    }
}