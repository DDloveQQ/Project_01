package domain;

import service.Status;

public class Programmer extends Employee implements Equipment {
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    protected String getMemberDetails() {
        return getMemberId() + "/" + getDetails();
    }

    public String getDetailsForTeam() {
        return getMemberDetails() + "\t\t" + "程序员" + "\t" + status + "\t\t\t\t\t\t\t" + equipment.getDescription();
    }

    @Override
    public String getDescription() {
        return getEquipment().getDescription();
    }

    @Override
    public String toString() {
        return getDetails() + "\t" + "程序员" + "\t" + status + "\t\t\t\t\t\t\t" + equipment.getDescription();
    }

}
