import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.next(), "+-", true);
        int sum = 0;
        int subSum = 0;
        boolean isPositive = true;
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            // '-' 문자라면
            if (token.equals("-")) {

                // 처음으로 음수를 만났을 경우
                if (isPositive) {
                    isPositive = false;
                }

                // 이미 음수일 경우. 그앞에 부분합까지 subSum과 sum을 더한다.
                else {
                    sum -= subSum;
                    subSum = 0;
                }

                continue;
            }

            // 숫자라면
            if (isNumeric(token)) {
                if (isPositive) {
                    sum += Integer.parseInt(token);
                } else {
                    subSum += Integer.parseInt(token);
                }
            }
        }

        sum -= subSum;
        System.out.println(sum);
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
