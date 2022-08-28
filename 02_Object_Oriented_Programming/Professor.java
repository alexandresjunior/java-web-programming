public class Professor extends Wizard {
    
    private String subject;

    public String getSubject() {
        return this.subject;
    }

    @Override
    public String castSpell() {
        return "Stupefy!";
    }

    @Override
    public void preparePotion() {
        System.out.println("Veritaserum prepared!");        
    }

}
