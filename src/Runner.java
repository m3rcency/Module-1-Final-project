import java.nio.file.Paths;

public class Runner {

    public static void Run(String command, String filePath, Integer shift) {
        String fileName = Paths.get(filePath).getFileName().toString();

        switch (command) {
            case ("ENCRYPT"):
                char[] EncryptedText = CaesarCipher.Encrypt(filePath, shift);
                FileService.WriteToFile(FileService.addSuffixToFilename(fileName, "[Encrypted]"), EncryptedText);
                break;
            case ("DECRYPT"):
                char[] DecryptedText = CaesarCipher.Decrypt(filePath, shift);
                FileService.WriteToFile(FileService.addSuffixToFilename(fileName, "[Decrypted]"), DecryptedText);
                break;
            case ("BRUTE_FORCE") :
                char[] Brute_force  = CaesarCipher.Brute_Force(filePath);
                FileService.WriteToFile(FileService.addSuffixToFilename(fileName, "[Brute-force]"), Brute_force);
        }

    }
}
