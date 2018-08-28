package LeetCodeExcercise;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ex024 {
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        if (head != null && head.next != null)
            head = head.next;
        while (curr != null && curr.next != null) {
            if (pre != null)
                pre.next = curr.next;
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = curr;
            pre = curr;
            curr = curr.next;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
