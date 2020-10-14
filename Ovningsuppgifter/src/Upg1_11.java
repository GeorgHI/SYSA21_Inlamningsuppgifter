import java.util.Scanner;

public class Upg1_11 {
    public static void main(String[] args){
       /*Skriv ett program som beräknar hur många år en person har kvar till pension.
       Du kan förutsätta att pensionsåldern är 65 år och att personen ej är pensionär.
        */
       /*'final' betyder att variableln är en kostant och inte kan ändras.
       Namnen på konstanter skall skrivas med versaler */
       final int PENSIONAGE = 65;
       int currentAge;

       Scanner scanner = new Scanner(System.in);

       System.out.print("Skriv din ålder: ");
       currentAge = scanner.nextInt();
       System.out.print("Du går i pension om: " + (PENSIONAGE - currentAge) + " år");

    }
}
