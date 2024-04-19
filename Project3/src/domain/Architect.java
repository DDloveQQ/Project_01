package domain;

public class Architect extends Designer {
    private int stock;

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String getDetailsForTeam() {
        return getMemberDetails() + "\t\t" + "架构师" + "\t" + getStatus() + "\t" + getBonus() + "\t\t" +
                stock + "\t\t" + getEquipment().getDescription();
    }

    public String toString() {
        return getDetails() + "\t" + "架构师" + "\t" + getStatus() + "\t" + getBonus() + "\t\t" +
                stock + "\t\t" + getEquipment().getDescription();
    }
}
