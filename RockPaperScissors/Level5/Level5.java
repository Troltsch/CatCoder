import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Level5 {
    private static String LEVEL_PATH = "RockPaperScissors/Level5/";
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

        runLevel5(br, bw);

        bw.flush();
        bw.close();

        br.close();
    }

    private static void runLevel5(BufferedReader br, BufferedWriter bw) throws NumberFormatException, IOException {
        // UNSOLVED
    }
}
