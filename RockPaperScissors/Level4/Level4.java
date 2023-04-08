import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Level4 {
    private static String LEVEL_PATH = "RockPaperScissors/Level4/";
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

        runLevel4(br, bw);

        bw.flush();
        bw.close();

        br.close();
    }

    private static void runLevel4(BufferedReader br, BufferedWriter bw) throws NumberFormatException, IOException {
        String[] firstLineTokens = br.readLine().split(" ");
        int N = Integer.parseInt(firstLineTokens[0]);
        int M = Integer.parseInt(firstLineTokens[1]);

        for (int i = 0; i < N; ++i) {
            String[] tokens = br.readLine().split(" ");
            int rocks = Integer.parseInt(tokens[0].substring(0, tokens[0].length() - 1));
            int papers = Integer.parseInt(tokens[1].substring(0, tokens[1].length() - 1));
            int scissors = Integer.parseInt(tokens[2].substring(0, tokens[2].length() - 1));
            String winners = reverseTournament(rocks, papers, scissors);
            bw.write(winners + "\n");
        }
    }

    static private String reverseTournament(int rocks, int papers, int scissors) {
        int total = rocks + papers + scissors;
        String fighters = "";

        while (total > 1) {
            int leftWing = total / 2;
            if (papers >= 1 && rocks >= 1) {
                fighters += "PR";
                papers -= 1;
                rocks -= 1;
                leftWing -= 2;
                total -= 2;
            }

            while (leftWing > 0) {
                if (rocks > 0) {
                    fighters += "R";
                    rocks -= 1;
                } else if (papers > 0) {
                    fighters += "P";
                    papers -= 1;
                } else {
                    fighters += "S";
                    scissors -= 1;
                }
                leftWing -= 1;
                total -= 1;
            }

        }
        if (rocks > 0) {
            fighters += "R";
            rocks -= 1;
        } else if (papers > 0) {
            fighters += "P";
            papers -= 1;
        } else {
            fighters += "S";
            scissors -= 1;
        }
        return fighters;
    }
}
