import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }
    public void addContact(Person person) {
        contacts.add(person);
    }
    public void printContacts() {
        for (Person i : contacts) {
            System.out.println(i.toString());
        }
    }
    // Bubble Sort
    public void sort(int sortBy) {
        boolean swapping;
        for(int i = 0; i < contacts.size() - 1; i++) {
            swapping = false;
            for (int j = 0; j < contacts.size() - i - 1; j++) {
                if (swap(contacts.get(j), contacts.get(j+1), sortBy)) {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                    swapping = true;
                }
            }
            if (!swapping) {
                break;
            }
        }
    }
    private boolean swap(Person a, Person b, int sortBy) {
        if (sortBy == 0) {
            return a.getFirstName().compareTo(b.getFirstName()) > 0;
        } else if (sortBy == 1) {
            return a.getLastName().compareTo(b.getLastName()) > 0;
        } else if (sortBy == 2) {
            return a.getPhoneNumber().compareTo(b.getPhoneNumber()) > 0;
        } else {
            return false;
        }
    }

    // Search for person using first & last
    public Person searchFirstName(String firstName) {
        for (Person i : contacts) {
            if(i.getFirstName().equals(firstName)) {
                return i;
            }
        }
        return null;
    }
    // Copy for last too
    public Person searchLastName(String lastName) {
        for (Person i : contacts) {
            if(i.getLastName().equals(lastName)) {
                return i;
            }
        }
        return null;
    }
    // Now do one final time for phone#
    public Person searchPhoneNumber(String phoneNumber) {
        for (Person i : contacts) {
            if(i.getPhoneNumber().equals(phoneNumber)) {
                return i;
            }
        }
        return null;
    }

    public void listStudents() {
        for (Person i : contacts) {
            if (i instanceof Student) {
                System.out.println(i);
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Contact");
            System.out.println("2. List All Contacts By First Name");
            System.out.println("3. List All Contacts By Last Name");
            System.out.println("4. List All Contacts By Phone Number");
            System.out.println("5. List All Students");
            System.out.println("6. Search By First Name");
            System.out.println("7. Search By Last Name");
            System.out.println("8. Search By Phone Number");
            System.out.println("0. Exit");

            System.out.print("Enter a number: ");
            option = scanner.nextInt();
            scanner.nextLine();

            String firstName;
            String lastName;
            String phoneNumber;
            if (option == 1) {
                System.out.print("Enter first name: ");
                firstName = scanner.nextLine();
                System.out.print("Enter last name: ");
                lastName = scanner.nextLine();
                System.out.print("Enter phone number: ");
                phoneNumber = scanner.nextLine();
                System.out.print("Is this person a student? y/n: ");
                String isStudent = scanner.nextLine();
                if (isStudent.equals("y")) {
                    System.out.print("Enter grade: ");
                    int grade = scanner.nextInt();
                    scanner.nextLine();
                    Student newStudent = new Student(firstName, lastName, phoneNumber, grade);
                    addContact(newStudent);
                } else {
                    Person newPerson = new Person(firstName, lastName, phoneNumber);
                    addContact(newPerson);
                }
                System.out.println("New Contact Added.");
            } else if (option == 2) {
                sort(0);
                printContacts();
            } else if (option == 3) {
                sort(1);
                printContacts();
            } else if (option == 4) {
                sort(2);
                printContacts();
            } else if (option == 5) {
                listStudents();
            } else if (option == 6) {
                System.out.print("Enter a first name: ");
                firstName = scanner.nextLine();
                Person foundFirstName = searchFirstName(firstName);
                if (foundFirstName != null) {
                    System.out.println(foundFirstName);
                } else {
                    System.out.println(firstName + " is not in the list.");
                }
            } else if (option == 7) {
                System.out.print("Enter a last name: ");
                lastName = scanner.nextLine();
                Person foundLastName = searchLastName(lastName);
                if (foundLastName != null) {
                    System.out.println(foundLastName);
                } else {
                    System.out.println(lastName + " is not in the list.");
                }
            } else if (option == 8) {
                System.out.print("Enter a phone number: ");
                phoneNumber = scanner.nextLine();
                Person foundPhoneNumber = searchPhoneNumber(phoneNumber);
                if (foundPhoneNumber != null) {
                    System.out.println(foundPhoneNumber);
                } else {
                    System.out.println(phoneNumber + " is not in the list.");
                }
            } else if (option == 0) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid option!");
            }
        }
        while (option != 0);
        scanner.close();
    }
}
