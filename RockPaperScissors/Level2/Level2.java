import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Level2 {
    private static String LEVEL_PATH = "RockPaperScissors/Level2/";
    private static String INPUT_PATH = LEVEL_PATH + "Input/";
    private static String OUTPUT_PATH = LEVEL_PATH + "Output/";

    public static void main(String[] args) throws NumberFormatException, IOException {

        File inputFolder = new File(INPUT_PATH);
        for (File inputFile : inputFolder.listFiles()) {
            testCase(inputFile);
        }
    }

    private static void testCase(File testCase) throws NumberFormatException, IOException {
        FileInputStream in = new FileInputStream(testCase);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String testCaseName = testCase.getName().replace(".in", ".out");
        FileOutputStream out = new FileOutputStream(OUTPUT_PATH + testCaseName);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

        runLevel2(br, bw);

        bw.flush();
        bw.close();

        br.close();
    }

    private static void runLevel2(BufferedReader br, BufferedWriter bw) throws NumberFormatException, IOException {
        String[] firstLineTokens = br.readLine().split(" ");
        int N = Integer.parseInt(firstLineTokens[0]);
        int M = Integer.parseInt(firstLineTokens[1]);

        for (int i = 0; i < N; ++i) {
            String fighters = br.readLine();
            String winners = tournament(fighters);

            bw.write(winners + "\n");
        }
    }

    static private String tournament(String fighters) {
        int NUMBER_OF_ROUNDS = 2;
        for (int i = 0; i < NUMBER_OF_ROUNDS; ++i) {
            String winners = "";
            for (int j = 0; j < fighters.length(); j += 2) {
                char fighterA = fighters.charAt(j);
                char fighterB = fighters.charAt(j + 1);
                char winner = fightBattle(fighterA, fighterB);
                winners += winner;
            }
            fighters = winners;
        }
        return fighters;
    }

    static private char fightBattle(char fighterA, char fighterB) {
        if (fighterA == 'P' && fighterB == 'R' ||
                fighterA == 'R' && fighterB == 'S' ||
                fighterA == 'S' && fighterB == 'P') {
            return fighterA;
        } else {
            return fighterB;
        }
    }
}
