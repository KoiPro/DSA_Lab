import java.util.HashSet;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Problem8 {

    // ----- Approach 1: with extra memory -----
    public static Node findCycleEntryHashSet(Node head) {
        HashSet<Node> seen = new HashSet<>();
        Node curr = head;

        while (curr != null) {
            if (seen.contains(curr)) {
                return curr;
            }
            seen.add(curr);
            curr = curr.next;
        }

        return null;
    }

    // ----- Approach 2: no extra memory (Floyd) -----
    public static Node findCycleEntryFloyd(Node head) {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                Node p1 = head;
                Node p2 = slow;

                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }

                return p1;
            }
        }

        return null;
    }

    public static boolean hasCycle(Node head) {
        return findCycleEntryFloyd(head) != null;
    }

    public static void removeCycle(Node head) {
        Node entry = findCycleEntryFloyd(head);
        if (entry == null) return;

        Node curr = entry;
        while (curr.next != entry) {
            curr = curr.next;
        }
        curr.next = null;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = c; // cycle entry = 3

        System.out.println("Has cycle: " + hasCycle(a));

        Node entry1 = findCycleEntryHashSet(a);
        System.out.println("Cycle entry by HashSet: " + (entry1 != null ? entry1.val : "none"));

        Node entry2 = findCycleEntryFloyd(a);
        System.out.println("Cycle entry by Floyd: " + (entry2 != null ? entry2.val : "none"));

        removeCycle(a);

        System.out.println("Has cycle after fix: " + hasCycle(a));
        printList(a); // 1 -> 2 -> 3 -> 4 -> 5 -> null
    }
}