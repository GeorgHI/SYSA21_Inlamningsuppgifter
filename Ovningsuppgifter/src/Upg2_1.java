import java.util.Scanner;

public class Upg2_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv in ett förnamn: ");
        String firstName = scanner.nextLine();
        System.out.print("Skriv in ett efternamn: ");
        String surName = scanner.nextLine();

        System.out.print(firstName + ", " + surName);
    }
}
