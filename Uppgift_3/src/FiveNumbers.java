import java.util.Scanner;

public class FiveNumbers {
    private static Scanner scanner = new Scanner(System.in);
    private static Double[] numbers = new Double[5];
    public static void main(String[] args){

        for(int i = 0; i < 5; i++){
            System.out.print("Mata in ett tal: ");
            numbers[i] = scanner.nextDouble();
        }
        double sum = 0;
        double avg = 0;
        double max = numbers[0];
        for (int i = 0; i < numbers.length; i++){
            sum += numbers[i];
            avg = sum/5;
            if (max < numbers[i]) max = numbers[i];
        }
        System.out.println("Summan av talen är: " + sum);
        System.out.println("Medelvärdet av talen är: " + avg);
        System.out.println("Det största talet är: " + max);
    }
}
