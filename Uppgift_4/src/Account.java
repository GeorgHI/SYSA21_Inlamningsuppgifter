public class Account {
    private String nbr;
    private Double balance;

    public Account (String nbr, Double balance){
        this.balance = balance;
        this.nbr = nbr;
    }

    public String getNbr(){
        return nbr;
    }
    public void setNbr( String newNbr){
        this.nbr = newNbr;
    }
    public Double getBalance(){
        return balance;
    }
    public void setBalance( Double newBalance){
        this.balance = newBalance;
    }

    public void credit(Double amount){
        setBalance(amount + balance);
    }
    public void withdraw(Double amount){
        if(!(amount>balance)) balance -= amount;
    }
}
