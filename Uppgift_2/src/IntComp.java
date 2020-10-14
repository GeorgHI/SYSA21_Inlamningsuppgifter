import java.util.Scanner;

public class IntComp {
    public static void main (String[] args){

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Skriv in det första talet: ");
            int num1 = scanner.nextInt();

           if(num1 == 0) break;

            System.out.print("Skriv in det andra talet: ");
            int num2 = scanner.nextInt();

            if (num1 == num2) System.out.println("Talen är lika");
            else if (num1 > num2) System.out.println(num1 + " är större än " + num2);
            else System.out.println(num2 + " är större än " + num1);
        }
        System.out.print("Tackar");
    }
}
