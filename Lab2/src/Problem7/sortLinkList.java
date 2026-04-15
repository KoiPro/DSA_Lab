package Problem7;

public class sortLinkList {
    public static void main(String[] args) {
        System.out.println("Linked list sort (merge sort) for Problem 7");
        System.out.println("Explanation: Array-based sorts are not ideal for linked lists because they require random access and index-based swapping.");
        System.out.println("A linked-list merge sort only uses sequential traversal and pointer relinks, which is efficient for singly linked lists.");
        System.out.println();

        runTest("Unsorted list", new int[] {4, 1, 3, 2, 5});
        runTest("Duplicates", new int[] {3, 1, 3, 2, 2, 5});
        runTest("Already sorted", new int[] {1, 2, 3, 4, 5});
        runTest("Single element", new int[] {7});
        runTest("Empty list", new int[] {});
    }

    private static void runTest(String label, int[] values) {
        System.out.println("=== " + label + " ===");
        ListNode head = buildList(values);
        System.out.print("Input:    ");
        printList(head);
        ListNode sorted = sortList(head);
        System.out.print("Sorted:   ");
        printList(sorted);
        System.out.println();
    }

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode rightHead = middle.next;
        middle.next = null;

        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(rightHead);

        return merge(leftSorted, rightSorted);
    }

    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }

        return dummy.next;
    }

    private static ListNode buildList(int[] values) {
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

    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int value) {
            val = value;
        }
    }
}
