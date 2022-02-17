package ntnu.appdev.jpaconnection;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Project {

    @Id
    private int projectID;

    private String name;
    private String leader;
    private int budget;
    private LocalDate startDate;
    private LocalDate endDate;

    public Project(int projectID, String name, String leader, int budget, String startDate, String endDate) {
        if (checkDates(startDate, endDate)) {
            this.projectID = projectID;
            this.name = name;
            this.leader = leader;
            this.budget = budget;
            this.startDate = LocalDate.parse(startDate);
            this.endDate = LocalDate.parse(endDate);
        }
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    private boolean checkDates(String start, String end) {
        return LocalDate.parse(start).isBefore(LocalDate.parse(end));
    }
}
