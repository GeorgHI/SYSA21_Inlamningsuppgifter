import javafx.beans.property.SimpleStringProperty;

//Klass för att definera datamodellen i tabellen.
public class AccountModel {
    private SimpleStringProperty nbr;
    private SimpleStringProperty balance;
    private SimpleStringProperty name;

    public AccountModel(String nbr, String balance, String name){
        this.nbr = new SimpleStringProperty(nbr);
        this.balance = new SimpleStringProperty(balance);
        this.name = new SimpleStringProperty(name);
    }


    public String getBalance() {
        return balance.get();
    }

    public void setBalance(double balance) {
        this.balance = new SimpleStringProperty(String.valueOf(balance));
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getName() {
        return name.get();
    }

    public void setNbr(String nbr) {
        this.nbr = new SimpleStringProperty(nbr);
    }

    public String getNbr() {
        return nbr.get();
    }
}
