import java.util.LinkedList;

public class Person
{
    private String pNbr;
    private String name;
    private LinkedList<Account> accounts;

    public Person(String pNbr, String name){
        this.pNbr = pNbr;
        this.name = name;
        this.accounts = new LinkedList<Account>();
    }
    public LinkedList<Account> getAccounts(){
        return accounts;
    }
    public String getName(){
        return name;
    }
    public String getpNbr(){
        return pNbr;
    }
    public void addAccount(Account a){
        accounts.add(a);
    }
    public Account findAccount(String accountNbr){
        for(Account a : accounts){
            if(a.getNbr().equals(accountNbr)) return a;
        }
        return null;
    }
    public Double totBalance(){
        Double sum = 0.0;
        for(Account a : accounts){
            sum += a.getBalance();
        }
        return sum;
    }

}
