package LeetCodeExcercise;

/**
 * 25. k个一组翻转链表
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ex025 {
    //迭代解决
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode curr = head;
        int sum = 0;
        while (curr != null) {
            sum++;
            curr = curr.next;
        }
        while (sum >= k) {
            curr = pre.next;
            for (int i = 1; i < k; i++) {
                ListNode node = curr.next;
                curr.next = node.next;
                node.next = pre.next;
                pre.next = node;
            }
            pre = curr;
            sum -= k;
        }
        return dummyHead.next;
    }

    //递归解决
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode nextFirst = head;
        for (int i = 0; i < k; i++) {
            if (nextFirst == null) return head;
            nextFirst = nextFirst.next;
        }
        ListNode first = reverseList(head, nextFirst);
        head.next = reverseKGroup2(nextFirst, k);
        return first;
    }

    private ListNode reverseList(ListNode first, ListNode nextFirst) {
        ListNode pre = nextFirst;
        while (first != nextFirst) {
            ListNode temp = first.next;
            first.next = pre;
            pre = first;
            first = temp;
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
