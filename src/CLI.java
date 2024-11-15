import java.nio.file.Paths;
import java.util.Scanner;

public class CLI {
    public static void Communication(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What you want to do with text?");
        System.out.println("Write one of this methods: \"ENCRYPT\", \"DECRYPT\",\"BRUTE_FORCE\" ");
       String method = scan.nextLine();
       System.out.println("Write file path: ");
       String filePath = scan.nextLine();
       System.out.println("Write shift: ");

       Integer shift = Integer.parseInt(scan.nextLine());
        String fileName = Paths.get(filePath).getFileName().toString();
        switch (method) {
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
