import java.util.Scanner;

public class Upg1_12 {
    public static void main(String[] args){
        /* Skriv ett program som läser in två heltal (dessa skall vara deklarerade som heltal (int)
        och utför tre stycken beräkningar som nedan. */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv in ett tal: ");
        int tal1 = scanner.nextInt();
        System.out.print("Skriv in yterligare ett tal: ");
        int tal2 = scanner.nextInt();

        System.out.println(tal1 + " + " + tal2 + " = " + (tal1 + tal2));
        System.out.println(tal1 + " - " + tal2 + " = " + (tal1 - tal2));
        System.out.println(tal1 + " * " + tal2 + " = " + (tal1 * tal2));
    }
}
