public class Account {
    private String nbr;
    private Double balance;
    private Person owner;

    public Account (){

    }


    public Person getOwner() {
        return owner;
    }
    public void setOwner(Person newOwner){ owner = newOwner;}
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
        setBalance(balance - amount);
    }
}
