import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Map<String, Integer> orderMap = new HashMap<>();
        List<String> records = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            String number = br.readLine();
            if (orderMap.get(number) == null) {
                orderMap.put(number, 1);
            } else {
                orderMap.put(number, orderMap.get(number) + 1);
            }
            records.add(number);
        }
        List<String> passedList = new ArrayList<>();
        for (String record : records) {
            if (passedList.size() == k) {
                break;
            }
            if (orderMap.get(record) - 1 == 0) {
                passedList.add(record);
            }
            orderMap.put(record, orderMap.get(record) - 1);
        }

        for (String number : passedList) {
            bw.write(number + "\n");
        }
        bw.flush();

    }
}