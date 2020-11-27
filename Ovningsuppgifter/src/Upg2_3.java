import java.util.Scanner;

public class Upg2_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv in en text: ");
        String text = scanner.nextLine();
        String nyText = text.replace('m','x');
        System.out.println(nyText);
    }
}
