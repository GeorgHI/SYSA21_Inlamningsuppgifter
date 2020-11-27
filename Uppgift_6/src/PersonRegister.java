import java.util.LinkedList;

public class PersonRegister {
    private LinkedList<Person> persons;

    public PersonRegister(){
        this.persons = new LinkedList<Person>();
    }

    public void addPerson (Person p){
        persons.add(p);
    }
    public Person findPerson(String pNbr){
        for ( Person p : persons){
            if(p.getpNbr().equals(pNbr)) return p;
        }
        return null;
    }
    public Person removePerson(String pNbr){
        for ( Person p : persons){
            if(p.getpNbr().equals(pNbr)){
                persons.remove(p);
                return p;
            }
        }
        return null;
    }
    public Account findAccount(String pNbr, String accountNbr){
        for (Person p : persons){
            if (p.getpNbr().equals(pNbr)) {
                for (Account a : p.getAccounts()){
                    if(a.getNbr().equals(accountNbr)) return a;
                }
            }
        }
        return null;
    }
    public Double totBalancePerson(String pNbr){
        Double sum = 0.0;
        for(Person p : persons){
            if(p.getpNbr().equals(pNbr)) {
            sum = p.totBalance();
            }
        }
        return sum;
    }

}
