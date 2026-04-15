class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Problem6 {

    public static Node stablePartition(Node head, int x) {
        Node lessHead = null, lessTail = null;
        Node greaterHead = null, greaterTail = null;

        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next; // save next
            curr.next = null;          // detach current node

            if (curr.val < x) {
                if (lessHead == null) {
                    lessHead = curr;
                    lessTail = curr;
                } else {
                    lessTail.next = curr;
                    lessTail = curr;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = curr;
                    greaterTail = curr;
                } else {
                    greaterTail.next = curr;
                    greaterTail = curr;
                }
            }

            curr = nextNode;
        }

        // connect two partitions
        if (lessHead == null) {
            return greaterHead;
        }

        lessTail.next = greaterHead;
        return lessHead;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static Node buildList(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node tail = head;

        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }

        return head;
    }

    public static void main(String[] args) {
        // Test 1: Example from spec
        Node head1 = buildList(new int[]{3, 5, 8, 5, 10, 2, 1});
        System.out.print("Input  : ");
        printList(head1);
        head1 = stablePartition(head1, 5);
        System.out.print("Output : ");
        printList(head1); // expected: 3 -> 2 -> 1 -> 5 -> 8 -> 5 -> 10 -> null

        // Test 2: All values < x
        Node head2 = buildList(new int[]{1, 2, 3});
        System.out.print("Input  : ");
        printList(head2);
        head2 = stablePartition(head2, 5);
        System.out.print("Output : ");
        printList(head2); // expected: 1 -> 2 -> 3 -> null

        // Test 3: All values >= x
        Node head3 = buildList(new int[]{7, 8, 9});
        System.out.print("Input  : ");
        printList(head3);
        head3 = stablePartition(head3, 5);
        System.out.print("Output : ");
        printList(head3); // expected: 7 -> 8 -> 9 -> null

        // Test 4: Empty list
        Node head4 = null;
        System.out.print("Input  : ");
        printList(head4);
        head4 = stablePartition(head4, 3);
        System.out.print("Output : ");
        printList(head4); // expected: null
    }
}