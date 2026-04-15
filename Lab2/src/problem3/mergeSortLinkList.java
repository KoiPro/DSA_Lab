package problem3;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class mergeSortLinkList {
    public static void main(String[] args) {
        ListNode l1 = createList(new int[] {1, 3, 7});
        ListNode l2 = createList(new int[] {2, 3, 9});

        ListNode merged = mergeSortedLists(l1, l2);

        System.out.println("Merged list:");
        printList(merged);
        System.out.println("Merge strategy: reused existing nodes from the input lists.");
    }

    private static ListNode mergeSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // Choose the first head from the smaller first node.
        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode tail = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return head;
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
