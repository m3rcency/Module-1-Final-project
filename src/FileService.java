import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    public static void WriteToFile(String filePath, char[] writeToFile) {
        try (FileWriter output = new FileWriter(filePath)) {
            output.write(writeToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (FileReader reader = new FileReader(fileName)) {
            char[] buffer = new char[2048];
            int numRead;

            while ((numRead = reader.read(buffer)) != -1) {
                content.append(buffer, 0, numRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }
    public static String addSuffixToFilename(String filename, String suffix) {
        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex == -1) {
            return filename + suffix;
        } else {
            return filename.substring(0, dotIndex) + suffix + filename.substring(dotIndex);
        }
    }
}
