public class Ticket{
    int priority;
    String createAt;
    String ticketID;
    public Ticket(int priority, String createAt, String ticketID){
        this.priority = priority;
        this.createAt = createAt;
        this.ticketID = ticketID;
    }
    @Override
    public String toString(){
        return "priority" + priority + ",createAt" + createAt + ",ticketID" + ticketID;
    }
}
