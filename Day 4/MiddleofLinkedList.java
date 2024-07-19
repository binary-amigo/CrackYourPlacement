/**
 * MiddleofLinkedList
 */
public class MiddleofLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Brute Force
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static ListNode middleNode1(ListNode head) {
        int size = 0;

        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }

        temp = head;
        for(int i = 0;i < size/2;i++){
            temp = temp.next;
        }

        return temp;
    }

    //Optimal
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(middleNode1(head).val);
        System.out.println(middleNode2(head).val);
    }
}