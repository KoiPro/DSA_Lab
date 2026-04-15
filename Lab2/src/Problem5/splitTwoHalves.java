package Problem5;

class ListNode {
    int val;
    ListNode next;

    ListNode(int value) {
        this.val = value;
    }
}

public class splitTwoHalves {
    public static void main(String[] args) {
        ListNode head = createList(new int[] {1, 2, 3, 4, 5});

        ListNode[] halves = splitPlaylist(head);
        ListNode firstHalf = halves[0];
        ListNode secondHalf = halves[1];

        System.out.println("First half:");
        printList(firstHalf);
        System.out.println("Second half:");
        printList(secondHalf);
    }

    private static ListNode[] splitPlaylist(ListNode head) {
        if (head == null) {
            return new ListNode[] {null, null};
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // When the length is odd, slow is the middle node and it belongs to the first half.
        if (fast != null) {
            prev = slow;
            slow = slow.next;
        }

        ListNode secondHalf = slow;
        if (prev != null) {
            prev.next = null;
        }

        return new ListNode[] {head, secondHalf};
    }

    private static ListNode createList(int[] values) {
        ListNode head = null;
        ListNode tail = null;

        for (int value : values) {
            ListNode node = new ListNode(value);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println(" -> null");
    }
}
