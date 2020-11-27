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

    private ObservableList<AccountModel> accountsModels = FXCollections.observableArrayList(
            new AccountModel("1",0.0,"Hej")
    );
    private PersonRegister personRegister = new PersonRegister();



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
    public TableColumn<AccountModel, Double> colBalance;
    @FXML
    private Label lblResponse;


    @FXML
    public void btnPersonAdd_Click(ActionEvent event){
        String pName = txtNameInput.getText();
        String pNumber = txtPNbrInput.getText();
        Person person = new Person(pNumber, pName);
        personRegister.addPerson(person);
        lblResponse.setText("Person added successfully!");
        Person p1 = new Person("1", "Adam");
        Account a1 = new Account();
        a1.setBalance(1000.0);
        a1.setNbr("123");
        a1.setOwner(p1);
        p1.addAccount(a1);
        personRegister.addPerson(p1);
    }

    public void btnPersonRemove_Click(ActionEvent event){
        String pNumber = txtPNbrInput.getText();
        personRegister.removePerson(pNumber);
        lblResponse.setText("Person removed successfully!");
    }

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

    public void btnAddAccount_Click(ActionEvent event){
        String pNbr = txtSearchBox.getText();
        String accountNbr = txtNewAccountNbrInput.getText();

        Account account = new Account();
        account.setNbr(accountNbr);
        account.setBalance(0.0);
        account.setOwner(personRegister.findPerson(pNbr));
        personRegister.findPerson(pNbr).addAccount(account);

        Person person = personRegister.findPerson(pNbr);
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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colNbr.setCellValueFactory(new PropertyValueFactory<>("Nbr"));
        colBalance.setCellValueFactory(new PropertyValueFactory<>("Balance"));
        //listan ska in under
        tblAccounts.setItems(accountsModels);
    }


}
