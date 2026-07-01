package util;
import java.io.Console;
import java.util.Scanner;

public class InputUtil {
    public static String getPasswordInput(String prompt){
        Console console=System.console();
        if(console!=null){
            char[] passwordChars=console.readPassword(prompt);
            return new String(passwordChars);
        }
        System.out.print(prompt);
        Scanner sc=new Scanner(System.in);
        return sc.nextLine();
    }
}
