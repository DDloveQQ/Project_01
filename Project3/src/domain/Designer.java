package domain;

public class Designer extends Programmer {
    private double bonus;

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String getDetailsForTeam() {
        return getMemberDetails() + "\t\t" + "设计师" + "\t" + getStatus() + "\t" + getBonus() + "\t\t\t\t\t" + getEquipment().getDescription();
    }

    public String toString() {
        return getDetails() + "\t" + "设计师" + "\t" + getStatus() + "\t" + getBonus() + "\t\t\t\t\t" + getEquipment().getDescription();
    }
}
