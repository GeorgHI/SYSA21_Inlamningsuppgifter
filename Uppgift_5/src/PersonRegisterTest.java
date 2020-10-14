public class PersonRegisterTest {

    public static void main(String[] args){
        PersonRegister personRegister = new PersonRegister();

        Person p1 = new Person("1", "Adam");
        Account a1 = new Account();
        a1.setBalance(1000.0);
        a1.setNbr("123");
        a1.setOwner(p1);
        p1.addAccount(a1);

        Account a2 = new Account();
        a2.setBalance(3000000.0);
        a2.setNbr("124");
        a2.setOwner(p1);
        p1.addAccount(a2);


        Person p2 = new Person("2", "Eva");
        Account a3 = new Account();
        a3.setBalance(2500.0);
        a3.setNbr("113");
        a3.setOwner(p2);
        p2.addAccount(a3);

        Account a4 = new Account();
        a4.setBalance(999000.0);
        a4.setNbr("114");
        a4.setOwner(p2);
        p2.addAccount(a4);



        personRegister.addPerson(p1);
        personRegister.addPerson(p2);

        System.out.println(personRegister.findPerson("2").getName());
        System.out.println(personRegister.findPerson("2").totBalance());
        System.out.println(personRegister.findPerson("1").getAccounts().get(0).getNbr());
        System.out.println(personRegister.totBalancePerson("2"));
        personRegister.removePerson("1");
        System.out.println(personRegister.findPerson("1"));


    }
}
