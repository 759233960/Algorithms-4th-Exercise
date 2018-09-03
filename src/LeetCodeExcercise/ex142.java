package LeetCodeExcercise;

/**
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
public class ex142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return null;
        ListNode slow = head.next, fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                //检测到无环
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 检测到有环，a指head到环起点的距离，b指环起点到相交点距离，b+c为环的周长
        // a2(a+b)=a+b+n(b+c);a=(n-1)b+nc=(n-1)(b+c)+c;
        // 意味着从起点出发走a，必然与环内循环的点相交于环的起点。
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = slow;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
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
