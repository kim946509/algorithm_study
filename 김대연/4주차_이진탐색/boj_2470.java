import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int solutionCount = Integer.parseInt(bufferedReader.readLine());
        int[] solutionCharacteristicValues = new int[solutionCount];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < solutionCount; i++) {
            solutionCharacteristicValues[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(solutionCharacteristicValues);

        int lcur = 0;
        int rcur = solutionCount - 1;

        int minimumGap = Integer.MAX_VALUE;
        int optimalAcid = 0;
        int optimalBase = 0;

        while (lcur < rcur) {
            int mixtureValue = solutionCharacteristicValues[lcur] + solutionCharacteristicValues[rcur];

            if (Math.abs(mixtureValue) < minimumGap) {
                minimumGap = Math.abs(mixtureValue);
                optimalAcid = solutionCharacteristicValues[lcur];
                optimalBase = solutionCharacteristicValues[rcur];
            }

            if (mixtureValue < 0) {
                lcur++;
            } else {
                rcur--;
            }
        }

        bufferedWriter.write(optimalAcid + " " + optimalBase);
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
