package problem1;

public class SortTicketSort {
    public static void main(String[] args) {
        Ticket[] tickets = new Ticket[] {
            new Ticket(2, "10:02", "A"),
            new Ticket(1, "10:05", "B"),
            new Ticket(2, "10:01", "C")
        };

        sortTickets(tickets);

        for (Ticket t : tickets) {
            System.out.println(t);
        }
    }

    private static void sortTickets(Ticket[] tickets) {
        int n = tickets.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (compareTickets(tickets[i], tickets[j]) > 0) {
                    Ticket temp = tickets[i];
                    tickets[i] = tickets[j];
                    tickets[j] = temp;
                }
            }
        }
    }

    private static int compareTickets(Ticket a, Ticket b) {
        if (a.getPriority() != b.getPriority()) {
            return a.getPriority() - b.getPriority();
        }
        return a.getCreatedAt().compareTo(b.getCreatedAt());
    }
}