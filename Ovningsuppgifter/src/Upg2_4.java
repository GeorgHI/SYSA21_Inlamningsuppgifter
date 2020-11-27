import java.text.DecimalFormat;
import java.util.Scanner;

public class Upg2_4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv in lägenhetsinnehavarens namn: ");
        String tenantName = scanner.nextLine();
        System.out.print("Skriv in månadshyran: ");
        Double monthlyRent = scanner.nextDouble();
        System.out.print("Skriv in bostasdsarea i kvm: ");
        Double apartmentSize = scanner.nextDouble();
        DecimalFormat df = new DecimalFormat("#.00");
        tenantName = tenantName.toUpperCase();
        String sekPerSquareMeter = df.format((monthlyRent / apartmentSize));

        System.out.print(tenantName + " du betalar " + sekPerSquareMeter + " kr per kvadratmeter i månaden");
    }
}
