import java.util.Scanner;

public class Upg2_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skriv in ett namn: ");
        String name = scanner.nextLine();

        int nameLenght = name.length();
        System.out.println(name + ", det är " + nameLenght + " tecken i namnet");
    }
}
