public class Student extends Wizard {

    private String house;
    private static int number = 0;

    public Student(String name, String house) {
        this.house = house;
        number++;
    }

    public String getHouse() {
        return this.house;
    }

    public static int getNumberOfStudents() {
        return number;
    }

    @Override
    public String castSpell() {
        return "Expecto Patronum!";
    }

    @Override
    public void preparePotion() {
        System.out.println("Amortentia prepared!");
    }
    
}