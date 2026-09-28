import java.util.Scanner;

public class Utility
{
    public static Scanner scanner = new Scanner(System.in);

    public static String getCustomInput(String str)
    {
        System.out.print(str);
        return scanner.nextLine();
    }
}