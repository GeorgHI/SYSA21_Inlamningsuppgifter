import java.time.Period;
import java.util.Scanner;

public class Upg3_7  {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final int PENSIONAGE = 65;
        System.out.print("Skriv in din ålder: ");
        int age = scanner.nextInt();

        if(age < PENSIONAGE) System.out.print("Du går i pension om: " + (PENSIONAGE - age) + " år");
        else if (age > PENSIONAGE) System.out.print("Du har varit pensionär i: " + (age - PENSIONAGE) + " år");
        else System.out.print("Grattis du blev pensionär i år!!!");
    }
}
