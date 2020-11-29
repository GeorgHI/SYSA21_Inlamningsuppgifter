import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    //Skapa en lista för tabellen i gränsnittet och ett personregister
    private ObservableList<AccountModel> accountModels = FXCollections.observableArrayList();
    private PersonRegister personRegister = new PersonRegister();
    DecimalFormat df = new DecimalFormat("#.00");


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
    @FXML
    private Label tableLabel = new Label("Search for a personal number to populate the table.");


    //Metod som anropas när man tycker på Addknappen i manage person panelen
    @FXML
    public void btnPersonAdd_Click(ActionEvent event) {
        String pName = txtNameInput.getText();
        String pNumber = txtPNbrInput.getText();

        //check to see if Person exists or the pNumber textfield is empty
        if (personRegister.findPerson(pNumber) == null && !pNumber.equals("")) {
            Person person = new Person(pNumber, pName);
            personRegister.addPerson(person);
            lblResponse.setText("Person added successfully!");
        } else {
            lblResponse.setText("Invalid personal number. Number might already be in use.");
        }
    }

    @FXML
    public void btnPersonRemove_Click(ActionEvent event) {
        String pNumber = txtPNbrInput.getText();
        //check to see if Person exists
        if (personRegister.removePerson(pNumber) == null) {
            lblResponse.setText("No person with the personal number " + pNumber + "exists.");
        } else {
            personRegister.removePerson(pNumber);
            lblResponse.setText("Person removed successfully!");
        }
    }

    //Metod som anropas när man trycker på searchknappen
    @FXML
    public void btnSearch_Click(ActionEvent event) {
        updateTable();
    }

    //Metod som uppdaterar tableView genom att tömma accountModels listan och tömma tableView:n
    //och sedan fylla den med kontona från personens accounts lista
    @FXML
    public void updateTable() {
        Person person = personRegister.findPerson(txtSearchBox.getText());
        //tömmer accountModel listan och tabellen
        accountModels.removeAll();
        tblAccounts.getItems().clear();
        //kollar om det finns en person med det personnummeret annars skickas ett felmeddelande som visas i tabellen
        if(person == null) {
            tableLabel.setText("No such person exists. Create one or more in the \"Manage person\" panel.");
            tableLabel.setWrapText(true);
            tblAccounts.setPlaceholder(tableLabel);
        }
        else {
            //kollar om personen har några konton. Om inte så skickar den ett felmedelande som visas i tabellen
            //Annars går den vidare och översätter alla Account:s till AccountModel:s som den sparar i accountModels listan
            LinkedList<Account> accounts = person.getAccounts();
            if (accounts.size() == 0) {
                tblAccounts.setPlaceholder(new Label("There are no accounts for this person. Try creating one below."));
            } else {
                for (Account a : accounts) {
                    AccountModel accountModel = new AccountModel(a.getNbr(), String.valueOf(a.getBalance()), a.getOwner().getName());
                    accountModels.add(accountModel);
                }
                //Sätter in en blank rad efter kontona
                AccountModel accountModelSpacing = new AccountModel("", "", "");
                accountModels.add(accountModelSpacing);
                //Skapar en rad för totala saldot
                AccountModel accountModelTotalBalance = new AccountModel("Total balance:", person.totBalance().toString(), person.getName());
                accountModels.add(accountModelTotalBalance);
            }
        }
        tblAccounts.setItems(accountModels);
        tblAccounts.refresh();
    }

    @FXML
    public void btnDeposit_Click(ActionEvent event) {
        double amount = Double.parseDouble(txtAmountInput.getText());
        AccountModel selectedAccountModel = tblAccounts.getSelectionModel().getSelectedItem();
        personRegister.findAccount(txtSearchBox.getText(), String.valueOf(selectedAccountModel.getNbr())).credit(amount);
        lblInsufficientFunds.setText("Deposit successful!");
        updateTable();
    }

    @FXML
    public void btnWithdraw_Click(ActionEvent event) {
        double amount = Double.parseDouble(txtAmountInput.getText());
        AccountModel selectedAccountModel = tblAccounts.getSelectionModel().getSelectedItem();
        Account account = personRegister.findAccount(txtSearchBox.getText(), String.valueOf(selectedAccountModel.getNbr()));
        if (amount > account.getBalance()) {
            lblInsufficientFunds.setText("You have insufficient funds on you account. Withdrawal cancelled");
        }
        else {
            account.withdraw(amount);
            lblInsufficientFunds.setText("Withdrawal successful!");
        }
        updateTable();
    }

    @FXML
    public void btnAddAccount_Click(ActionEvent event) {
        String pNbr = txtSearchBox.getText();
        String accountNbr = txtNewAccountNbrInput.getText();

        for (Person p : personRegister.getPersons()) {
            for (Account a : p.getAccounts()) {
                if (a.getNbr().equals(accountNbr)) {
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
        lblAccount.setText("Account added successfully!");
        updateTable();

    }


    //kolla upp vad detta gör
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colNbr.setCellValueFactory(new PropertyValueFactory<>("Nbr"));
        colBalance.setCellValueFactory(new PropertyValueFactory<>("Balance"));

        tblAccounts.setPlaceholder(tableLabel);
    }
}
