package problem1;

public class Ticket {
    private int priority;
    private String createdAt;
    private String ticketID;

    public Ticket(int priority, String createdAt, String ticketID) {
        this.priority = priority;
        this.createdAt = createdAt;
        this.ticketID = ticketID;
    }

    public int getPriority() {
        return priority;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getTicketID() {
        return ticketID;
    }

    @Override
    public String toString() {
        return "Priority: " + priority + ", Created At: " + createdAt + ", Ticket ID: " + ticketID;
    }
}