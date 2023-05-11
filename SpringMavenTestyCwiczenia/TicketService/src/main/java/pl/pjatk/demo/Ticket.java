package pl.pjatk.demo;

public class Ticket {
    private int id;
    private String status;
    private String reporter;
    private String assignee;

    public Ticket(int id, String status, String reporter, String assignee) {
        this.id = id;
        this.status = status;
        this.reporter = reporter;
        this.assignee = assignee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
}
