package ntnu.appdev.jdbcconnection;

import java.time.LocalDate;

public class Plan {
    private int pId;
    private int projectId;
    private String name;
    private String startDate;
    private String endDate;

    public Plan(int pId, int projectId, String name, String startDate, String endDate) {
        if (validateDates(startDate, endDate)) {
            this.pId = pId;
            this.projectId = projectId;
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    private boolean validateDates(String start, String end) {
        return LocalDate.parse(start).isBefore(LocalDate.parse(end));
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
