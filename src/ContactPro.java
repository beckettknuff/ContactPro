import java.util.ArrayList;
public class ContactPro {
    private ArrayList<Person> contacts;

    public ContactPro() {
        contacts = new ArrayList<>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }
    public void addContact(Person person) {
        contacts.add(person);
    }
}
