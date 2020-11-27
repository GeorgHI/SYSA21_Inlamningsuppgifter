import java.util.Scanner;

public class Upg3_22 {
    private static Scanner scanner = new Scanner(System.in);
    private static Double[] numbers = new Double[5];
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.print("Mata in ett tal: ");
            numbers[i] = scanner.nextDouble();
        }
        double max = numbers[0];
        double min = numbers[0];
        for (int i = 0; i < numbers.length; i++){
            if (max < numbers[i]) max = numbers[i];
            if (min > numbers[i]) min = numbers[i];
        }
        System.out.println(max);
        System.out.println(min);
    }
}
