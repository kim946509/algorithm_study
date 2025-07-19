import java.io.IOException;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> numberMap = new HashMap<>();
        Map<String, Integer> stringMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String name;
        for (int i = 0; i < n; i++) {
            name = br.readLine();
            numberMap.put(i + 1, name);
            stringMap.put(name, i + 1);
        }

        String question;
        for (int i = 0; i < m; i++) {
            question = br.readLine();
            try {
                System.out.println(numberMap.get(Integer.parseInt(question)));
            } catch (NumberFormatException e) {
                System.out.println(stringMap.get(question));
            }
        }
    }
}