package LeetCodeExcercise;

/**
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 例如，下面的两个链表：
 * A:          a1 → a2
 *                      ↘
 *                          c1 → c2 → c3
 *                      ↗
 * B:     b1 → b2 → b3
 * 在节点 c1 开始相交。
 * <p>
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class ex160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //A + B = B + A;
        //(a+intersection)+(b+intersection)=(b+intersection)+(a+intersection)
        //遍历A+B 和 B+A，若相交,则最后必然会有相交点。
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p != null ? p.next : headB;
            q = q != null ? q.next : headA;
        }
        return p;
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
