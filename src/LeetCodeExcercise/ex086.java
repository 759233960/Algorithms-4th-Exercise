package LeetCodeExcercise;


/**
 * 86. 分隔链表 Partition List
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class ex086 {
    //不生成新链表，变化顺序为：
    //1 -> 4 -> 3 -> 2 -> 5 -> 2
    //1 -> 2 -> 4 -> 3 -> 5 -> 2
    //1 -> 2 -> 2 -> 4 -> 3 -> 5
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null && pre.next.val < x) {
            pre = pre.next;
        }
        ListNode large = pre.next;
        while (large != null && large.next != null) {
            if (large.next.val >= x) {
                large = large.next;
                continue;
            }
            ListNode small = large.next;
            large.next = small.next;
            small.next = pre.next;
            pre.next = small;
            pre = pre.next;
        }
        return dummyHead.next;
    }

    //生成新链表（比x小的创建新链表），变化顺序为：
    //Original: 1 -> 4 -> 3 -> 2 -> 5 -> 2
    //New:
    //Original: 4 -> 3 -> 2 -> 5 -> 2
    //New:      1
    //Original: 4 -> 3 -> 5 -> 2
    //New:      1 -> 2
    //Original: 4 -> 3 -> 5
    //New:      1 -> 2 -> 2
    //Original:
    //New:      1 -> 2 -> 2 -> 4 -> 3 -> 5
    public ListNode partition2(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode newHead = new ListNode(-1);
        ListNode large = dummyHead, small = newHead;
        while (large.next != null) {
            if (large.next.val < x) {
                small.next = large.next;
                small = small.next;
                large.next = large.next.next;
            } else {
                large = large.next;
            }
        }
        //连接小链表和大链表
        small.next = dummyHead.next;
        return newHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
