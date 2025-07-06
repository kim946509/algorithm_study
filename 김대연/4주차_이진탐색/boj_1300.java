import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int matrixSize = Integer.parseInt(bufferedReader.readLine());
        int targetIndex = Integer.parseInt(bufferedReader.readLine());

        long lcur = 1;
        long rcur = (long) matrixSize * matrixSize;
        long result = 0;

        while (lcur <= rcur) {
            long midValue = (lcur + rcur) / 2;

            long count = countLessOrEqual(matrixSize, midValue);

            if (count >= targetIndex) {
                result = midValue;
                rcur = midValue - 1;
            } else {
                lcur = midValue + 1;
            }
        }

        bufferedWriter.write(result + "\n");
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static long countLessOrEqual(int matrixSize, long value) {
        long count = 0;
        for (int row = 1; row <= matrixSize; row++) {
            count += Math.min(matrixSize, value / row);
        }
        return count;
    }
}
