import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileHelper {
    private static final String PATH_TEXT_FILE = System.getProperty("user.dir") +"\\text.txt";

    public static String readFile() throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(PATH_TEXT_FILE), StandardCharsets.UTF_8);
        Scanner dis = new Scanner(reader);

        StringBuilder res = new StringBuilder();

        while (dis.hasNextLine()) {
            String s = dis.nextLine();
            res.append(s).append("\n");
        }

        return res.toString();
    }

    public static void writeFile(String data) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(PATH_TEXT_FILE), StandardCharsets.UTF_8);

        for (int i = 0; i < data.length(); i++) {
            writer.write(data.charAt(i));
        }

        writer.close();
    }
}
