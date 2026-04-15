import java.util.*;

public class SortTicketSort{
    public static void main(String arg[]) throws Exception{
        List<Ticket> tickets = Arrays.asList(
            new Ticket(2, "10:02", "A"),
            new Ticket(1, "10:05", "B"),
            new Ticket(2, "10:01", "C")
        );

        tickets.sort(Comparator
            .comparingInt((Ticket t)->t.priority)
            .thenComparing(t ->t.createAt));

        for(Ticket t: tickets){
            System.out.println(t);
        }
    }
}

