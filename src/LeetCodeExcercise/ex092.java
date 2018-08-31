package LeetCodeExcercise;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ex092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = dummyHead;
        for (int i = 0; i < m - 1; i++) {
            first = first.next;
        }
        ListNode curr = first.next;
        for (int i = 0; i < n - m; i++) {
            ListNode node = curr.next;
            curr.next = node.next;
            node.next = first.next;
            first.next = node;
        }
        return dummyHead.next;
    }


    //解决的不好，不易理解，纯靠画图完成
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, s = head, t = head, curr = head;
        //构造结构
        //  1   ->  2   ->  3   ->  4   ->  5   ->  null, m=2, n=4
        //pre      preS     s               t
        for (int i = 1; (i <= n) && curr != null; i++) {
            if (i < m) pre = curr;
            curr = curr.next;
            t = curr;
        }
        ListNode preS;
        if (pre != null)
            preS = pre.next;
        else
            preS = head;
        s = preS.next;
        //把从s到t的前一个逆序
        //  1   ->  2  <-> 3   <-  4        5   ->  null, m=2, n=4
        //pre    preNext           preS     st
        ListNode preNext = preS;
        while (s != t && s != null) {
            ListNode temp = s.next;
            s.next = preS;
            preS = s;
            s = temp;
        }
        //最后整理链表顺序
        preNext.next = t;
        if (pre != null)
            pre.next = preS;
        else head = preS;
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
