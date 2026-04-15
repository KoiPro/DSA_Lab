import java.util.HashSet;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Problem4 {
    public static Node removeDuplicates(Node head) {
        if (head == null) return null;

        HashSet<Integer> seen = new HashSet<>();
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            if (seen.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                seen.add(curr.val);
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
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
        Node head = buildList(new int[]{5, 1, 5, 2, 1});
        System.out.print("Input  : ");
        printList(head);

        head = removeDuplicates(head);

        System.out.print("Output : ");
        printList(head); // 5 -> 1 -> 2 -> null
    }
}