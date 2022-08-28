public abstract class Wizard {

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String castSpell() {
        return "Expelliarmus!";
    }

    public String castSpell(String spell) {
        return spell;
    }

    public abstract void preparePotion();
    
}
