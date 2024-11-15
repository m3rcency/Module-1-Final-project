import java.util.Objects;

public class CaesarCipher {
    public static char[] Encrypt(String FilePath, int shift) {
        if (shift < 0) {
            shift *= -1;
        }

        String FileText = FileService.readFile(FilePath);
        char[] encryptedText = FileText.toCharArray();
        for (int i = 0; i < encryptedText.length; i++) {
            for (int j = 0; j < Main.ALPHABET.length; j++) {
                int newShift = j + shift;
                if (Objects.equals(encryptedText[i], Main.ALPHABET[j])) {
                    if (newShift >= Main.ALPHABET.length) {
                        newShift = newShift % Main.ALPHABET.length;
                    }
                    encryptedText[i] = Main.ALPHABET[newShift];
                    break;
                }
            }
        }
        return encryptedText;
    }

    public static char[] Decrypt(String FilePath, int shift) {
        if (shift < 0) {
            shift *= -1;
        }
        String FileText = FileService.readFile(FilePath);
        shift = (shift % Main.ALPHABET.length + Main.ALPHABET.length) % Main.ALPHABET.length;
        char[] decryptedText = FileText.toCharArray();
        for (int i = 0; i < decryptedText.length; i++) {
            for (int j = 0; j < Main.ALPHABET.length; j++) {
                int newShift = (j - shift + Main.ALPHABET.length) % Main.ALPHABET.length;
                if (Objects.equals(decryptedText[i], Main.ALPHABET[j])) {
                    decryptedText[i] = Main.ALPHABET[newShift];
                    break;
                }
            }
        }
        return decryptedText;
    }

    public static char[] Brute_Force(String FilePath) {
        for (int i = 1; i < Main.ALPHABET.length; i++) {
            String decryptedText = new String(CaesarCipher.Decrypt(FilePath, i));
            int indexSymbol = decryptedText.lastIndexOf(",");
            if (indexSymbol > 0 && indexSymbol + 1 < decryptedText.length()) {
                String nextSymbol = decryptedText.substring(indexSymbol + 1, indexSymbol + 2);
                if (nextSymbol.equals(" ")) {
                    return decryptedText.toCharArray();

                }
            }
        }
        return new char[0];
    }
}


