package ntnu.appdev.jpaconnection;

public class Employee {
    private int eId;
    private String name;
    private int cost;

    public Employee(int eId, String name, int cost) {
        this.eId = eId;
        this.name = name;
        this.cost = cost;
    }

    public int geteId() {
        return eId;
    }

    public void setId(int eId) {
        this.eId = eId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
