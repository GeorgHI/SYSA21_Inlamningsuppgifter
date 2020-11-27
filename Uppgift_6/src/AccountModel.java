import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AccountModel {
    private SimpleStringProperty nbr;
    private SimpleStringProperty balance;
    private SimpleStringProperty name;

    public AccountModel(String nbr, double balance, String name){
        this.nbr = new SimpleStringProperty(nbr);
        this.balance = new SimpleStringProperty(String.valueOf(balance));
        this.name = new SimpleStringProperty(name);
    }


    public double getBalance() {
        return Double.parseDouble(String.valueOf(balance));
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
