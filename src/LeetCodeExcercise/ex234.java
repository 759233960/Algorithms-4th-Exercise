package LeetCodeExcercise;


/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class ex234 {
    public boolean isPalindrome(ListNode head) {
        //空链表或是单结点链表为true
        if (head == null || head.next == null) return true;
        //判断是否为奇数个数的链表
        boolean single = false;
        ListNode slow = head, fast = head;
        ListNode pre = null;
        //遍历链表slow至中序，并将pre作为前段逆序，若总结点数为count，则sum -> Node(i <= count/2)
        //i属于0 ~ count-1
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null)
                single = fast.next == null;
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }

        //如果为奇数链表，slow需要下移一位
        //1 2 1
        //P S ? F
        if (single) slow = slow.next;
        while (slow != null) {
            if (pre == null) return false;
            if (pre.val != slow.val) return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
