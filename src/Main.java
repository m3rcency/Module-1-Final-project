


public class Main {
    public final static  char[] ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '
    };
    public static void main(String[] args) {

        if(args.length == 3){
            String command = args[0];
            String filePath = args[1];
            Integer shift = Integer.parseInt(args[2]);
            Runner.Run(command, filePath, shift);
        }else{
            CLI.Communication();
        }

    }
}