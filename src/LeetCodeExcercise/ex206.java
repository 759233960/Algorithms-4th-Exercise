package LeetCodeExcercise;

/**
 * 206. Reverse Linked List
 * Reverse a singly linked list.
 * <p>
 * 206. 反转链表
 * 反转一个单链表。
 * <p>
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ex206 {
    //递归解决
    public ListNode reverseList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode reverseHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return reverseHead;
        } else
            return head;
    }

    //迭代解决
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
