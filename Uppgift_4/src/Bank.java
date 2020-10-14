import java.util.Scanner;

public class Bank {

    private static Scanner scanner = new Scanner(System.in);
    private static Account account = new Account("123", 0.0);
    public static void main(String[] args){
        //test();
        bankMethod();
    }

    public static void bankMethod(){
        while(true){
            System.out.print("Insättning eller uttag (0-insättning, 1-uttag): ");
            int ans = scanner.nextInt();
            if (ans == 0){
                System.out.print("Ange belopp: ");
                Double amount = scanner.nextDouble();
                account.credit(amount);
                System.out.println("Saldo: " + account.getBalance());
            }
            else if ( ans == 1){
                System.out.print("Ange belopp: ");
                Double amount = scanner.nextDouble();
                account.withdraw(amount);
                System.out.println("Saldo: " + account.getBalance());
            }
            else{
                bankMethod();
            }
            System.out.println("Vill du avsluta? ");
            String quitAns = scanner.next();
            if(quitAns.equals("J")){
                System.out.println("Saldo: " + account.getBalance());
                break;
            }
            else bankMethod();
        }
    }


    public static void test(){
        Account testAccount = new Account("0", (double) 0);
        System.out.println(testAccount.getBalance() + " kr finns på konto: " + testAccount.getNbr());
        testAccount.credit(1000.0);
        System.out.println(testAccount.getBalance() + " kr finns på konto: " + testAccount.getNbr());
        testAccount.withdraw(250.5);
        System.out.println(testAccount.getBalance() + " kr finns på konto: " + testAccount.getNbr());
        testAccount.setNbr("1");
        testAccount.setBalance(1.0);
        System.out.println(testAccount.getBalance() + " kr finns på konto: " + testAccount.getNbr());

    }
}
