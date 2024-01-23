public class Expert extends Person {
    private String expertise;

    public Expert(String firstName, String lastName, String phoneNumber, String expertise) {
        super(firstName, lastName, phoneNumber);
        this.expertise = expertise;
    }

    public String getExpert() {
        return expertise;
    }

    @Override
    public String toString() {
        return super.toString() + " Area of Expertise: " + expertise;
    }
}
