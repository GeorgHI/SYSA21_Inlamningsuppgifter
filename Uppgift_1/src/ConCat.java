import java.text.DecimalFormat;
import java.util.Scanner;

public class ConCat {

    public static Scanner scanner = new Scanner (System.in);


    public static void main(String[] args){
        stringKonkat();
        lonRaknare();
    }

    /* Skriv ett program som läser in två textsträngar, konkatenerar dem samman med ett blanksteg
    emellan samt beräknar den nya strängens totallängd. Den konkatenerade strängen samt dess
    längd skall skrivas ut på skärmen. Inga meddelande får ske inne i System.out.printsatsen
     */

    public static void stringKonkat(){

        String msg1 = "Skriv ett ord: ";
        String msg2 = "Skriv ytterliggare ett ord: ";
        System.out.print(msg1);
        String word1 = scanner.nextLine();
        System.out.print(msg2);
        String word2 = scanner.nextLine();
        String ans = word1 + " " + word2;
        int ansLength = ans.length();
        System.out.println(ans);
        System.out.println(ansLength);

    }

    /*
    Skriv ett program som beräknar lönen för en person. Programmet skall läsa in personens
    namn, personens timlön samt antalet arbetade timmar.
     */
    private static void lonRaknare(){
        String msg1 = "Ange ditt namn: ";
        String msg2 = "Ange din timlön: ";
        String msg3 = "Ange antalet arbetade timmar: ";
        System.out.print(msg1);
        String ans1 = scanner.nextLine();
        System.out.print(msg2);
        Double ans2 = scanner.nextDouble();
        System.out.print(msg3);
        Double ans3 = scanner.nextDouble();
        Double totPay = ans2 * ans3;
        DecimalFormat df = new DecimalFormat("#.00");
        String totSalary = df.format(totPay);

        String finalAnswer = ans1.toUpperCase() + " du tjänade " + totSalary + " kr förra veckan.";
        System.out.println(finalAnswer);
    }
}
