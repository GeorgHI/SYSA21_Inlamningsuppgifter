import java.util.Scanner;

public class Upg3_20 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv antal gånger det ska stå alarm: ");
        int amount = scanner.nextInt();
        int count = 0;
        while(count < amount){
            System.out.println("ALARM!");
            count++;
        }
    }
}
