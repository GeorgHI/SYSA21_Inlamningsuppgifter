import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    //Skapa en lista för tabellen i gränsnittet och ett personregister
    private ObservableList<AccountModel> accountsModels = FXCollections.observableArrayList();
    private PersonRegister personRegister = new PersonRegister();


    //Deklarerar object från gränssnittet
    @FXML
    private TextField txtSearchBox;
    @FXML
    private TextField txtAmountInput;
    @FXML
    private TextField txtNameInput;
    @FXML
    private TextField txtPNbrInput;
    @FXML
    private TextField txtNewAccountNbrInput;
    @FXML
    private TableView<AccountModel> tblAccounts;
    @FXML
    public TableColumn<AccountModel, String> colName;
    @FXML
    public TableColumn<AccountModel, String> colNbr;
    @FXML
    public TableColumn<AccountModel, String> colBalance;
    @FXML
    private Label lblResponse;
    @FXML
    private Label lblAccount;
    @FXML
    private Label lblInsufficientFunds;

    //Metod som anropas när man tycker på Addknappen
    @FXML
    public void btnPersonAdd_Click(ActionEvent event){
        String pName = txtNameInput.getText();
        String pNumber = txtPNbrInput.getText();

        //check for pNumber
        if(personRegister.findPerson(pNumber) != null){
            lblResponse.setText("Person already exists.");
            return;
        }
        Person person = new Person(pNumber, pName);
        personRegister.addPerson(person);
        lblResponse.setText("Person added successfully!");
        /*
        Person p1 = new Person("1", "Adam");
        Account a1 = new Account();
        a1.setBalance(1000.0);
        a1.setNbr("123");
        a1.setOwner(p1);
        p1.addAccount(a1);
        personRegister.addPerson(p1);

         */
    }

    //fixa felhantering om personen inte finns
    @FXML
    public void btnPersonRemove_Click(ActionEvent event){
        String pNumber = txtPNbrInput.getText();
        personRegister.removePerson(pNumber);
        lblResponse.setText("Person removed successfully!");
    }

    //Metod för att söka
    //fixa felmeddelande
    @FXML
    public void btnSearch_Click(ActionEvent event){
        String searchTerm = txtSearchBox.getText();
        Person person = personRegister.findPerson(searchTerm);
        LinkedList<Account> accounts = person.getAccounts();
        accountsModels.removeAll();
        tblAccounts.getItems().clear();
        for ( Account a : accounts){
            AccountModel accountModel = new AccountModel(a.getNbr(), a.getBalance(), a.getOwner().getName());
            accountsModels.add(accountModel);
            tblAccounts.setItems(accountsModels);
            tblAccounts.refresh();
        }

    }

    //Metod som uppdaterar tableView genom att tömma accountsModels listan och tömma tableView:n
    //Sedan fylla den med konton från personen
    @FXML
    public void updateTable(){

        Person person = personRegister.findPerson(txtSearchBox.getText());
        LinkedList<Account> accounts = person.getAccounts();
        accountsModels.removeAll();
        tblAccounts.getItems().clear();
        for ( Account a : accounts){
            AccountModel accountModel = new AccountModel(a.getNbr(), a.getBalance(), a.getOwner().getName());
            accountsModels.add(accountModel);
            tblAccounts.setItems(accountsModels);
            tblAccounts.refresh();
        }
        //Sätter in en blank rad efter kontona
        AccountModel accountModelSpacing = new AccountModel("", 0.0, "");
        accountsModels.add(accountModelSpacing);
        //Skapar en rad för totala saldot
        AccountModel accountModelTotalBalance = new AccountModel("Total balance:", person.totBalance(), person.getName());
        accountsModels.add(accountModelTotalBalance);
        tblAccounts.setItems(accountsModels);
        tblAccounts.refresh();

    }

    @FXML
    public void btnDeposit_Click(ActionEvent event){
        double amount = Double.parseDouble(txtAmountInput.getText());
        AccountModel selectedAccountModel = tblAccounts.getSelectionModel().getSelectedItem();
        personRegister.findAccount(txtSearchBox.getText(), String.valueOf(selectedAccountModel.getNbr())).credit(amount);
        updateTable();
    }
    @FXML
    public void btnWithdraw_Click(ActionEvent event){
        double amount = Double.parseDouble(txtAmountInput.getText());
        AccountModel selectedAccountModel = tblAccounts.getSelectionModel().getSelectedItem();
        Account account = personRegister.findAccount(txtSearchBox.getText(), String.valueOf(selectedAccountModel.getNbr()));
        if(amount > account.getBalance()){
            lblInsufficientFunds.setText("You have insufficient funds on you account. Withdrawal cancelled");
        }
        account.withdraw(amount);
        updateTable();
    }

    @FXML
    public void btnAddAccount_Click(ActionEvent event){
        String pNbr = txtSearchBox.getText();
        String accountNbr = txtNewAccountNbrInput.getText();

        for(Person p : personRegister.getPersons()){
            for(Account a : p.getAccounts()){
                if(a.getNbr().equals(accountNbr)){
                    lblAccount.setText("Account number is already in use, try another one.");
                    return;
                }
            }
        }

        Account account = new Account();
        account.setNbr(accountNbr);
        account.setBalance(0.0);
        account.setOwner(personRegister.findPerson(pNbr));
        personRegister.findPerson(pNbr).addAccount(account);

        updateTable();

    }


    //kolla upp vad detta gör
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colNbr.setCellValueFactory(new PropertyValueFactory<>("Nbr"));
        colBalance.setCellValueFactory(new PropertyValueFactory<>("Balance"));

        tblAccounts.setItems(accountsModels);
    }
}
