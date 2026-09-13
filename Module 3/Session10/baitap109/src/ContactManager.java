import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ContactManager {

    private Set<Contact> contacts = new LinkedHashSet<>();

    public boolean add(Contact contact) {
        return contacts.add(contact);
    }

    public Contact findByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }

        return null;
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        Contact contact = findByPhoneNumber(phoneNumber);
        return contact != null;
    }

    public boolean removeByPhoneNumber(String phoneNumber) {
        Contact contact = findByPhoneNumber(phoneNumber);

        if (contact != null) {
            return contacts.remove(contact);
        }

        return false;
    }

    public void display() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ đang trống!");
            return;
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public List<Contact> getContactList() {
        return new ArrayList<>(contacts);
    }

    public int size() {
        return contacts.size();
    }
}